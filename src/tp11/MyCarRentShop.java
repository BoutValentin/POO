package tp11;

public class MyCarRentShop {
	
	public static void main(String[] args) {
		Client alice = new AccomodatingClient("Alice");
		Client bruno = new FickleClient("Bruno");
		
		Criterion c1 = new IsFrom("Toyota");
		Criterion c2 = new CanBeHitched(true);
		
		alice.oneMore(c1);bruno.oneMore(c1);
		alice.oneMore(c2);bruno.oneMore(c2);
		
		Vehicule car = new Car("Toyota", false, 55.5);
		
		if(alice.valid(car)) {
			System.out.println("Alice est valider");
		}else {
			System.out.println("Alice valide pas");
		}
		if(bruno.valid(car)) {
			System.out.println("Bruno est valider");
		}else {
			System.out.println("Bruno valide pas");
		}
		
		System.out.println("Merging de critere");
		
		Criterion c3 = new IsFrom("Mercedes");
		Criterion c4 = new CanBeHitched(false);
		
		alice.oneMoreMerging(c3);alice.oneMoreMerging(c4);
		bruno.oneMoreMerging(c3);bruno.oneMoreMerging(c4);
		
		System.out.println("apres merginng");

		if(alice.valid(car)) {
			System.out.println("Alice est valider");
		}else {
			System.out.println("Alice valide pas");
		}
		if(bruno.valid(car)) {
			System.out.println("Bruno est valider");
		}else {
			System.out.println("Bruno valide pas");
		}
		
	}
}
