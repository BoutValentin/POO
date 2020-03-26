package tp08;

public class ValidQuestion implements IQuestion {
	private final static String LABEL = "QUESTION ALWAYS COORECT ! LUCKY !";
	public ValidQuestion() {
	
	}
	public String toString() {
		return ValidQuestion.LABEL;
	}
	public boolean testAnswer(String s) {
		/*return s.equals(LABEL);*/
		return true;
	}
}
