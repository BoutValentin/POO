package tp08;
import java.util.*;
public class MCQuestion implements IQuestion {
	private String label;
	private int correctAnswer;
	private List<String> possibleAnswer ;
	
	public MCQuestion(String l, int c, List<String> p) {
		this.label = l;
		this.correctAnswer = c;
		this.possibleAnswer = p;
	}
	@Override
	public boolean testAnswer(String s) {
		int chiffre = this.getNumber(s);
		return this.correctAnswer==chiffre;
	}
	private int getNumber(String s) {
		return this.possibleAnswer.indexOf(s);
	}
	public String toString() {
		String res = "";
		for(int i =0; i<4; i++) {
			res += "rep"+i+" :"+this.possibleAnswer.get(i)+"\n";
		}
		return this.label+"\n"+res;
	}

}
