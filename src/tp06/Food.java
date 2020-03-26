package tp06;

import java.time.LocalDate;

public class Food implements IProduct{
	
	private static int numbUnknow;
	private String label;
	private double price;
	private LocalDate bestBeforeDate;
	@Override
	public double getPrice() {
		
		return this.price;
	}
	@Override
	public boolean isPerishable() {
		
		return true;
	}
	
	public Food(String label, double price, LocalDate date) {
		if(label==null) {
			this.label="refUnkown"+ Food.numbUnknow;
			Food.numbUnknow++;
		}else {
			this.label=label;
		}
		this.price = price;
		this.bestBeforeDate = date;
	}
	
	public Food(String label, double price) {
		this(label, price, LocalDate.now().plusDays(10));
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public LocalDate getBestBeforeDate() {
		return bestBeforeDate;
	}
	
	public String toString() {
		return "["+this.label+"="+this.price+" -> before "+this.bestBeforeDate.toString()+"]";
	}
	
	public boolean isBestBefore(LocalDate date) {
		if(this.bestBeforeDate.isBefore(date)) return true;
		return false;
	}
	
	
}
