package tp06;

import java.util.ArrayList;

public class StockAl implements ICartridgeStock{
	ArrayList<Cartridge> array;

	@Override
	public void addCartridge(Cartridge cartouche) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNbCartridge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cartridge getCartridge(int nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	public StockAl() {
		this.array = new ArrayList<Cartridge>();
	}
	public StockAl(ArrayList<Cartridge> cartouche) {
		this.array = cartouche;
	}
	private int lastElt() {
		return this.array.size();
	}
}
