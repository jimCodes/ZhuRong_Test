package sjms.strategy2;

public class NicePolice implements Strategy {

	@Override
	public void processSpeeding(int speed) {
		System.out.println("NicePolice processSpeeding " + speed);
	}

}
