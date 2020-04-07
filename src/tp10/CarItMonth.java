package tp10;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class CarItMonth implements Iterator<Car> {
	private List<Car> autos;
	private int idx;
	
	public CarItMonth(List<Car> c) {
		this.autos = c;
		this.idx=-1;
		this.findNextElements();
	}
	private void findNextElements() {
		this.idx++;
		while(idx<this.autos.size()&& this.autos.get(idx).getOnSale().isAfter(LocalDate.now().minusMonths(6))) this.idx++;
	}
	
	public boolean hasNext() {
		return this.idx<this.autos.size();
	}
	public Car next() {
		Car c = this.autos.get(this.idx);
		this.findNextElements();
		return c;
	}

}
