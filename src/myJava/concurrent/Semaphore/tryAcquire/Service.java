package myJava.concurrent.Semaphore.tryAcquire;

import java.lang.Exception;
import java.lang.Math;
import java.lang.System;
import java.lang.Thread;
import java.util.concurrent.Semaphore;

public class Service {
	//同一时间内，�?多允�?1个线程同事执行acquire（）和relase（）之间的代�?
	private Semaphore semaphore = new Semaphore(2,true);//true:表示先启动的线程优先获得许可，false是无序的
	
	public void testMethod(){
		try{
			//tryArquire(sum,timeout,TimeUnit.SESONDS)指定的时间段内获得sum个许�?
			//tryArquire(timeout,TimeUnit.SESONDS)指定的时间段内获�?1个许�?
			//默认是使用一个许�?
			if(semaphore.tryAcquire(2)){
				System.out.println("ThreadName="+Thread.currentThread().getName() + "首先进入");
				for(int i=0;i<1;i++){
					//String newString = new String();
					Math.random();
				}
				semaphore.release(2);
			}else{
				System.out.println("ThreadName="+Thread.currentThread().getName() + "进入失败");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
