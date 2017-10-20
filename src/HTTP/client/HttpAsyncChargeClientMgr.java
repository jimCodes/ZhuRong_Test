package HTTP.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
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

public class HttpAsyncChargeClientMgr {
//	private static Logger log = LogManager.getLogger("ACTION");
	public static ConnectingIOReactor ioReactor;
	public static PoolingNHttpClientConnectionManager cm;
	public static CloseableHttpAsyncClient httpAsyncClient;

	public HttpAsyncChargeClientMgr() {

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
			    .setSocketTimeout(10000).setConnectTimeout(10000).build();
		httpAsyncClient = HttpAsyncClients.custom().setConnectionManager(cm)
				.setDefaultRequestConfig(requestConfig)
				.build();
		httpAsyncClient.start();
	}

	public static void close() {
		try {
			httpAsyncClient.close();
		} catch (IOException e) {
			
		}
	}
	
	public static void post(String url,final int playerId, HttpEntity http_entity,
			CallBack callBack, Object... callback_params) {
//		log.info(new StringBuffer(HallLog.apple_log).append(HallLog.player).append(playerId).append(",post begin"));
		final HttpPostData httpPost = new HttpPostData(url, callBack,
				callback_params);
		httpPost.setEntity(http_entity);
//		log.info(new StringBuffer(HallLog.apple_log).append(HallLog.player).append(playerId).append(",execute"));		
		httpAsyncClient.execute(httpPost, new FutureCallback<HttpResponse>() {
			public void completed(HttpResponse httpResp) {
				try {
//					log.info(new StringBuffer(HallLog.apple_log).append(HallLog.player).append(playerId).append(",completed"));
					String dataStr = "";
					Integer statusCode = httpResp.getStatusLine().getStatusCode();
//					log.info(new StringBuffer(HallLog.apple_log).append(HallLog.player).append(playerId).append(",statusCode:").append(statusCode));
					if (statusCode == 200) {
						dataStr = EntityUtils.toString(httpResp.getEntity());
//						log.info(new StringBuffer(HallLog.apple_log).append(HallLog.player).append(playerId).append(",dataStr:").append(dataStr));
						httpPost.callback.execute(httpPost.data, dataStr);
					}
				} catch (IOException e) {
					
				}finally{
					try {
						EntityUtils.consume(httpResp.getEntity());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						
					} finally {
						if (httpPost != null) {
							httpPost.releaseConnection();
						}
					}
				}
			}

			public void failed(final Exception ex) {
				System.out.println("HttpAsyncChargeClientMgr failed");
//				log.info(new StringBuffer(HallLog.apple_log).append(HallLog.player).append(playerId).append(",failed"));
				if(httpPost != null){
					httpPost.releaseConnection();
				}
			}

			public void cancelled() {
				System.out.println("HttpAsyncChargeClientMgr cancelled");
//				log.info(new StringBuffer(HallLog.apple_log).append(HallLog.player).append(playerId).append(",cancelled"));
				if(httpPost != null){
					httpPost.releaseConnection();
				}
			}
		});

	}
}
