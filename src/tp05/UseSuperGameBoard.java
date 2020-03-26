package tp05;

public class UseSuperGameBoard {

	public static void main(String[] args) {
		Case[] all = Case.values();
		String[] files = new String[all.length];
		for(int i =0 ; i<all.length; i++) {
			files[i]= all[i].toString();
		}
		SuperGameBoard sgb = new SuperGameBoard(files, 10);
		sgb.fillingCase(Case.valueOf("GRASS"), 1, 1, sgb.getGame());
		sgb.display();
	}
}
