package tp06;

public class Supplies {
	private String label;
	private double price;
	private static int unknow;
	
	public Supplies(String label, double prix) {
		if(label==null) {
			this.label="refUnknow"+Supplies.unknow;
			Supplies.unknow++;
		}else {
			this.price = prix;
		}
		this.price = prix;
	}
	
	public String toString() {
		return "["+ this.label+"="+this.price +"$]";
	}

	public String getLabel() {
		return label;
	}

	public double getPrice() {
		return price;
	}

	
	
}

