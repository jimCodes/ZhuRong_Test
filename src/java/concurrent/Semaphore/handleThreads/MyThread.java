package java.concurrent.Semaphore.handleThreads;

public class MyThread extends Thread{
	
	private MyService myService;
	
	public MyThread(MyService myService){
		this.myService = myService;
	}
	
	@Override
	public void run() {
		myService.testMethod();
	}
}
