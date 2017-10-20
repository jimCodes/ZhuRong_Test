/**
 * 
 */
package myJava.concurrent.MyExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author R.Zhu
 * 	
 * 2017年9月22日
 */
public class MyExecutor {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			final int count = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程:"+Thread.currentThread().getName()+"负责了"+count+"任务");
				}
			});
			Thread.sleep(1000); 
		}
		executorService.awaitTermination(1500, TimeUnit.SECONDS);
		executorService.shutdownNow();
	}
}
