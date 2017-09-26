package myJava.concurrent.Semaphore.handleThreads;

import java.util.concurrent.Semaphore;

public class MyService {
	
	private Semaphore semaphore =  new Semaphore(3);
	
	public void testMethod(){//多进路，多处理，多出�?
		try {
			semaphore.acquire();
			System.out.println("还有"+semaphore.getQueueLength()+"个线程数�?");
			System.out.println("是否有正在等待的线程"+semaphore.hasQueuedThreads());
			System.out.println("ThreadName:"+Thread.currentThread().getName()+"准备");
			System.out.println(Thread.currentThread().getName()+"begin:"+System.currentTimeMillis());
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName() + "打印" + (i+1));
			}
			System.out.println(Thread.currentThread().getName()+"end:"+System.currentTimeMillis());
			semaphore.release();
			System.out.println(Thread.currentThread().getName() + "结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
