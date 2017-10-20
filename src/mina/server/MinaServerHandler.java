package mina.server;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MinaServerHandler extends IoHandlerAdapter {
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("exceptionCaught");
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String receiverContent = (String) message;
		System.out.println("服务端接收到的数据为：" + receiverContent);
		if("88".equals(receiverContent)){
			session.close();
		}
//		session.write("ok\r");
		session.write(new Date()+" \r");
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		System.out.println("messageSent");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("sessionClosed");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("sessionCreated");
	}

	/*
	 * 空闲状态
	 * Represents the session status that no data is coming from the remote
	 */
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		//Represents the session status that no data is coming from the remote
		System.out.println("sessionIdle:服务端进入空闲状态...");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("sessionOpened");
	}

}
