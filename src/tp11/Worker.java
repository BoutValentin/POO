package tp11;

import java.time.LocalDate;

public class Worker extends Employee{
	
	private final static double BY_UNIT = 5.0;
	private int units;
	private int objective;
	
	public Worker(String s, LocalDate d, int i) {
		super(s,d);
		this.units = i;
	}
	public String getTitle() {
		return "Worker";
	}
	public String toString() {
		return super.toString();
	}
	public double getWages() {
		return Worker.BY_UNIT * units;
	}
	public boolean objectiveFulfilled() {
		return this.getWages() < this.objective;
	}
}
