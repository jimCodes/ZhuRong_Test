package myJava.concurrent.Semaphore.acquire;

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
