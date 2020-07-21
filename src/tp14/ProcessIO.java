package tp14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessIO extends ProcessH{
	String message;
	int numberExecution;
	public ProcessIO(Priority p, int e, int numberOfExecution) {
		super(p,e);
		this.numberExecution = numberOfExecution;
	}
	public void setNumberExecute(int e) {
		this.numberExecution = e;
	}
	public void execute() {
		boolean secur = true;
		if(this.numberExecution==0) {
			while(secur) {
				secur=false;
				try {
					
					this.readingMethod();
				}catch (IOException e) {
					secur=true;
					System.out.println("An error of input occur, please retry");
				}
			}
			
			this.numberExecution++;
		}else if(this.numberExecution==1) {
			System.out.println(this.message);
		}
	}
	private void readingMethod() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.message=br.readLine();
		br.close();
	}
	public boolean isOver() {
		return this.numberExecution==this.execution ;
	}
}
