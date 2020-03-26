package tp02;

public class DicePlayer {
	String name;
	int totalValue;
	int nbDiceRolls;
	
	DicePlayer(String name){
		this.name = name;
	}
	
	public void play(Dice de) {
		this.totalValue += de.value ;
		this.nbDiceRolls += 1;
	}
	public String toString() {
		return this.name + ":" + this.totalValue + " points en " + this.nbDiceRolls + " coups.";
	}
}
