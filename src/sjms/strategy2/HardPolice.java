package sjms.strategy2;

public class HardPolice implements Strategy {

	@Override
	public void processSpeeding(int speed) {
		System.out.println("HardPolice processSpeeding " + speed);
	}

}
