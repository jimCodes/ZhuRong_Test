package groovy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class testTaobaoIp {

	public static void main(String[] args) {
		String url = "http://127.0.0.1:9000/groovycode";
		String content = getReturnArea(url);
		System.out.println(content);
	}

	private static String getReturnArea(String url) {
		String x = 
				" package com.game.groovy;"
						+"\r\n\t"
						+" import com.game.player.manager.PlayerManager;"
						+"\r\n\t"
						+" import com.game.server.config.GameConfig;"
						+"\r\n\t"
						+" "
						+"\r\n\t"
						+" public class GroovyExcutor implements IGameGroovy {"
						+"\r\n\t"
						+" "
						+"\r\n\t"
						+" @Override"
						+"\r\n\t"
						+" public void execute() {"
						+"\r\n\t"
						+" try {"
						+"\r\n\t"
						+" System.out.println(\"nihao\");"
						+"\r\n\t"
						+" System.out.println(PlayerManager.gameOnlineNumber(1));"
						+"\r\n\t"
						+" GameConfig.hallOnlineExt=10;"
						+"\r\n\t"
						+" } catch (Exception e) {"
						+"\r\n\t"
						+" e.printStackTrace();"
						+"\r\n\t"
						+" }"
						+"\r\n\t"
						+" }"
						+"\r\n\t"
						+" }"
						+"\r\n\t"


						;
		URL burl = null;
		HttpURLConnection connection = null;
		StringBuffer returnValue = new StringBuffer();
		try {
			burl = new URL(url);
			connection = (HttpURLConnection) burl.openConnection();
			connection.setConnectTimeout(2000);
			connection.setReadTimeout(12000);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");			
			connection.setUseCaches(false);
			connection.connect();
			OutputStreamWriter dateOutputStream = new OutputStreamWriter(connection.getOutputStream());

			dateOutputStream.write(x);

			
			dateOutputStream.flush();
			dateOutputStream.close();
			new InputStreamReader(connection.getInputStream(), "utf-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			
			br.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return returnValue.toString();
	}

}
