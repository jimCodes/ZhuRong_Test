package sjms.strategy.actor;

import sjms.strategy.behaviorimp.RunModerate;
import sjms.strategy.behaviorimp.ShoutSliently;

public class Cat extends Animal {

	public Cat(){
		runBehavior = new RunModerate();
		shoutBehavior = new ShoutSliently();
	}

	@Override
	public void display() {
		System.out.println("cat 的模样");
	}
	
}
