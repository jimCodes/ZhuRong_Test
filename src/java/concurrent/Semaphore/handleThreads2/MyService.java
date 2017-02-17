package java.concurrent.Semaphore.handleThreads2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	
	private Semaphore semaphore =  new Semaphore(3);
	private ReentrantLock lock = new ReentrantLock();
	
	public void testMethod(){//多进路，单处理，多出�?
		try {
			semaphore.acquire();
//			System.out.println("还有"+semaphore.getQueueLength()+"个线程数�?");
//			System.out.println("是否有正在等待的线程"+semaphore.hasQueuedThreads());
			System.out.println("ThreadName:"+Thread.currentThread().getName()+"准备");
			lock.lock();
			System.out.println(Thread.currentThread().getName()+"begin:"+System.currentTimeMillis());
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName() + "打印" + (i+1));
			}
			System.out.println(Thread.currentThread().getName()+"end:"+System.currentTimeMillis());
			lock.unlock();
			semaphore.release();
			System.out.println(Thread.currentThread().getName() + "结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
