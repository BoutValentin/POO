package tp06;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseComparable {
	public static void main(String[] args) {
		Food f1 = new Food("pasta", 3.25, LocalDate.of(2019, 1, 1));
		Food f2 = new Food("fish", 10.0, LocalDate.of(2019, 1, 10));
		Food f3 = new Food("meat", 15.0, LocalDate.of(2019, 1, 3));
		ArrayList<Food> storage = new ArrayList<Food>();
		storage.add(f1);storage.add(f2);storage.add(f3);
		System.out.println(storage);
		Collections.sort(storage, new SortByPersih());
		System.out.println(storage);
	}
}
