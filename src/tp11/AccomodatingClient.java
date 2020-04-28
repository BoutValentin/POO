package tp11;

public class AccomodatingClient extends Client{
	
	public AccomodatingClient(String s) {
		super(s);
	}
	
	public boolean valid(Vehicule v) {
		for(Criterion c : this.list) {
			if(c.isFulfilled(v)) return true;
		}
		return false;
	}
	
	public boolean merging(Criterion c, Criterion c2) {
		if(!c.flexibleMerging(c2)) return false;
		return true;
	}
}
