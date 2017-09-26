package myJava.lang.Cloneable;

import java.util.Enumeration;
import java.util.Vector;

public class AddingClone {
	class Test implements Cloneable {
		private int i;

		public Test(int ii) {
			i = ii;
		}

		public void increment() {
			i++;
		}

		public String toString() {
			return Integer.toString(i);
		}

		public Object clone() {
			Object o = null;
			try {
				o = super.clone();
			} catch (CloneNotSupportedException e) {
				System.out.println("Int2 can't clone");
			}
			return o;
		}
	}
	// Once it's cloneable, inheritance
	// doesn't remove cloneability:
	class Int3 extends Test {
		private int j; // Automatically duplicated

		public Int3(int i) {
			super(i);
		}
	}
//	public static void main(String[] args) {
//		// 测试
////		Test x = new Test(0);
//		Test x2 = (Test) x.clone();
//		x2.increment();
//		System.out.println("x = " + x + ", x2 = " + x2);
//		// Anything inherited is also cloneable:
//		Int3 x3 = new Int3(7);
//		x3 = (Int3) x3.clone();
//		Vector v = new Vector();
//		for (int i = 0; i < 10; i++)
//			v.addElement(new Test(i));
//		System.out.println("v: " + v);
//		Vector v2 = (Vector) v.clone();
//		// Now clone each element:
//		for (int i = 0; i < v.size(); i++)
//			v2.setElementAt(((Test) v2.elementAt(i)).clone(), i);
//		// Increment all v2's elements:
//		for (Enumeration e = v2.elements(); e.hasMoreElements();)
//			((Test) e.nextElement()).increment();
//		// See if it changed v's elements:
//		System.out.println("v: " + v);
//		System.out.println("v2: " + v2);
//	}




}
