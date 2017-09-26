package myJava.concurrent.Semaphore.tryAcquire;

import java.lang.Override;
import java.lang.Thread;

public class ThreadA extends Thread {
	
	private Service service;
	
	public ThreadA(Service service){
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
}
