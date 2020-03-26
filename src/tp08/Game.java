package tp08;
import java.util.*;

import util.Keyboard;
public class Game {
	private List<Square> gameBoard;
	private ListIterator<Square> player;
	public Game(List<Square> l) {
		this.gameBoard = l;
		this.player = this.gameBoard.listIterator();
	}
	public String displayBoard() {
		String res = "";
		Iterator<Square> it = this.gameBoard.listIterator();
		while(it.hasNext()) {
			res += it.next().displaySquare();
		}
		return res;
	}
	public boolean forward(int nbTimes) {
		if(nbTimes<=0 || ! this.player.hasNext()) {
			return false;
		}
		Square s = this.player.next();
		this.forward(nbTimes-1);
		return true;
	}
	public boolean backward(int nbTimes) {
		if(nbTimes<=0 || ! this.player.hasPrevious()) {
			return false;
		}
		Square s = this.player.previous();
		this.backward(nbTimes-1);
		return true;
	}
	public void run() {
		while(this.player.hasNext()) {
			Square s = this.gameBoard.get(this.player.nextIndex());
			System.out.println(s.displaySquare());
			System.out.println(s.toString());
			String response = Keyboard.readString("Ta reponse");
			if(s.testAnswer(response)) {
				System.out.println("BRAVO");
				System.out.println(s.getBonus());
				this.forward(s.getBonus());
			}else {
				System.out.println("NUL");
				this.backward(s.getPenalty());
			}
		}
	}
}
