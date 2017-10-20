package sjms.observer2.interfaces;

public interface Subject {
	/**
	 * 这两个方法都需要一个观察 者作为变量，该观察者是用 来注册或被删除的
	 */
	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	/**
	 * 当主题状态改变时，这个方法会被 调用，以通知所有的观察者。
	 */
	public void notifyObservers();
}
