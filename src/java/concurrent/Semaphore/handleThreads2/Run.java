package java.concurrent.Semaphore.handleThreads2;

public class Run {
	public static void main(String[] args) {
		MyService service = new MyService();
		
//		MyThread firstThread = new MyThread(service);
//		firstThread.start();
//		System.out.println("============");
		MyThread[] firstThread2 = new MyThread[14];
		for(int i=0;i<14;i++){
			firstThread2[i] = new MyThread(service);
			firstThread2[i].start();
		}
	}
}
