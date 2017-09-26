package test;

public class AtomicBooleanTest implements Runnable {

	private static boolean exists = false;

	private String name;

	public AtomicBooleanTest(String name) {
		this.name = name;
	}

	public void run() {
		if (!exists) {
			exists = true;
			System.out.println(name + " enter");
			System.out.println(name + " working");
			System.out.println(name + " leave");
			exists = false;
		} else {
			System.out.println(name + " give up");
		}
	}

}
