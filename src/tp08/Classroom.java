package tp08;
import java.util.*;
public class Classroom {
	private final int NB_LINE;
	private final int NB_COLUMN;
	private Pupil[][] pupils;
	private static Random rnd = new Random();
	public Classroom(Pupil[][] pu) {
		this.NB_LINE = pu.length;
		this.NB_COLUMN = pu[0].length;
		this.pupils = pu;
	}
	public Classroom(int l, int c) {
		this.NB_LINE = l;
		this.NB_COLUMN = c;
		this.pupils = new Pupil[l][c];
		for(int i = 0 ; i<l ; i++) {
			for(int j = 0 ; j<c ; j++) {
				this.pupils[i][j] = new Pupil(""+i+j, rnd.nextInt(60), rnd.nextInt(180));
			}
		}
	}
	public Pupil[][] getPupil(){
		return this.pupils;
	}
}