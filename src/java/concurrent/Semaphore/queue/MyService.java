package java.concurrent.Semaphore.queue;

import java.util.concurrent.Semaphore;

public class MyService {
	
	private Semaphore semaphore =  new Semaphore(1);
	
	public void testMethod(){
		try {
			semaphore.acquire();
			Thread.sleep(1000);
			System.out.println("还有"+semaphore.getQueueLength()+"个线程数�?");
			System.out.println("是否有正在等待的线程"+semaphore.hasQueuedThreads());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
	}
}
