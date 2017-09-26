package sjms.strategy.behaviorimp;

import sjms.strategy.behavior.RunBehavior;

/**
 * 速度很慢
 * @author R.Zhu
 *
 */
public class RunSlow implements RunBehavior {

	@Override
	public void run() {
		System.out.println("run slowly");
	}

}
