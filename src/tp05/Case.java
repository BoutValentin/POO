package tp05;

public enum Case {
	DIRT("res/dirt.png"),
	SEA("res/sea.png"),
	GRASS("res/grass.png");
	
	private String path ; 
	
	private Case(String pa) {
		this.path=pa;
	}
	public String toString() {
		return this.path;
	}
	/*private static String base = "res/"; 
	public String toString() {
		return Case.base + this.name().toLowerCase() + ".png";
	}*/
}
