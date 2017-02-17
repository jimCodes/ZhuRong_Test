package java.concurrent.Semaphore.tryAcquire;

import java.lang.Override;
import java.lang.Thread;

public class ThreadC extends Thread {
	
	private Service service;
	
	public ThreadC(Service service){
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
}
