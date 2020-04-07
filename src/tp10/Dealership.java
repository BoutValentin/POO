package tp10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
	private List<Car> autos ;
	
	public Dealership() {
		this.autos = new ArrayList<Car>();
	}
	public void addCar(Car v) {
		this.autos.add(v);
	}
	
	public Car createCar(String brand, LocalDate onRoad, double pPrice, LocalDate onSale, double sPrice, int km) {
		if(onRoad.isBefore(LocalDate.now().minusYears(40))) {
			return new VintageCar(brand, onRoad, pPrice, onSale,sPrice,km );
		}
		return new Car(brand, onRoad, pPrice, onSale,sPrice,km );
	}
	
	public Car createCar(String brand, LocalDate onRoad, double pPrice, int km) {
		return this.createCar(brand, onRoad, pPrice,LocalDate.now(),pPrice, km);
	}
}
