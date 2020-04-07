package tp10;

public class GuineaFowl extends Poultry{
	protected static double priceKg = 2;
	protected static double slaughterThreshold = 2.5;
	
	public GuineaFowl(int i, double d) {
		super(i,d);
	}
	public double getPriceKg() {
		return GuineaFowl.priceKg;
	}
	public double getSlaughterThreshold() {
		return GuineaFowl.slaughterThreshold;
	}
	public void updatePrice(double price) {
		GuineaFowl.priceKg=price;
	}
	public void updateSlaughterThreshold(double weight) {
		GuineaFowl.slaughterThreshold = weight;
	}
	public String toString() {
		return "[id:"+this.identity+",weigh:"+this.weight+",prixKg:"+this.priceKg+",poidAbatoir:"+this.slaughterThreshold+"]";
	}
}
