package HTTP.client;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.http.util.EntityUtils;

public class HttpAsyncClientGetMgr {
	public static ConnectingIOReactor ioReactor;
	public static PoolingNHttpClientConnectionManager cm;
	public static CloseableHttpAsyncClient httpAsyncGetClient;

	public HttpAsyncClientGetMgr() {

	}

	public static void Init() {
		try {
			ioReactor = new DefaultConnectingIOReactor();
		} catch (IOReactorException e) {
			// TODO Auto-generated catch block
			
		}

		cm = new PoolingNHttpClientConnectionManager(ioReactor);
		cm.setMaxTotal(100);
		cm.setDefaultMaxPerRoute(20);
		RequestConfig requestConfig = RequestConfig.custom()
			    .setSocketTimeout(5000).setConnectTimeout(5000).build();
		httpAsyncGetClient = HttpAsyncClients.custom().setConnectionManager(cm)
				.setDefaultRequestConfig(requestConfig)
				.build();
		httpAsyncGetClient.start();
	}

	public static void close() {
		try {
			httpAsyncGetClient.close();
		} catch (IOException e) {
			
		}
	}

	public static void Get(final String url,
			CallBack callBack, Object... callback_params) {
		if (url == null) {
			return;
		}
		final HttpGetData httpGet = new HttpGetData(url, callBack,
				callback_params);

		httpAsyncGetClient.execute(httpGet, new FutureCallback<HttpResponse>() {
			public void completed(HttpResponse httpResp) {
				try {
					String dataStr = "";
					Integer statusCode = httpResp.getStatusLine().getStatusCode();
					if (statusCode == 200) {
						dataStr = EntityUtils.toString(httpResp.getEntity());
						httpGet.callback.execute(httpGet.data, dataStr);
					}
				} catch (IOException e) {
					
				}finally{
					try {
						EntityUtils.consume(httpResp.getEntity());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						
					} finally {
						if (httpGet != null) {
							httpGet.releaseConnection();
						}
					}
				}
			}

			public void failed(final Exception ex) {
				System.out.println("HttpAsyncClientGetMgr failed 1");
				if(httpGet != null){
					httpGet.releaseConnection();
				}
			}

			public void cancelled() {
				System.out.println("HttpAsyncClientGetMgr cancelled 1");
				if(httpGet != null){
					httpGet.releaseConnection();
				}
			}
		});
	}
}
