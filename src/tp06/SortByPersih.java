package tp06;

import java.util.Comparator;

public class SortByPersih implements Comparator<Food>{

	public int compare(Food a, Food b) {
		if(a.isBestBefore(b.getBestBeforeDate())) {
			return -1;
		}
		return 1;
	}
	
}
