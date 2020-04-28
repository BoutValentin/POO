package tp11;

import java.time.LocalDate;

public abstract class Employee {
	private String name;
	private LocalDate hiringDate;
	
	public Employee(String s, LocalDate d) {
		this.name = s;
		this.hiringDate = d;
	}
	public String getName() {
		return this.name;
	}
	
	public abstract String getTitle();
	
	public String toString() {
		return this.getName()+this.getTitle();
	}
	public abstract double getWages();
	public LocalDate getHiring() {
		return this.hiringDate;
	}
	public abstract boolean objectiveFulfilled();
}
