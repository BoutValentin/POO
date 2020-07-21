package tp14;

public class Task implements Priority{
	private int priority;
	private String label;
	
	public Task(int pr, String l) {
		this.priority=pr;
		this.label=l;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	public String toString() {
		return "Task: "+this.priority+"priority level, "+this.label+" label";
	}
}
