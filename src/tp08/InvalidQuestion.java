package tp08;

public class InvalidQuestion implements IQuestion {
	private final static String LABEL = "Question always invalid ! Looser";
	
	public InvalidQuestion() {
		
	}
	public boolean testAnswer(String s) {
		return false;
	}
	public String toString() {
		return InvalidQuestion.LABEL;
	}

}
