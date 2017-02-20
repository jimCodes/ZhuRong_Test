package myJava.lang.Cloneable.compare;

public class Thing3 implements Cloneable {
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Thing3 can't clone");
		}
		return o;
	}
}
