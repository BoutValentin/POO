package tp11;

import java.time.LocalDate;

public class TravellingSalesperson extends Salesperson {
	private final double POURCENTAGE = 0.2;
	private final static int BONUS = 800;
	
	public TravellingSalesperson(String s, LocalDate d, double t) {
		super(s,d,t);
	}
	
	public String getTitle() {
		return "Travelling Salesperson";
	}
	
	public double getWages() {
		return this.POURCENTAGE * super.getTurnover() + TravellingSalesperson.BONUS;
	}
	
}
