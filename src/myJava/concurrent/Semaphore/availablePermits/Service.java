package myJava.concurrent.Semaphore.availablePermits;

import java.util.concurrent.Semaphore;

public class Service {
	//同一时间内，�?多允�?1个线程同事执行acquire（）和relase（）之间的代�?
	private Semaphore semaphore = new Semaphore(10);
	
	public void testMethod(){
		try{
			semaphore.acquire();//默认是使用一个许�?,有三个线程在跑，
			System.out.println(semaphore.availablePermits());//7
			semaphore.release();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
