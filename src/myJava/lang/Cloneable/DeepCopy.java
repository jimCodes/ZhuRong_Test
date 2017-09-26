package myJava.lang.Cloneable;

/**
 * 克隆合成对象  《Think in java》
 * @author R.Zhu
 *
 */
class DepthReading implements Cloneable {
	private double depth;

	public DepthReading(double depth) {
		this.depth = depth;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public double getDepth() {
		return depth;
	}
	
}

class TemperatureReading implements Cloneable {
	private long time;
	private double temperature;

	public TemperatureReading(double temperature) {
		time = System.currentTimeMillis();
		this.temperature = temperature;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public long getTime() {
		return time;
	}

	public double getTemperature() {
		return temperature;
	}
	
}

class OceanReading implements Cloneable {
	private DepthReading depth;
	private TemperatureReading temperature;

	public OceanReading(double tdata, double ddata) {
		temperature = new TemperatureReading(tdata);
		depth = new DepthReading(ddata);
	}

	public Object clone() {
		OceanReading o = null;
		try {
			o = (OceanReading) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// Must clone handles:
		o.depth = (DepthReading) o.depth.clone();
		o.temperature = (TemperatureReading) o.temperature.clone();
		return o; // Upcasts back to Object
	}

	public DepthReading getDepth() {
		return depth;
	}

	public TemperatureReading getTemperature() {
		return temperature;
	}
	
}

public class DeepCopy {
	public static void main(String[] args) {
		OceanReading reading = new OceanReading(33.9, 100.5);
		// Now clone it:
		OceanReading r = (OceanReading) reading.clone();
		System.out.println(reading.equals(r));
		System.out.println(reading.getDepth().getDepth());
		System.out.println(r.getDepth().getDepth());
	}
} /// :~