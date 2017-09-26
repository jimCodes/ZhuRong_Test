package sjms.strategy.behaviorimp;

import sjms.strategy.behavior.ShoutBehavior;

/**
 * 狗不叫
 * @author R.Zhu
 *
 */
public class ShoutSliently implements ShoutBehavior {

	@Override
	public void shout() {
		System.out.println("shout sliently");
	}

}
