package myJava.lang.Cloneable;

import java.util.Enumeration;
import java.util.Vector;

class Int {
	private int i;

	public Int(int ii) {
		i = ii;
	}

	public void increment() {
		i++;
	}

	public String toString() {
		return Integer.toString(i);
	}
}

public class Cloning {
	public static void main(String[] args) {
		Vector v = new Vector();
		for (int i = 0; i < 10; i++)
			v.addElement(new Int(i));
		System.out.println("v: " + v);
		System.out.println("*****************");
		Vector v2 = (Vector) v.clone();
		System.out.println("v2: " + v2);
		System.out.println(v == v2);
		System.out.println(v.equals(v2));
		System.out.println("------------------");
		// Increment all v2's elements:
		for (Enumeration e = v2.elements(); e.hasMoreElements();)
			((Int) e.nextElement()).increment();
		// See if it changed v's elements:
		System.out.println("v: " + v);
		System.out.println("v2: " + v2);
	}
} /// :~