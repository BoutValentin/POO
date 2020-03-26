package tp08;
import java.util.*;
public class UseClassRoom {
	
	public static void main(String[] args) {
		column_iteration();
		bigger_iteration();
	}
	public static void column_iteration() {
		Pupil[][] pu = new Pupil[][] {{new Pupil("Alice", 50, 160), new Pupil("Bruno", 80, 120), new Pupil("Clément", 70, 180)},{new Pupil("Dorothée", 75, 185), new Pupil("Ernest",65, 155), new Pupil("Firmin", 60, 130)}};
		Classroom clas = new Classroom(pu);
		Iterator<Pupil> it = new PupilItColumn(clas.getPupil());
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	public static void line_iteration() {
		Pupil[][] pu = new Pupil[][] {{new Pupil("Alice", 50, 160), new Pupil("Bruno", 80, 120), new Pupil("Clément", 70, 180)},{new Pupil("Dorothée", 75, 185), new Pupil("Ernest",65, 155), new Pupil("Firmin", 60, 130)}};
		Classroom clas = new Classroom(pu);
		Iterator<Pupil> it = new PupilItLine(clas.getPupil());
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	public static void bigger_iteration() {
		Pupil[][] pu = new Pupil[][] {{new Pupil("Alice", 50, 160), new Pupil("Bruno", 80, 120), new Pupil("Clément", 70, 180)},{new Pupil("Dorothée", 75, 185), new Pupil("Ernest",65, 155), new Pupil("Firmin", 60, 130)}};
		Classroom clas = new Classroom(pu);
		Iterator<Pupil> it = new PupilItColumnFatter(clas.getPupil(), new Pupil("Ger", 60, 130));
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
