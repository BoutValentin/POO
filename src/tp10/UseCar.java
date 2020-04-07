package tp10;

import java.time.LocalDate;

public class UseCar {
	
	public static void main(String[] args) {
		Car car = new Car("toyota", LocalDate.of(2015, 03, 03), 15000.0, 6000);
		VintageCar car2 = new VintageCar("toyota", LocalDate.of(2015, 03, 03), 15000.0, 6000);
		System.out.println(car.toString());
		System.out.println(car2.toString());
	}
}
