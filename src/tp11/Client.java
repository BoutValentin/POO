package tp11;

import java.util.ArrayList;
import java.util.List;

public abstract class Client {
	private String name;
	List<Criterion> list;
	
	public Client(String n) {
		this.name =n;
		this.list = new ArrayList<Criterion>();
	}
	
	public boolean oneMore(Criterion c) {
		if(this.list.contains(c)) return false;
		this.list.add(c);
		return true;
	}
	public boolean manyMore(List<Criterion> requirements) {
		for(Criterion c : requirements) {
			boolean feedback = oneMore(c);
			if(!feedback) return false;
		}
		return true;
	}
	public abstract boolean valid(Vehicule v);
	public abstract boolean merging(Criterion c, Criterion c2) ;
	
	public boolean oneMoreMerging(Criterion c) {
		for(Criterion c2 : list) {
			if(c2.getClass()==c.getClass()) {
				if(!this.merging(c2, c))return false;
				return true;
			}
		}
		this.list.add(c);
		return true;
	}
	
	
	public boolean manyMoreMerging(List<Criterion> requirements) {
		for(Criterion c2: requirements) {
			if(!this.oneMoreMerging(c2)) return false;
		}
		return true;
		
	}
}
