package HTTP.client;

import org.apache.http.client.methods.HttpGet;

public class HttpGetData extends HttpGet{
	public Object[] data;
	public CallBack callback;
	public HttpGetData(String url, CallBack callback, Object... params) {
		super(url);
		this.data = params;
		this.callback = callback;
	}
	
}
