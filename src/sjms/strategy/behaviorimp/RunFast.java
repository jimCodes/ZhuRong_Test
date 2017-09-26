package sjms.strategy.behaviorimp;

import sjms.strategy.behavior.RunBehavior;

/**
 * 速度很快
 * @author R.Zhu
 *
 */
public class RunFast implements RunBehavior{

	@Override
	public void run() {
		System.out.println("run fast");
	}

}
