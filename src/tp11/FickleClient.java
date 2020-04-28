package tp11;

public class FickleClient extends Client{

	public FickleClient(String s) {
		super(s);
	}
	
	public boolean valid(Vehicule v) {
		for(Criterion c : this.list) {
			if(! c.isFulfilled(v)) return false;
		}
		return true;
	}
	
	public boolean merging(Criterion c, Criterion c2) {
		if(!c.strictMerging(c2)) return false;
		return true;
	}
}
