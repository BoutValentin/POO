package tp07;

import java.util.*;
import java.util.HashSet;

public class BreedingGround {
	private HashSet<Participant> applicants = new HashSet<Participant>() ;
	
	public HashSet<Participant> getApplicants(){
		return this.applicants;
	}
	
	public boolean registration(Participant p) {
		return this.applicants.add(p);
	}
	
	public List<Participant> loners(){
		List<Participant> l = new ArrayList<Participant>();
		Iterator<Participant> itera = this.applicants.iterator();
		while( itera.hasNext()) {
			if(itera.next().getPartner()==null) l.add(itera.next());		
		}
		return l;
	}
	
	public void lonersCleansing() {
		List<Participant> l = this.loners();
		for(Participant p : l) {
			this.applicants.remove(p);
		}
	}
	public void forcedMatching() {
		List<Participant> l = this.loners();
		Random rnd = new Random();
		int max = (l.size()%2==1) ? 1 : 0;
		
			while(l.size()>max) {
				Participant p;
				Participant p2;
				do {
				 p = l.get(rnd.nextInt(l.size()));
				 p2 = l.get(rnd.nextInt(l.size()));
				}while(p==p2);
				p.match(p2);
				l.remove(p);
				l.remove(p2);
			}
	}
	public List<Participant> cheaters(BreedingGround another){
		List<Participant> l = new ArrayList<Participant>();
		for(Participant p : another.applicants) {
			if(this.applicants.contains(p)) l.add(p);
		}
		return l;
	}
	
	public void isolateCheaters(Participant cheater) {
		cheater.breakOff();
	}
	public void cheatersCleansing(BreedingGround another) {
		List<Participant> c = this.cheaters(another);
		for(Participant cr : c) {
			this.isolateCheaters(cr);
			this.applicants.remove(cr);
			another.applicants.remove(cr);
		}
	}
	public boolean possibleMerging(BreedingGround another) {
		List<Participant> c = this.cheaters(another); 
		return c.isEmpty();
	}
	public void fusion(BreedingGround another) {
		
			for(Participant p : another.applicants) {
				this.applicants.add(p);
			}
		
	}
	public void securedMerging(BreedingGround another) {
		if(! this.possibleMerging(another)) this.cheatersCleansing(another);
		this.fusion(another);
	}
	
}
