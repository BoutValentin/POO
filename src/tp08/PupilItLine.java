package tp08;
import java.util.*;
public class PupilItLine implements Iterator<Pupil>{
	private Pupil[][] pupil;
	private int i;
	private int j;
	public PupilItLine(Pupil[][] pu) {
		this.pupil = pu;
		this.i = 0;
		this.j = 0;
	}
	private void finNextElement() {
		if(this.j<this.pupil.length) {
			this.j++;
		}else {
			this.j=0;
			this.i++;
		}
	}
	public boolean hasNext() {
		return (this.i<this.pupil.length && this.pupil[this.i].length>this.j);
	}
	public Pupil next() {
		Pupil p = this.pupil[this.i][this.j];
		this.finNextElement();
		return p;
	}
}
