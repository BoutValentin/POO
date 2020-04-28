package tp11;

public class IsFrom implements Criterion {
	private String theBrand ;
	
	public IsFrom(String s) {
		this.theBrand =s.toLowerCase();
	}
	@Override
	public boolean isFulfilled(Vehicule v) {
		// TODO Auto-generated method stub
		return this.theBrand.contains(v.getBRAND().toLowerCase());
	
	
	}
	public boolean strictMerging(Criterion c) {
		if(getClass()!=c.getClass()) return false;
		IsFrom c2 = (IsFrom) c;
		this.theBrand.concat(c2.theBrand);
		return true;
	}
	public boolean flexibleMerging(Criterion c) {
		return  strictMerging(c);
	}

}
