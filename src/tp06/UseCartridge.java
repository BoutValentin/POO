package tp06;

public class UseCartridge {
	
	public static void main(String[] args) {
		Cartridge c1 = new Cartridge("P45HP-42J","Cartouche Toner", 54.99);
		Cartridge c2 = new Cartridge("ICWCP45-3D","Cartouche 3DInk-HP", 72.50);
		Cartridge c3 = new Cartridge("GC42-L42","Cartouche Toner", 41.99);
		
		ICartridgeStock p = new StockTab();
		p.addCartridge(c1);
		p.addCartridge(c2);
		p.addCartridge(c3);
		p.addCartridge(c2);
		ICartridgeStock p2 = new StockTab();
		Printer imp1 = new Printer("HPIJ3", PrinterType.INKJET,"HPIJ3", p);
		Printer imp2 = new Printer("HPDJ560C", PrinterType.LASER, "HP Deskjet 560C", p2);
		
	
		
		System.out.println(imp1.toString());
		System.out.println(imp2.toString());
	}
}
