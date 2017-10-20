package myJava.concurrent.Semaphore.drainPermits;

public class ThreadA extends Thread {
	
	private Service2 service;
	
	public ThreadA(Service2 service){
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
}
