package tp11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Company {
	private List<Employee> staff ;
	
	public Company() {
		this.staff = new ArrayList<Employee>();
	}
	public void addEmployee(Employee e) {
		this.staff.add(e);
	}
	public void suppEmployee(int i) {
		this.staff.remove(i);
	}
	public void suppEmployee(Employee e) {
		this.staff.remove(e);
	}
	public String toString() {
		return super.toString();
	}
	public void firing(int nb) {
		this.staff.sort(new EmployeeComparatorHiring());
		for(int i = 0; i<nb; i++) {
			this.suppEmployee(i);
		}
	}
	public void firing() {
		Iterator<Employee> it = new EmployeeItUnsatisfying(this.staff);
		while(it.hasNext()) {
			this.suppEmployee(it.next());
		}
	}
}
