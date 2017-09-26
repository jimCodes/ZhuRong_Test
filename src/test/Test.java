package test;
public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
			
	         Thread thread1 = new Thread() {  
	          public void run() {  
	           System.out.println("thread1...");  
	          }  
	         };  
	     
	         Thread thread2 = new Thread() {  
	          public void run() {  
	           System.out.println("thread2...");  
	          }  
	         };  
	     
	         Thread shutdownThread = new Thread() {  
	          public void run() {  
	           System.out.println("shutdownThread...");  
	          }  
	         };  
	     
	         Runtime.getRuntime().addShutdownHook(shutdownThread); 
	     
	         thread1.start();  
	         thread2.start();  
	         System.out.println("----------");
	         Thread.sleep(3000);
	         while(true){
	        	 System.out.println("@@@@@@");
	         }
	}
	
}
