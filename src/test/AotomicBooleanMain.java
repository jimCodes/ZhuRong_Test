package test;

public class AotomicBooleanMain {
	
	public static void main(String[] args) {
		AtomicBooleanTest test = new AtomicBooleanTest("张三");
		test.run();
		System.out.println("----------------------");
		AtomicBooleanTest2 test2 = new AtomicBooleanTest2("张三");
		test2.run();
		System.out.println("----------------------");
		AtomicBooleanTest3 test3 = new AtomicBooleanTest3("张三");
		test3.run();
		
		
	}
}
