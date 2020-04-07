package tp10;

import java.util.Iterator;
import java.util.List;

public class PoultryItWeight implements Iterator<Poultry>{
	private Poultry[] po ;
	private int lastSize;
	private int idx;
	
	public PoultryItWeight(Poultry[] p, int i) {
		this.po=p.clone();
		this.lastSize=i;
		this.idx=-1;
		this.findNextElements();
	}
	private void findNextElements() {
		this.idx++;
		while(this.idx<this.lastSize&&this.po[this.idx].getWeight()<this.po[this.idx].slaughterThreshold)this.idx++;
	}
	public boolean hasNext() {
		return this.idx<this.lastSize;
	}
	public Poultry next() {
		Poultry a = this.po[this.idx];
		this.findNextElements();
		return a;
	}
	
}
