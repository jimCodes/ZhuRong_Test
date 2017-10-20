/**
 * 
 */
package myJava.concurrent.MyExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author R.Zhu
 * 
 *         2017年9月26日
 */
public class FutureTest {
	public static class Task implements Callable<String> {

		@Override
		public String call() throws Exception {
			System.out.println("做任务----" + Thread.currentThread().getName());
			return "返回运算结果";
		}

	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		List<Future<String>> result = new ArrayList<Future<String>>();

		// 创建线程池
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			result.add(es.submit(new Task()));
		}
//		Thread.sleep(2000);
		for (Future<String> f : result) {
			System.out.println(f.isDone());
		}
	}
}
