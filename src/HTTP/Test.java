package HTTP;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test {
	public static void main(String[] args) throws Exception {
		HttpGet get = new HttpGet("http://www.126.com");  
		
		// (2) 使用HttpClient发送get请求，获得返回结果HttpResponse  
		@SuppressWarnings({ "deprecation", "resource" })
		HttpClient http = new DefaultHttpClient();  
		HttpResponse response = http.execute(get);
		
		// (3) 读取返回结果  
		if (response.getStatusLine().getStatusCode() == 200) {  
			HttpEntity entity = response.getEntity();  
			InputStream in = entity.getContent();  
			readResponse(in);  
		}
		
	}

	private static void readResponse(InputStream in) {
		
	}
}
