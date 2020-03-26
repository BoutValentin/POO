package tp08;

public class Square implements IQuestion{
	private static int idx = 0;
	private int id;
	private int bonus;
	private int penalty;
	private IQuestion question;
	
	public Square(IQuestion q, int bon, int mal) {
		Square.idx = Square.idx+1;
		this.id = Square.idx;
		if(bon>0){
			this.bonus = bon;
					}else { this.bonus=1;}
		if(mal>0) {this.penalty = mal  ;}else { this.penalty=0;}
		this.question = q;
	}
	public int getId() {
		return this.id;
	}
	public int getBonus(){return this.bonus;}
	public int getPenalty() {return this.penalty;}
	public boolean testAnswer(String s) {
		return this.question.testAnswer(s);
	}
	public String toString() {
		return this.question.toString();
	}
	public String displaySquare() {
		return "["+this.getId()+"]";
	}
	
}
