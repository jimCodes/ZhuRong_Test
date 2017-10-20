package sjms.observer3;

/**
 * 
 *  游戏中观察者模式
 */
public class ItemManager {
	
	public void userItem(long playerId, int itemid) {

		Item item = this.getItem(playerId, itemid);
		if (item != null) {
			if (item.getType == 2) {
				ObserverMsg msg = new ObserverMsg();
				msg.setExp(item.getExp);
				msg.setPlayerId(playerId);
				msg.setType(ObserverType.ADDEXP);
				// 发送变更的事件，通知所有观察者添加这么多经验，观察者根据自己的需要处理这个事件
				MyObservable.getInstance().change(msg);
			}
		}
	}

	private Item getItem(long playerId, int itemid) {
		return null;
	}
}
