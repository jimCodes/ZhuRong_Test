package myJava.concurrent.Semaphore.queue;

public class Run {
	public static void main(String[] args) {
		MyService service = new MyService();
		
//		MyThread firstThread = new MyThread(service);
//		firstThread.start();
//		System.out.println("============");
		MyThread[] firstThread2 = new MyThread[4];
		for(int i=0;i<4;i++){
			firstThread2[i] = new MyThread(service);
			firstThread2[i].start();
		}
	}
}
