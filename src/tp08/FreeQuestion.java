package tp08;

public class FreeQuestion implements IQuestion {
	private String label;
	private String correctAnswer;
	
	public FreeQuestion(String l, String s) {
		this.label = l;
		this.correctAnswer = s;
	}
	@Override
	public boolean testAnswer(String s) {
		return this.correctAnswer.equalsIgnoreCase(s);
	}
	@Override
	public String toString() {
		return this.label;
	}

}
