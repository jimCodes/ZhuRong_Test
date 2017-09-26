package myJava.concurrent.Semaphore.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RepastService {

	// 厨师
	volatile private Semaphore setSemaphore = new Semaphore(10);
	// 就餐�?
	volatile private Semaphore getSemaphore = new Semaphore(20);

	volatile private ReentrantLock lock = new ReentrantLock();

	volatile private Condition getCondition = lock.newCondition();

	volatile private Condition setCondition = lock.newCondition();
	// �?多只有四个盒子存放菜
	volatile private Object[] producePosition = new Object[4];

	private boolean isEmpty() {
		boolean isEmpty = true;
		for (int i = 0; i < producePosition.length; i++) {
			if (producePosition[i] != null) {
				isEmpty = false;
				break;
			}
		}
		return isEmpty;
	}

	private boolean isFull() {
		boolean isFull = true;
		for (int i = 0; i < producePosition.length; i++) {
			if (producePosition[i] == null) {
				isFull = false;
				break;
			}
		}
		return isFull;
	}

	//厨师生产�?
	public void set() {
		System.out.println("set()");
		try {
			setSemaphore.acquire();
			lock.lock();
			while(isFull()){
				System.out.println("饭盒已经满生产�?�在等待");
				setCondition.await();
			}
			for(int i=0;i<producePosition.length;i++){
				if(producePosition[i] == null){
					producePosition[i] = "数据"+i;
					System.out.println("线程"+Thread.currentThread().getName()+"生产�?"+producePosition[i]);
					break;
				}
			}
			getCondition.signalAll();
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			setSemaphore.release();
		}
		
	}

	public void get() {
		System.out.println("get()");
		try {
			getSemaphore.acquire();
			lock.lock();
			while(isEmpty()){
				System.out.println("饭盒已经空了，消费�?�在等待");
				getCondition.await();
			}
			for(int i=0;i<producePosition.length;i++){
				if(producePosition[i] != null){
					System.out.println("线程"+Thread.currentThread().getName()+"消费�?"+producePosition[i]);
					producePosition[i] = null;
					break;
				}
			}
			setCondition.signalAll();
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			getSemaphore.release();
		}
		
	}
}
