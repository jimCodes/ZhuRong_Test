package mina.server;

import java.net.InetSocketAddress;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {
		
	Logger log = LogManager.getLogger(MinaServer.class);
	
	public static void main(String[] args) {
		MinaServer minaServer = new MinaServer();
		minaServer.initMinaServer(9898);
	}
	
	
	
	
	public void initMinaServer(int port) {
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		MinaServerHandler minaServerHandler = new MinaServerHandler();
		try{
			//为NioSocketAcceptor对象添加Filter对象，这个Filter可以认为是二进制数据与对象之间的转换器，可以设置多个，
			//可以使用框架自带的，我们也可以自己写，在这里我们使用框架自带的；
			acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
			// 设置读取数据的缓冲区大小
			acceptor.getSessionConfig().setReadBufferSize(2084);
			// 读写通道10秒内无操作进入空闲状态
			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
			acceptor.setHandler(minaServerHandler);
			acceptor.bind(new InetSocketAddress(port));
			System.out.println("MinaServer start successfully");
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	
}

