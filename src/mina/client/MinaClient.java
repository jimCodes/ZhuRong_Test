package mina.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaClient {

	public static void main(String[] args) {
		MinaClient client = new MinaClient();
		client.initClient("127.0.0.1", 9898);
	}

	public void initClient(String host, int port) {
		NioSocketConnector connector = new NioSocketConnector();
		MinaClientHandler handler = new MinaClientHandler();
		// 设置过滤器（使用Mina提供的文本换行符编解码器）
//		指定参数为根据windows的换行符编解码，遇到客户端发送来的消息，看到windows换行符（\r\n）就认为是一个消息了，
//		而发送给客户端的消息，都会在消息末尾添加上\r\n文本换行符；
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"),
						LineDelimiter.WINDOWS.getValue(),LineDelimiter.WINDOWS.getValue())));
		connector.setHandler(handler);
		// 创建连接
		ConnectFuture future = connector.connect(new InetSocketAddress(host,
				port));
		// 阻塞直到连接建立,因为我们后面要使用连接成功之后创建的Session对象来进行写数据的操作
		future.awaitUninterruptibly();
		System.out.println("MinaClient start successfully");
		inputCommand(future);
	}
	
	@SuppressWarnings("resource")
	public void inputCommand(ConnectFuture future){
		IoSession session = future.getSession();// 获得Session对象
		Scanner scanner = new Scanner(System.in);
		while(true){
			String input = scanner.next();
			session.write(input);
		}
	}
}
