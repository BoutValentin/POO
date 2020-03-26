package tp08;
import java.util.*;
public class PupilItColumn implements Iterator<Pupil> {
	private Pupil[][] pupils;
	private int i;
	private int j;
	public PupilItColumn(Pupil[][] pu) {
		this.pupils = pu;
		this.i = 0;
		this.j = 0;
	}
	private void findNextElement() {
		if(this.i<this.pupils.length-1) {
			this.i++;
		}else {
			this.j++;
			this.i=0;
		}
	}
	public boolean hasNext() {
		return (this.i<this.pupils.length && this.j<this.pupils[this.i].length);
	}
	
	public Pupil next() {
		Pupil p = this.pupils[this.i][this.j];
		this.findNextElement();
		return p;
	}
}
