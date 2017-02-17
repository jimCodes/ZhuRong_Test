package myJava.concurrent.Semaphore.acquireUninterruptibly;

import java.lang.InterruptedException;
import java.lang.System;
import java.lang.Thread;
import java.util.concurrent.Semaphore;

public class Service {
	//同一时间内，�?多允�?1个线程同事执行acquire（）和relase（）之间的代�?
	private Semaphore semaphore = new Semaphore(2);
	
	public void testMethod(){
		try{
//			semaphore.acquire();//默认是使用一个许�?
			semaphore.acquireUninterruptibly();//线程不允许被中断
			System.out.println(Thread.currentThread().getName() + " begin timer="+ System.currentTimeMillis());
			System.out.println("休息2�?");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() +"   end timer="+System.currentTimeMillis());
			semaphore.release();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
