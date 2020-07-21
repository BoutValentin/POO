package tp14;

import java.util.LinkedList;
import java.util.List;

public class SchedulingQueue implements Scheduler{
	List<Priority> theQueue ;
	
	public SchedulingQueue() {
		this.theQueue= new LinkedList<>();
	}
	public String toString() {
		return this.theQueue.toString();
	}
	public void addElement(Priority p) {
		this.theQueue.add(p);
	}
	public Priority hightestPriority() {
		if(theQueue.isEmpty()) return null;
		return theQueue.remove(0);
	}
	public boolean isEmpty() {
		return theQueue.isEmpty();
	}
}

