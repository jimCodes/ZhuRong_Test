/**
 * 
 */
package myJava.concurrent.Collectionss;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author R.Zhu
 * 	
 * 2017年9月25日
 */
public class Producer implements Runnable {
	public static void main(String[] args) {
		BlockingQueue q = new LinkedBlockingQueue();
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
		
	}
	
	
	   private final BlockingQueue queue;
	   Producer(BlockingQueue q) { queue = q; }
	   public void run() {
	     try {
	       while(true) { queue.put(produce()); }
	     } catch (InterruptedException ex) { 
	    	 ex.printStackTrace();
	     }
	   }
	   public Object produce() {
		   System.out.println("put success");
		   return new Object();
	   }
	 }

	 class Consumer implements Runnable {
	   private final BlockingQueue queue;
	   Consumer(BlockingQueue q) { queue = q; }
	   public void run() {
	     try {
	       while(true) { consume(queue.take()); }
	     } catch (InterruptedException ex) { 
	    	 ex.printStackTrace();
	     }
	   }
	   void consume(Object x) {
		   System.out.println("consume");
	   }
	 }

