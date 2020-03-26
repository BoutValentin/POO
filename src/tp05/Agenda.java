package tp05;

import java.util.ArrayList;

public class Agenda {

	ArrayList<Event> array ;
	
	public Agenda() {
		this.array = new ArrayList<Event>();
	}
	
	public String toString() {
		String tes = null;
		for(int i = 0; i<this.array.size(); i++) {
			tes += this.array.get(i).toString();
		}
		return tes;
	}
	
	public boolean conflicting(Event evt) {
		for(Event e : this.array) {
			if(e.overlap(evt)) {
				return false;
			}
		}
		return true;
	}
	
	public void addEvent(Event evt, int i) {
		
		if(i==-1) {
			this.array.add(evt);
		}
		
		this.array.add(i, evt);
	}
	
	public void addEvent(Event evt) {
		this.addEvent(evt, -1);
	}
	
	public void removeEvent(Event evt) {
		int index = 0;
		for(Event e : this.array) {
			index++;
			if(e.equals(evt)) {
				
				break;
			}
		}
		this.removeEvent(index);
	}
	
	public void removeEvent(int idx) {
		this.array.remove(idx);
	}
	
	public void removeEvent(String label) {
		int index = 0;
		for(Event e : this.array) {
			index++;
			if(e.getLabel().equals(label)) {
				break;
			}
		}
		this.removeEvent(index);	
	}
	
	public void removeOverlapping(Event e ) {
		for(Event z : this.array) {
			if(z.overlap(e)) {
				this.removeEvent(e);
			}
		}
	}
	
	public void removeBetween(Event evt1, Event evt2) {
		for(Event e : this.array) {
			if(e.getStart().isAfter(evt1.getStart()) && e.getEnd().isBefore(evt2.getEnd())) {
				this.removeEvent(e);
			}else if(e.getStart().isEqual(evt1.getStart()) && e.getEnd().isBefore(evt2.getEnd())) {
				this.removeEvent(e);
			}else if(e.getStart().isEqual(evt1.getStart()) && e.getEnd().isEqual(evt2.getEnd())) {
				this.removeEvent(e);
			}else if(e.getStart().isAfter(evt1.getStart()) && e.getEnd().isEqual(evt2.getEnd())){
				this.removeEvent(e);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> yp = new ArrayList<Integer>();
		yp.add(10);
		yp.add(9);
		System.out.println(yp);
		yp.add(1,8);
		System.out.println(yp);
	}
	
}
