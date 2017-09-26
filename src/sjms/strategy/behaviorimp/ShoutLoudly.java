package sjms.strategy.behaviorimp;

import sjms.strategy.behavior.ShoutBehavior;

/**
 * 大声叫
 * @author R.Zhu
 *
 */
public class ShoutLoudly implements ShoutBehavior {

	@Override
	public void shout() {
		System.out.println("shout loudly");
	}

}
