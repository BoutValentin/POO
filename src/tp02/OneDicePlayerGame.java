package tp02;

public class OneDicePlayerGame {
	public static void main(String[] args) {
		DicePlayer player1 = new DicePlayer("Andrée");
		
		
		while(player1.totalValue < 20) {
			Dice de = new Dice(6);
			player1.play(de);
			System.out.println(player1);
		}
	}
}
