package myJava.concurrent.Semaphore.pool;

/**
 * @author R.Zhu
 *
 */
public class MyThread extends Thread {

	private ListPool listPool;

	public MyThread(ListPool listPool) {
		this.listPool = listPool;
	}

	@Override
	public void run() {
		super.run();
		for (int k = 0; k < 50; k++) {
			String value = listPool.get();
			System.out.println(Thread.currentThread().getName()+","+value);
			listPool.put(value);
		}
	}

}
