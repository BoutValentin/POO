package tp01;

public class EssaiHallOfFame {
	public static void main(String[] args) {
		HallOfFame hall = new HallOfFame() ;
		hall.enregistrer(20, "Alice");
		hall.enregistrer(20, "Bruno");
		hall.enregistrer(20, "Chloé");
		hall.enregistrer(20, "Denis");
		hall.affichage();
	}
}

