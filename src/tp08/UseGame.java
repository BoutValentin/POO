package tp08;
import java.util.*;
public class UseGame {
	private static Random rnd = new Random();
	public static void main(String[] args) {
		UseGame.alwaysCorrect();
	}
	
	public static void alwaysCorrect() {
		List<Square> list = new ArrayList<Square>();
		for(int i = 0 ; i< 5; i++) {
			int malus = (i > 2) ? 2 : i+1;
			list.add(new Square(new ValidQuestion(), rnd.nextInt(3)+1, rnd.nextInt(malus)));
		}
		System.out.println(list);
		Game g = new Game(list);
		System.out.println(g.displayBoard());
		g.run();
		System.out.println("Bravo, partie finie");
		
	}
	public static void onlyFree() {
		List<Square> list = new ArrayList<Square>();
		for(int i = 0 ; i< 5; i++) {
			int malus = (i > 2) ? 2 : i+1;
			list.add(new Square(new FreeQuestion("Question"+i, "reponse"+i), rnd.nextInt(3)+1, rnd.nextInt(malus)));
		}
		System.out.println(list);
		Game g = new Game(list);
		System.out.println(g.displayBoard());
		g.run();
		System.out.println("Bravo, partie finie");
	}
	public static void onlyMCQ() {
		List<Square> list = new ArrayList<Square>();
		for(int i = 0 ; i< 5; i++) {
			int malus = (i > 2) ? 2 : i+1;
			List<String> l = new ArrayList<String>();
			for(int j =0; j<4; j++) {
				l.add(j+"Reponse");
			}
			
			list.add(new Square(new MCQuestion("Question"+i, i%4, l), rnd.nextInt(3)+1, rnd.nextInt(malus)));
		}
		System.out.println(list);
		Game g = new Game(list);
		System.out.println(g.displayBoard());
		g.run();
		System.out.println("Bravo, partie finie");
	}
	public static void finaleGame() {
		List<Square> list = new ArrayList<Square>();
		int cptGood=0, cptBad=0, cptFree=0, cptMcq=0;
		for(int i = 0 ; i<20; i++) {
			int r = rnd.nextInt(5);
			switch (r) {
			case 0:
				if(cptGood<6) {
				list.add(new Square(new ValidQuestion(), rnd.nextInt(3)+1, rnd.nextInt(3)+1));
				cptGood++;
				}else {
					i--;
				}
				break;
			case 1:
				if(cptBad<4) {
					list.add(new Square(new InvalidQuestion(), rnd.nextInt(3)+1, rnd.nextInt(3)+1));
					cptBad++;
				}else {
					i--;
				}
				break;
			case 2:
				if(cptFree<6) {
					
					list.add(new Square(new FreeQuestion("Question"+cptFree, "reponse"+cptFree), rnd.nextInt(2)+1, rnd.nextInt(2)+1));
					cptFree++;
				}else {
					i--;
				}
				break;
			case 3:
				if(cptMcq<4) {
					List<String> l = new ArrayList<String>();
					for(int j =0; j<4; j++) {
						l.add(j+"Reponse");
					}
					
					list.add(new Square(new MCQuestion("Question"+cptMcq, cptMcq%4, l), rnd.nextInt(2)+1, rnd.nextInt(2)+1));
					cptMcq++;
				}else {
					i--;
				}
				break;
			}
		}
		System.out.println(list);
		Game g = new Game(list);
		System.out.println(g.displayBoard());
		g.run();
		System.out.println("Bravo, partie finie");
	}
}
