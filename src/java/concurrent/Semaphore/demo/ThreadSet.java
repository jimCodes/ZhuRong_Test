package java.concurrent.Semaphore.demo;


public class ThreadSet extends Thread {
	
private RepastService repastService;
	
	public ThreadSet(RepastService repastService) {
		this.repastService = repastService;
	}
	
	@Override
	public void run() {
		super.run();
		repastService.set();
	}
}
