package HTTP.client;

import org.apache.http.client.methods.HttpPost;

public class HttpPostData extends HttpPost{
	public Object[] data;
	public CallBack callback;
	public HttpPostData(String url, CallBack callback, Object... params) {
		super(url);
		this.data = params;
		this.callback = callback;
	}
	
}
