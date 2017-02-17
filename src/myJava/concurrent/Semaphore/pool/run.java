package myJava.concurrent.Semaphore.pool;

public class run {

	public static void main(String[] args) {

		ListPool listPool = new ListPool();
		MyThread[] myThread = new MyThread[5];
		for (int k = 0; k < myThread.length; k++) {
			myThread[k] = new MyThread(listPool);
		}
		for (int k = 0; k < myThread.length; k++) {
			myThread[k].start();
		}
	}

}
