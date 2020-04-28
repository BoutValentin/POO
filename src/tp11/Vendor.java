package tp11;

import java.time.LocalDate;

public class Vendor extends Salesperson{
	private final double POURCENTAGE = 0.2;
	private final static int BONUS = 400;
	
	public Vendor(String s, LocalDate d, double t) {
		super(s,d,t);
	}
	
	public String getTitle() {
		return "Vendor";
	}
	
	public double getWages() {
		return this.POURCENTAGE * super.getTurnover() + Vendor.BONUS;
	}
	
	
}
