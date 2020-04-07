package tp10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BreadingFarm {
	private Poultry[] beads ;
	private int maxSize;
	private int lastElements;
	public BreadingFarm(Poultry[] b) {
		this.beads = b;
		this.maxSize= b.length;
		this.lastElements = b.length-1;
	}
	public BreadingFarm(int maxSize) {
		this.beads = new Poultry[maxSize];
		this.maxSize = maxSize;
		this.lastElements=0;
	}
	public BreadingFarm() {
		this.maxSize = 200;
		this.beads = new Poultry[this.maxSize];
		this.lastElements=0;
	}
	public void add(Poultry beast) {
		if(this.lastElements!=this.beads.length-1) {
			
			this.beads[this.lastElements++]=beast;
		}
	}
	public String toString() {
		String res="";
		for(int i =0; i<this.lastElements; i++) {
			res+=this.beads[i].toString()+"\n";
		}
		return res;
	}
	public Poultry search(int identity) {
		for(int i=0; i<this.lastElements; i++) {
			if(this.beads[i].getIdentity()==identity) {
				return this.beads[i];
			}
		}
		return null;
	}
	public void updateWeight(int identity, double weight) {
		Poultry po = this.search(identity);
		if(po!=null) {
			po.setWeight(weight);
		}
	}
	public double potentialProfit() {
		double price = 0.0;
		Iterator<Poultry> it = new PoultryItWeight(this.beads, this.lastElements);
		while(it.hasNext()) {
			Poultry a = it.next();

			price+=a.getWeight()*a.getPriceKg();
		}
		return price;
	}
	private int getPosition(int identity) {
		for(int i=0; i<this.lastElements; i++) {
			if(this.beads[i].getIdentity()==identity) {
				return i;
			}
		}
		return -1;
	}
	private void removePoultry(int identity) {
		int pos = this.getPosition(identity);
		for(int i = pos; i<this.lastElements; i++) {
			if(i+1!=this.beads.length) {
			this.beads[i]=this.beads[i+1];
			}else {
				this.beads[i]=null;
			}
		}
		this.lastElements--;
	}
	public List<Poultry> slaughtering(){
		List<Poultry> l = new ArrayList<Poultry>();
		Iterator<Poultry> it = new PoultryItWeight(this.beads, this.lastElements);
		while(it.hasNext()) {
			Poultry a = it.next();
			l.add(a);
			this.removePoultry(a.getIdentity());
		}
		return l;
		
	}
	
}
