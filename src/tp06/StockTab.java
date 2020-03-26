package tp06;

public class StockTab implements ICartridgeStock  {
	
	private Cartridge[] stock;
	
	public StockTab() {
		this.stock = new Cartridge[] {null,null,null};
	}
	
	public StockTab(Cartridge[] cartouche) {
		this.stock = cartouche.clone();
	}
	
	private int lastElt() {
		for(int i = 0; i<this.stock.length; i++) {
			if(this.stock[i]==null) return i;
		}
		return (this.stock.length );
	}

	@Override
	public void addCartridge(Cartridge cartouche) {
		if(this.lastElt()<this.stock.length) this.stock[this.lastElt()]=cartouche;
		
	}

	@Override
	public int getNbCartridge() {
		return this.lastElt();
	}

	@Override
	public Cartridge getCartridge(int nombre) {
		if(nombre<0 || nombre >= this.stock.length) return null;
		return this.stock[nombre];
	}
	
}
