package myJava.concurrent.Semaphore.acquire;

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
