package tp05;

import java.util.Random;

import util.GameBoard;

public class UseGameBoard {
	
	public static void randomInitialization(GameBoard p, int nb) {
		Random rnd = new Random();
		for(int i = 0 ; i<nb ; i++) {
				int[][] l = p.getGame();
				l[(int)rnd.nextInt(p.getNbLines())][(int)rnd.nextInt(p.getNbColumns())] = (int) rnd.nextInt(4) ;
		}
	}
	
	public static void main(String[] args) {
		String[] images = new String[] {"res/sea.png", "res/grass.png", "res/dirt.png"};
		int mySize = 10;
		GameBoard p = new GameBoard(images, mySize);
		int[][] tmp = p.getGame();
		tmp[1][1] = 2;
		checkerBoardInitialisation(p);
		
		p.display();
	}
	
	public static void checkerBoardInitialisation(GameBoard p) {
		int[][] tmp = p.getGame();
		for(int i = 0; i < p.getNbLines(); i++) {
			for(int j = 0; j<p.getNbColumns(); j++) {
				if(i%2==0 && j%2==0)tmp[i][j]= 1;
				else if(i%2==1 && j%2==1)tmp[i][j] =1;
			}
		}
		
	}
	
	
}
