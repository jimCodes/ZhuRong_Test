package sjms.strategy.actor;

import sjms.strategy.behaviorimp.RunFast;
import sjms.strategy.behaviorimp.ShoutLoudly;

public class Dog extends Animal{

	public Dog() {
		runBehavior = new RunFast();
		shoutBehavior = new ShoutLoudly();
	}

	@Override
	public void display() {
		System.out.println("dog 的模样");
	}

}
