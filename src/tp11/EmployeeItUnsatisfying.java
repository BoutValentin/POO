package tp11;

import java.util.Iterator;
import java.util.List;

public class EmployeeItUnsatisfying implements Iterator<Employee> {
	
	private List<Employee> list;
	private int idx;
	
	public EmployeeItUnsatisfying(List<Employee> l) {
		this.list = l ;
		this.idx=-1;
		this.findNextElements();
	}
	private void findNextElements() {
		this.idx++;
		while(this.list.get(idx).objectiveFulfilled()) this.idx++;
	}
	public boolean hasNext() {
		return this.idx<this.list.size();
	}
	public Employee next() {
		Employee e = this.list.get(this.idx);
		this.findNextElements();
		return e;
	}
}
