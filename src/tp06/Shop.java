package tp06;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Shelf> shelving ;
	
	public Shop() {
		this.shelving = new ArrayList<Shelf>();
	}
	
	public Shop(ArrayList<Shelf> array) {
		this.shelving = array ;
	}
	
	public String toString() {
		String res = null;
		for(Shelf ray : shelving) {
			res += ray.toString();
		}
		return res;
	}
	
	public void tidy(ArrayList<IProduct> aStock) {
		for(IProduct pro : aStock) {
			for(Shelf shel : this.shelving) {
				if(shel.add(pro))break;
			}
		}
	}
	
	public void closeBestBeforeDate(int nbDays) {
		
	}
}
