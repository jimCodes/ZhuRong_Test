package sjms.observer2.imple;


import sjms.observer2.interfaces.DisplayElement;
import sjms.observer2.interfaces.Observer;
import sjms.observer2.interfaces.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		disPlayer();
	}

	@Override
	public void disPlayer() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}

}