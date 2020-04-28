package tp11;

public interface Criterion {
	public boolean isFulfilled(Vehicule v);
	public boolean strictMerging(Criterion c);
	public boolean flexibleMerging(Criterion c);
}
