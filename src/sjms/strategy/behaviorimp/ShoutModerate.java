package sjms.strategy.behaviorimp;

import sjms.strategy.behavior.ShoutBehavior;

/**
 * 音量适中
 * @author R.Zhu
 *
 */
public class ShoutModerate implements ShoutBehavior {

	@Override
	public void shout() {
		System.out.println("shout moderate");

	}

}
