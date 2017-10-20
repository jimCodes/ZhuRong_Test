package HTTP.client;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.nio.conn.NoopIOSessionStrategy;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.http.util.EntityUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class HttpAsyncClientMgr {
//	private static Logger log = LogManager.getLogger("ACTION");
	public static ConnectingIOReactor ioReactor;
	public static PoolingNHttpClientConnectionManager cm;
	public static CloseableHttpAsyncClient httpAsyncClient;

	public HttpAsyncClientMgr() {

	}

	public static void Init() {
		try {
			IOReactorConfig ioReactorConfig = IOReactorConfig
                    .custom().setIoThreadCount(100).build();
			ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
		} catch (IOReactorException e) {
			// TODO Auto-generated catch block
			
		}
		SSLContext sslcontext = null;
		try {
			sslcontext = createIgnoreVerifySSL();
		} catch (KeyManagementException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 设置协议http和https对应的处理socket链接工厂的对象
		Registry<SchemeIOSessionStrategy> sessionStrategyRegistry = RegistryBuilder
						.<SchemeIOSessionStrategy> create()
						.register("http", NoopIOSessionStrategy.INSTANCE)
						.register("https", new SSLIOSessionStrategy(sslcontext))
						.build();
				
		cm = new PoolingNHttpClientConnectionManager(ioReactor, null,
				sessionStrategyRegistry, null);
		cm.setMaxTotal(30);
		cm.setDefaultMaxPerRoute(20);
		RequestConfig requestConfig = RequestConfig.custom()
			    .setSocketTimeout(5000).setConnectTimeout(5000).build();
		
		httpAsyncClient = HttpAsyncClients.custom().setConnectionManager(cm)
				.setDefaultRequestConfig(requestConfig)
				.build();
		httpAsyncClient.start();
	}
	/**
	 * 绕过验证
	 * 	
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");

		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		sc.init(null, new TrustManager[] { trustManager }, null);
		return sc;
	}
	public static void close() {
		try {
			httpAsyncClient.close();
		} catch (IOException e) {
			
		}
	}

	public static void Post(String url, Map<String, String> url_params,
			CallBack callBack, Object... callback_params) {
		if (url_params == null || url_params.isEmpty()) {
			return;
		}
		final HttpPostData httpPost = new HttpPostData(url, callBack,
				callback_params);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (String key : url_params.keySet()) {
			String value = url_params.get(key);
			nvps.add(new BasicNameValuePair(key, value));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
		httpAsyncClient.execute(httpPost, new FutureCallback<HttpResponse>() {
			public void completed(HttpResponse httpResp) {
				try {
					String dataStr = "";
					Integer statusCode = httpResp.getStatusLine().getStatusCode();
					if (statusCode == 200) {
						dataStr = EntityUtils.toString(httpResp.getEntity(), "utf-8");
					}
					httpPost.callback.execute(httpPost.data, dataStr);
				} catch (IOException e) {
					
				}finally{
					try {
						EntityUtils.consume(httpResp.getEntity());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					} finally {
						if (httpPost != null) {
							httpPost.releaseConnection();
						}
					}
				}
			}

			public void failed(final Exception ex) {
				if(httpPost != null){
					httpPost.releaseConnection();
				}
//				log.error("HttpAsyncClientMgr failed", ex);
			}

			public void cancelled() {
				if(httpPost != null){
					httpPost.releaseConnection();
				}
			}
		});
	}
}
