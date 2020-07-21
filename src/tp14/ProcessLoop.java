package tp14;

public class ProcessLoop extends ProcessH{
	String message;
	int numberExecution;
	public ProcessLoop(Priority p, int e, String message,int numberOfExecution) {
		super(p,e);
		this.message=message;
		this.numberExecution = 0;
	}
	public void setNumberExecute(int e) {
		this.numberExecution = e;
	}
	public void execute() {
			System.out.println(this.message);
			this.numberExecution++;
	}
	public  boolean isOver() {
		return this.numberExecution==this.execution ;
	}
}
