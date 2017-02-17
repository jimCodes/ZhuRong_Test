package java.concurrent.Semaphore.drainPermits;

public class ThreadC extends Thread {
	
	private Service2 service;
	
	public ThreadC(Service2 service){
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		service.testMethod();
	}
}
