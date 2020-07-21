package tp14;

public interface Scheduler {
	
	public void addElement(Priority p);
	public Priority hightestPriority();
	public boolean isEmpty();
}
