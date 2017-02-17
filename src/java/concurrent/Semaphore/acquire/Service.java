package java.concurrent.Semaphore.acquire;

import java.util.concurrent.Semaphore;

public class Service {
	//同一时间内，�?多允�?1个线程同事执行acquire（）和relase（）之间的代�?
	private Semaphore semaphore = new Semaphore(1,true);//true:表示先启动的线程优先获得许可，false是无序的
	
	public void testMethod(){
		try{
			semaphore.acquire();//默认是使用一个许�?
			System.out.println(Thread.currentThread().getName() + " begin timer="+ System.currentTimeMillis());
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() +"   end timer="+System.currentTimeMillis());
			semaphore.release();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
