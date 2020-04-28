package tp11;

import java.time.LocalDate;

public abstract class Salesperson extends Employee {
	private double turnover;
	private double objective;
	
	public Salesperson(String s, LocalDate d, double t) {
		super(s,d);
		this.turnover = t;
	}
	
	public double getTurnover() {
		return this.turnover;
	}
	
	//public abstract String getTitle();
	
	public String toString() {
		return super.toString();
	}
	
	public boolean objectiveFulfilled() {
		return  getWages() < this.objective ;
	}
	
}

