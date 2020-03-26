package tp08;
import java.util.*;
public class PupilItColumnFatter implements Iterator<Pupil> {
	private Pupil[][] pupils;
	private Pupil fatter;
	private int i;
	private int j;
	public PupilItColumnFatter(Pupil[][] pu, Pupil p) {
		this.pupils = pu;
		this.fatter = p;
		this.i = -1;
		this.j = 0;
		this.findNextElement();
	}
	private void findNextElement() {
		if(this.i<this.pupils.length-1) {
			
			this.i++;
		}else {
			this.j++;
			this.i=0;
		}
		
		while((this.i<this.pupils.length && this.j<this.pupils[this.i].length) &&this.pupils[this.i][this.j].getWeight()<this.fatter.getWeight()  ) {
		if(this.i<this.pupils.length-1) {
			this.i++;
		}else {
			this.j++;
			this.i=0;		
		}
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
