package tp06;

public class Cartridge {
	
	private String label;
	private String name;
	private double price;
	
	public Cartridge(String label, String name, double price) {
		this.label = label;
		this.name = name;
		this.price = price;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
