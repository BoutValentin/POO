package tp14;

public abstract class ProcessH implements Priority , Process{
	private Priority p;
	int execution;
	public ProcessH(Priority p2, int e) {
		this.p=p2;
		this.execution=e;
	}
	public ProcessH(Priority p2) {
		this.p=p2;
		this.execution = 1;
	}
	public int getPriority() {
		return this.p.getPriority();
	}
	public void setPriotiry(Priority p) {
		this.p=p;
	}
	public int getNumberExecution() {
		return this.execution;
	}
	public void setExecution(int e) {
		this.execution=e;
	}
	
	public abstract void execute();
	public abstract boolean isOver();
}
