package tp14;


public class ProcessDisplay extends ProcessH {
	String message;
	int numberExecution;
	
	public ProcessDisplay(Priority p, int e, String message, int e2 ) {
		super(p,e);
		this.message=message;
		this.numberExecution = e2;
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
