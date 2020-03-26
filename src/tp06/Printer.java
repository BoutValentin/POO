package tp06;

public class Printer {

	private String label;
	private String publicName;
	private ICartridgeStock possibles ;
	private PrinterType type;
	
	public Printer(String label, PrinterType type, String publicName, ICartridgeStock possibles) {
		this.label = label;
		this.type = type;
		this.publicName = publicName;
		this.possibles = possibles ;
	}
	
	public int getNbCompatibleCartridge() {
		return this.possibles.getNbCartridge();
	}
	
	public String toString() {
		return this.label+":"+this.type+":"+this.possibles.getNbCartridge();
	}
}
