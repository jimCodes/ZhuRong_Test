package HTTP.TEST;

import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.http.client.methods.HttpGet;

import com.sun.jndi.toolkit.url.UrlUtil;

import jdk.nashorn.internal.runtime.URIUtils;
import sun.net.util.URLUtil;

public class HttpGetTest {
	
	public static void main(String[] args) {
		HttpGet hg = new HttpGet("www.baidu.com");
		System.out.println(hg.getURI());
		//"http", "www.google.com", -1,
//		"/search",
//		"q=httpclient&btnG=Google+Search&aq=f&oq=", null
//	    URI url = URIUtils.createURI("http", "www.google.com", -1, "/search", "q=httpclient&btnG=Google+Search&aq=f&oq=", null);
//	    URI uri = URIUtils.createURI("http", "www.google.com", -1,
//	    		"/search",
//	    		"q=httpclient&btnG=Google+Search&aq=f&oq=", null);
		
	}
}
