package myJava.lang.Cloneable.compare;

import java.util.*;

/*添加克隆能力之前，编译器会阻止我们的克隆尝试。一旦在Scientist 里添加了克隆能力，那么Scientist
以及它的所有“后裔”都可以克隆。*/
class Person {
}

class Hero extends Person {
}

class Scientist extends Person implements Cloneable {
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// this should never happen:
			// It's Cloneable already!
			throw new InternalError();
		}
	}
}

class MadScientist extends Scientist {
}

public class HorrorFlick {
	public static void main(String[] args) {
		Person p = new Person();
		Hero h = new Hero();
		Scientist s = new Scientist();
		MadScientist m = new MadScientist();
//		 p = (Person)p.clone(); // Compile error
//		 h = (Hero)h.clone(); // Compile error
		s = (Scientist) s.clone();
		m = (MadScientist) m.clone();
	}
} /// :~
