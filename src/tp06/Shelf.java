package tp06;

import java.util.ArrayList;

public class Shelf {
	private boolean refrigerated ;
	private int capacityMax;
	private ArrayList<IProduct> shelves;
	
	public Shelf(boolean refri, int cap) {
		this.refrigerated = refri;
		this.capacityMax = cap;
		this.shelves= new ArrayList<IProduct>();
	}
	public boolean isFull() {
		if(this.capacityMax==this.shelves.size())  return true ; 
		return false;
	}
	public boolean isEmpty() {
		if(this.shelves.size()==0) return true;
		return false;
	}
	public boolean isRefrigerated() {
		return this.refrigerated;
	}
	
	public String toString() {
		return "["+this.refrigerated+" : " + this.capacityMax + " -> " +this.shelves.toString()+"]";
	}
	
	public boolean add(IProduct p) {
		if(this.isFull() || (p instanceof Supplies && ! this.refrigerated ))return false;
		this.shelves.add(p);
		return true;
	}
}
