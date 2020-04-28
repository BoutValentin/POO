package tp11;

public class CanBeHitched implements Criterion {
	private boolean hitchPossible ;
	public CanBeHitched(boolean b) {
		this.hitchPossible =b;
	}
	@Override
	public boolean isFulfilled(Vehicule v) {
		return v.hitchPossible()==this.hitchPossible;
	}
	public boolean strictMerging(Criterion c) {
		if(getClass() != c.getClass()) return false;
		CanBeHitched c2 = (CanBeHitched) c;
		if(c2.hitchPossible && this.hitchPossible) {
			this.hitchPossible=true;
			return true;
		}else {
			this.hitchPossible=false;
		}
		return true;
	}
	public boolean flexibleMerging(Criterion c) {
		if(getClass() != c.getClass()) return false;
		CanBeHitched c2 = (CanBeHitched) c;
		if(c2.hitchPossible || this.hitchPossible) {
			this.hitchPossible=true;
			
		}else {
			this.hitchPossible=false;
		}
		
		return true;
	}

}
