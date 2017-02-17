package java.concurrent.Semaphore.tryAcquire;

import java.lang.Override;
import java.lang.Thread;

public class ThreadB extends Thread {
	
	private Service service;
	
	public ThreadB(Service service){
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
}
