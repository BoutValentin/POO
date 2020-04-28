package tp11;

public class IsCheaperThan implements Criterion {
	private double threshold;
	
	public IsCheaperThan(double d) {
		this.threshold =d;
	}
	@Override
	public boolean isFulfilled(Vehicule v) {
		return v.getDailyRent()<this.threshold;
	}
	public boolean strictMerging(Criterion c) {
		if(getClass() != c.getClass()) return false;
		IsCheaperThan c2 = (IsCheaperThan) c;
		if(c2.threshold<this.threshold) {
			this.threshold=c2.threshold;
		}
		return true;
	}

	public boolean flexibleMerging(Criterion c) {
		if(getClass() != c.getClass()) return false;
		IsCheaperThan c2 = (IsCheaperThan) c;
		if(c2.threshold>this.threshold) {
			this.threshold = c2.threshold;
		}
		return true;
	}

}
