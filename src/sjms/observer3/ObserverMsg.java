package sjms.observer3;

public class ObserverMsg {
	private long playerId;
	private ObserverType type;
	private int exp;

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public ObserverType getType() {
		return type;
	}

	public void setType(ObserverType type) {
		this.type = type;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
}