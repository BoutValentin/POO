package tp08;

public class Pupil {
	private String name;
	private int weight;
	private int height;
	Pupil(String n, int w, int h ){
		this.name = n;
		this.weight = w;
		this.height = h;
	}
	public String toString() {
		return "["+this.name+" w:"+this.weight+" h:"+this.height+"]";
	}
	public String getName() {return this.name;}
	public int getWeight() {return this.weight;}
	public int getHeight() {return this.height;}
	public boolean isFatter(Pupil o) {return this.weight<=o.getWeight();}
	
}
