package sjms.observer3;

import java.util.Observable;

/**
 * 抽象主题(Subject)角色
 * 
 *
 */

public class MyObservable extends Observable {

	private static MyObservable observable = new MyObservable();

	private MyObservable() {
	}

	public static MyObservable getInstance() {
		return observable;
	}

	/**
	 * 当有事件发生时，调用这个方法，它会通知所有的观察者
	 * 
	 * @author youxijishu.com
	 * @param msg
	 *            2016年10月16日下午9:43:34
	 */
	public void change(ObserverMsg msg) {
		this.notifyObservers(msg);
	}
}