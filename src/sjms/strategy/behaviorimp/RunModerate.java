package sjms.strategy.behaviorimp;

import sjms.strategy.behavior.RunBehavior;

/**
 * 速度适中
 * @author R.Zhu
 *
 */
public class RunModerate implements RunBehavior {

	@Override
	public void run() {
		System.out.println("run moderate");

	}

}
