package tp02;

public class TwoDicePlayerGame {
	DicePlayer player1;
	DicePlayer player2;
	
	TwoDicePlayerGame(DicePlayer player1, DicePlayer player2){
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void winner() {
		if(this.player1.nbDiceRolls == this.player2.nbDiceRolls) {
			if(this.player1.totalValue > this.player2.totalValue) {
				System.out.println("winner "+ this.player1.name);
			}else {
				System.out.println("Pas de gagnant, egalité");
			}
		}else if(this.player1.nbDiceRolls < this.player2.nbDiceRolls){
			System.out.println("Winner: " + this.player1.name);
		}else {
			System.out.println("Winner: " + this.player2.name);
		}
	}
	
	public static void main(String[] args) {
		TwoDicePlayerGame jouer = new TwoDicePlayerGame((new DicePlayer("Andre")), (new DicePlayer("Philou")));
		while(jouer.player1.totalValue < 20) {
			Dice de = new Dice(6);
			jouer.player1.play(de);
			System.out.println(jouer.player1);
		}
		while(jouer.player2.totalValue < 20) {
			Dice de = new Dice(6);
			jouer.player2.play(de);
			System.out.println(jouer.player2);
		}
		jouer.winner();
		
	}
}
