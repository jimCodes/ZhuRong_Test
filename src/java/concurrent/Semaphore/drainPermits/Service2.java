package java.concurrent.Semaphore.drainPermits;

import java.util.concurrent.Semaphore;

public class Service2 {
	//同一时间内，�?多允�?1个线程同事执行acquire（）和relase（）之间的代�?
	private Semaphore semaphore = new Semaphore(10);
	
	public void testMethod(){
		try{
			semaphore.acquire();//默认是使用一个许�?,有三个线程在跑，
			System.out.println("availablePermits:"+semaphore.availablePermits());//7
			System.out.println(semaphore.drainPermits() + ","+semaphore.availablePermits());
			System.out.println(semaphore.drainPermits() + ","+semaphore.availablePermits());
			System.out.println(semaphore.drainPermits() + ","+semaphore.availablePermits());
			System.out.println("-------------------");
			semaphore.release();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
