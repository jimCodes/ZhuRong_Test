package myJava.aop;

public class Business implements IBusiness, IBusiness2 {

	@Override
	public void doSomething2() {
		System.out.println("doSomething2");
	}

	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}

}
