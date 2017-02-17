package myJava.concurrent.Semaphore.drainPermits;

public class Run2 {

	public static void main(String[] args) {
		Service2 service = new Service2();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		ThreadB b = new ThreadB(service);
		b.setName("B");
		ThreadC c = new ThreadC(service);
		c.setName("C");
		
//		a.start();
//		b.start();
		c.start();
	}

}
