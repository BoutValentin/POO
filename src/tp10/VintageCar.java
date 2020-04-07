package tp10;

import java.time.LocalDate;

public class VintageCar extends Car{
	private double dropTPS;
	
	public VintageCar(String b, LocalDate l, double d, LocalDate l2, double d2, int i) {
		super(b,l,d,l2,d2,i);
		this.dropTPS = 0.0;
	}
	public VintageCar(String b, LocalDate l, double d, int i) {
		this(b,l,d,LocalDate.now(),d,i);
	}
	public double computeDropRate() {
		int m1 = super.getOnRoad().getYear()*12+super.getOnRoad().getMonthValue();
		int m2 = super.getOnSale().getYear()*12+super.getOnSale().getMonthValue();
		int diffMonth = m2-m1+1;
		System.out.println(diffMonth);
		System.out.println(super.getMileage()/1000);
		System.out.println(diffMonth*this.dropTPS+(super.getMileage()/1000)*super.getDropKm());
		return diffMonth*this.dropTPS+(super.getMileage()/1000)*super.getDropKm();
	}
	
}
