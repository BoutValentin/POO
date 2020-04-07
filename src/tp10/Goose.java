package tp10;

public class Goose extends Poultry {
	protected static double priceKg = 4;
	protected static double slaughterThreshold = 12;
	
	public Goose(int i, double d) {
		super(i,d);
	}
	public double getPriceKg() {
		return Goose.priceKg;
	}
	public double getSlaughterThreshold() {
		return Goose.slaughterThreshold;
	}
	public void updatePrice(double price) {
		Goose.priceKg=price;
	}
	public void updateSlaughterThreshold(double weight) {
		Goose.slaughterThreshold = weight;
	}
	public String toString() {
		return "[id:"+this.identity+",weigh:"+this.weight+",prixKg:"+this.priceKg+",poidAbatoir:"+this.slaughterThreshold+"]";
	}
}
