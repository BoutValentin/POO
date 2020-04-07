package tp10;

public class Poultry {
	protected int identity;
	protected double weight;
	protected static double priceKg = 1.5;
	protected static double slaughterThreshold = 5;
	
	public Poultry(int id, double w) {
		this.identity = id;
		this.weight = w;
	}
	public double getPriceKg() {
		return Poultry.priceKg;
	}
	public double getSlaughterThreshold() {
		return Poultry.slaughterThreshold;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String toString() {
		return "[id:"+this.identity+",weigh:"+this.weight+",prixKg:"+this.priceKg+",poidAbatoir:"+this.slaughterThreshold+"]";
	}
	public void updatePrice(double price) {
		Poultry.priceKg=price;
	}
	public void updateSlaughterThreshold(double weight) {
		Poultry.slaughterThreshold = weight;
	}
}
