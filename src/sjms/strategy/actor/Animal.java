package sjms.strategy.actor;

import sjms.strategy.behavior.RunBehavior;
import sjms.strategy.behavior.ShoutBehavior;

public abstract class Animal {
	protected RunBehavior runBehavior;

	protected ShoutBehavior shoutBehavior;

	// 不同的狗长相不一样
	public abstract void display();

	public void jump() {
		System.out.println("jump");
	}

	public void swim() {
		System.out.println("swim");
	}

//	public Animal(RunBehavior runBehavior, ShoutBehavior shoutBehavior) {
//		this.runBehavior = runBehavior;
//		this.shoutBehavior = shoutBehavior;
//	}

	public RunBehavior getRunBehavior() {
		return runBehavior;
	}

	public void setRunBehavior(RunBehavior runBehavior) {
		this.runBehavior = runBehavior;
	}

	public ShoutBehavior getShoutBehavior() {
		return shoutBehavior;
	}

	public void setShoutBehavior(ShoutBehavior shoutBehavior) {
		this.shoutBehavior = shoutBehavior;
	}

	public void performRun() {
		runBehavior.run();
	}

	public void performShout() {
		shoutBehavior.shout();
	}
}
