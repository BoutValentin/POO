package tp12;

public enum Country {
	FRANCE("FR"),GERMANY("GE"),RUSSIA("RS"),SWEDEN("SE"),AUSTRIA("AT"),ITALY("IT");
	
	private String courte;
	
	private Country(String s) {
		this.courte=s;
	}
	public String toString() {
		return this.courte;
	}
}
