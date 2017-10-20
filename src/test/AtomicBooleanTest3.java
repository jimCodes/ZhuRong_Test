package test;
import java.util.concurrent.TimeUnit;

public class AtomicBooleanTest3 implements Runnable {

	private static boolean exists = false;

	private String name;

	public AtomicBooleanTest3(String name) {
		this.name = name;
	}

	public void run() {  
		   if (!exists) {  
			    try {  
			     TimeUnit.SECONDS.sleep(1);  
			    } catch (InterruptedException e1) {  
			     // do nothing  
			    }  
			    exists = true;  
			    System.out.println(name + " enter");  
			    try {  
			     System.out.println(name + " working");  
			     TimeUnit.SECONDS.sleep(2);  
			    } catch (InterruptedException e) {  
			     // do nothing  
			    }  
			    System.out.println(name + " leave");  
			    exists = false;  
			   } else {  
			    System.out.println(name + " give up");  
			   }  }

}
