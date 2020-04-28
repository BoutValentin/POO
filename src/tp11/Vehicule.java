package tp11;

public abstract class Vehicule {
	private final String BRAND;
	private boolean hitchPossible;
	private double dailyRent;
	
	public Vehicule(String brand, boolean h, double dR) {
		this.BRAND = brand;
		this.hitchPossible = h;
		this.dailyRent = dR;
	}

	public boolean hitchPossible() {
		return hitchPossible;
	}

	public void updateHitch() {
		this.hitchPossible = !hitchPossible;
	}
	

	public double getDailyRent() {
		return dailyRent;
	}

	public void setDailyRent(double dailyRent) {
		this.dailyRent = dailyRent;
	}

	public String getBRAND() {
		return BRAND;
	}
	public String toString() {
		return "["+this.getBRAND()+"("+this.hitchPossible+")="+this.getDailyRent()+"e/day]";
	}
	
}
