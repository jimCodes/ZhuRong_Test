package java.concurrent.Semaphore.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author R.Zhu
 *
 */
public class ListPool {
	private int poolMaxSize = 5;
	private int semaphorePermits = 1;
	private List<String> list = new ArrayList<String>();
	private Semaphore concurrencySemaphore = new Semaphore(semaphorePermits);
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public ListPool() {
		super();
		for (int i = 0; i < poolMaxSize; i++) {
			list.add("poolIndex" + (i + 1));
		}
	}

	public String get() {
		String getString = null;
		try {
			concurrencySemaphore.acquire();
			lock.lock();
			while (list.size() == 0) {
				condition.await();
			}
			getString = list.remove(0);
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getString;
	}

	public void put(String stringValue) {
		lock.lock();
		list.add(stringValue);
		condition.signalAll();
		lock.unlock();
		concurrencySemaphore.release();
	}
	
	public static void main(String[] args){
		ListPool listPool = new ListPool();
		ReentrantLock mainLock = listPool.lock;
		mainLock.lock();
		mainLock.lock();
		
		System.out.println(mainLock.getQueueLength());
		
	}
}
