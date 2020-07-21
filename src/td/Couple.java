package td;

public class Couple<T, S> {
	private T firstElements;
	private S secondElements;
	
	public Couple(T ele, S el){
		this.firstElements=ele;
		this.secondElements=el;
	}
	public T getPremier() {
		return this.firstElements;
	}
	public S getSecond() {
		return this.secondElements;
	}
	public void setPremier(T pre) {
		this.firstElements=pre;
	}
	public void setSecond(S sec) {
		this.secondElements=sec;
	}
	public String toString() {
		return ""+this.firstElements.toString()+this.secondElements.toString();
	}
	public boolean sameAs(Couple<T, S> other) {
		if(this.getPremier().equals(other.getPremier()) && this.getSecond().equals(other.getSecond()))return true;
		return false;
	}
	public static<T,S> boolean sameCouples(Couple<T,S> other1, Couple<T,S> other2) {
		return other1.sameAs(other2);
	}
	
	public static void main(String[] args) {
		Couple<String, Integer> c1 = new Couple<String, Integer>("String1", 1);
		Couple<String, Integer> c2 = new Couple<String, Integer>("String2", 2);
		Couple<String, Integer> c3 = new Couple<String, Integer>("String1", 1);
		
		if(c1.sameAs(c3))System.out.println("oui");
		if(Couple.sameCouples(c1, c3)) System.out.println("re oui");
		if(!c1.sameAs(c2))System.out.println("oui");
		if(!Couple.sameCouples(c1, c2)) System.out.println("re oui");
		
		
	}
}
