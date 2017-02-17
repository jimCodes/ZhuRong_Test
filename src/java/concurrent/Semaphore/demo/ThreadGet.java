package java.concurrent.Semaphore.demo;

public class ThreadGet extends Thread {
	
	private RepastService repastService;
	
	public ThreadGet(RepastService repastService) {
		this.repastService = repastService;
	}
	@Override
	public void run() {
		super.run();
		repastService.get();
	}
}
