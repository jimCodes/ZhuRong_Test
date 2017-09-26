package HTTP.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.game.util.Constants;

public class HttpClientPack {

//	private static Logger log = LogManager.getLogger("ACTION");

	private CloseableHttpClient httpclient;
	private HttpPost httpPost;
	private HttpGet httpGet;
	private HttpResponse httpResp;

	public HttpClientPack() {
		// TODO Auto-generated constructor stub
	}

	public Object post(String url, Map<String, String> params) {
		Object ret = null;

		if (params == null || params.isEmpty()) {
			return ret;
		}

		httpclient = HttpClients.createDefault();

		httpPost = new HttpPost(url);

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		for (String key : params.keySet()) {

			String value = params.get(key);

			nvps.add(new BasicNameValuePair(key, value));

		}

		httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));

		try {

			httpResp = httpclient.execute(httpPost);
			Integer statusCode = httpResp.getStatusLine().getStatusCode();

			if (statusCode == 200) {

				String dataStr = EntityUtils.toString(httpResp.getEntity(),"UTF-8");
//						Constants.charset);

//				log.debug("accserver,postRecieve:" + dataStr);

				if (dataStr != null && !dataStr.equals("")) {
					ret = dataStr;
				}

			}

			EntityUtils.consume(httpResp.getEntity());

		} catch (Exception e) {
			
		} finally {
			httpPost.releaseConnection();

			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
		}

		return ret;
	}

	public Object get(String url, Map<String, String> params) {
		Object ret = null;

		if (params == null || params.isEmpty()) {
			return ret;
		}
		url += "?";
		httpclient = HttpClients.createDefault();
		boolean first = true;
		for (String key : params.keySet()) {
			String value = params.get(key);
			if (first) {
				first = false;
				url = url + key + "=" + value;
			}

			url = url + "&" + key + "=" + value;
		}

		httpGet = new HttpGet(url);

		try {

			httpResp = httpclient.execute(httpGet);
			Integer statusCode = httpResp.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				String dataStr = EntityUtils.toString(httpResp.getEntity());

//				log.debug("accserver,getRecieve:" + dataStr);

				if (dataStr != null && !dataStr.equals("")) {
					ret = dataStr;
				}
			}

			EntityUtils.consume(httpResp.getEntity());

		} catch (Exception e) {
			
		} finally {
			httpGet.releaseConnection();

			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
		}

		return ret;
	}
}
