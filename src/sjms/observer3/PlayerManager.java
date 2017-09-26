package sjms.observer3;

import java.util.Observable;
import java.util.Observer;

public class PlayerManager implements Observer {
	private static PlayerManager playerManager = new PlayerManager();

	private PlayerManager() {
		// 向被观察者添加注册事件，当被观察者有变化时，会收到通知。
		MyObservable.getInstance().addObserver(this);
	}

	public static PlayerManager getInstance() {
		return playerManager;
	}

	public void update(Observable o, Object arg) {
		if (arg instanceof ObserverMsg) {
			ObserverMsg msg = (ObserverMsg) arg;
			if (msg.getType() == ObserverType.ADDEXP) {
				// 处理添加经验的事件
			}
		}
	}
}