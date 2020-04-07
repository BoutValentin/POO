package tp10;

import java.time.LocalDate;

public class Car {
	private double dropTPS;
	private double dropKm;
	private String brand;
	private LocalDate onRoad;
	private double purchasePrice;
	private LocalDate onSale;
	private double salePrice;
	private int mileage;
	
	public Car(String brand, LocalDate onRoad, double pPrice, LocalDate onSale, double sPrice, int km) {
		this.dropKm = 0.002;
		this.dropTPS = 0.001;
		this.brand = brand;
		this.onRoad = onRoad;
		this.purchasePrice = pPrice;
		this.onSale = onSale;
		this.salePrice = sPrice;
		this.mileage = km;
	}
	public Car(String brand, LocalDate onRoad, double pPrice, int km) {
		this(brand, onRoad, pPrice, LocalDate.now(), pPrice, km);
	}
	public double getDropKm() {
		return this.dropKm;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public LocalDate getOnRoad() {
		return onRoad;
	}
	public void setOnRoad(LocalDate onRoad) {
		this.onRoad = onRoad;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public LocalDate getOnSale() {
		return onSale;
	}
	public void setOnSale(LocalDate onSale) {
		this.onSale = onSale;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	private void setSalePrice(double salePrice) {
		if(salePrice >=0) { 
			this.salePrice = salePrice ;
		}else { this.salePrice=0;}
	}
	
	public double computeDropRate() {
		int m1 = this.onRoad.getYear()*12+this.onRoad.getMonthValue();
		int m2 = this.onSale.getYear()*12+this.onSale.getMonthValue();
		int diffMonth = m2-m1+1;
		System.out.println(diffMonth);
		System.out.println(diffMonth*this.dropTPS+(this.mileage/1000)*this.dropKm);
		return diffMonth*this.dropTPS+(this.mileage/1000)*this.dropKm;
	}
	public void priceEstimation() {
		double rate = this.computeDropRate();
		this.setSalePrice(this.purchasePrice-rate*this.purchasePrice);
	}
	public double getSalePrice() {
		return this.purchasePrice-this.purchasePrice*this.computeDropRate();
	}
	public String toString() {
		return "["+this.brand+","+this.onSale.getYear()+","+this.mileage+"km"+this.getSalePrice()+"euros]";
	}
	
	
}
