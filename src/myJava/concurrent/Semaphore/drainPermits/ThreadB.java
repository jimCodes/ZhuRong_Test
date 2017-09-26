package myJava.concurrent.Semaphore.drainPermits;

public class ThreadB extends Thread {
	
	private Service2 service;
	
	public ThreadB(Service2 service){
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
}
