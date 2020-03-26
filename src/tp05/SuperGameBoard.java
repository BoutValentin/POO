package tp05;

import util.GameBoard;

public class SuperGameBoard {
	
	private GameBoard gb ;
	
	public void display() {
		gb.display();
	}

	public int[][] getGame() {
		return gb.getGame();
	}

	public int getNbColumns() {
		return gb.getNbColumns();
	}

	public int getNbLines() {
		return gb.getNbLines();
	}

	public void setGame(int[][] arg0) {
		gb.setGame(arg0);
	}

	public GameBoard getGb() {
		return gb;
	}

	public void setGb(GameBoard gb) {
		this.gb = gb;
	}
	
	public SuperGameBoard(String[] paths, int size) {
		this.gb = new GameBoard(paths, size);
	}
	
	public void fillingCase(Case type, int i, int j, int[][] game) {
		game[i][j] = type.ordinal()+1;
//		this.gb.setGame(game);
	}
	
	public void fillingDirt() {
		
	}
}
