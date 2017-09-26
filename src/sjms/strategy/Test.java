package sjms.strategy;

import sjms.strategy.actor.Animal;
import sjms.strategy.actor.Cat;
import sjms.strategy.actor.Cattle;
import sjms.strategy.actor.Dog;

public class Test {
	public static void main(String[] args) {
		Animal animal1 = new Cat();
		Animal animal2 = new Dog();
		Animal animal3 = new Cattle();
		System.out.println("--------------cat------------");
		animal1.display();
		animal1.jump();
		animal1.swim();
		animal1.performRun();
		animal1.performShout();
		
		
		
		System.out.println("--------------dog------------");
		animal2.display();
		animal2.jump();
		animal2.swim();
		animal2.performRun();
		animal2.performShout();
		
		System.out.println("--------------cattle------------");
		animal3.display();
		animal3.jump();
		animal3.performRun();
		animal3.swim();
		animal3.performShout();
		
	}
}
