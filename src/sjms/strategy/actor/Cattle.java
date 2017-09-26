package sjms.strategy.actor;

import sjms.strategy.behaviorimp.RunSlow;
import sjms.strategy.behaviorimp.ShoutModerate;

public class Cattle extends Animal {

	public Cattle() {
		runBehavior = new RunSlow();
		shoutBehavior = new ShoutModerate();
	}

	@Override
	public void display() {
			System.out.println("cattle 模样");
	}

}
