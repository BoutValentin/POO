package tp11;

import java.util.Comparator;

public class EmployeeComparatorHiring implements Comparator<Employee> {
	
	public int compare(Employee e1, Employee e2) {
		return e1.getHiring().isBefore(e2.getHiring()) ? -1:1;
	}
}
