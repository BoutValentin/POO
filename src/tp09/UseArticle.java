package tp09;

import java.time.LocalDate;

public class UseArticle {
	public static void main(String[] args) {
		
		LocalDate d1 = LocalDate.now().plusMonths(2);
		Article a1 = new Article("52er5", "table", 5.05);
		Article a2 = new Article("785rt5", "chaise", 15.08, 789.01);
		Article a3 = new Article("7012zer", "tabouret", 1.05);
		Article a4 = new PerishableArticle("896e", "choco", 785.20, d1);
		Article a5 = new PerishableArticle("74fds5", "pasta", 44.0,78.25 );
		Shop shopper = new Shop();
		
		
		shopper.addArticle(a1);shopper.addArticle(a2);
		shopper.addArticle(a3);shopper.addArticle(a4);
		shopper.addArticle(a5);
		System.out.println("shopper string");
		System.out.println(shopper.toString());
		System.out.println("    ");
		System.out.println("lees");
		Article test = shopper.lessProfitable();
		System.out.println(test.toString());
		shopper.leastProfitableRemoval();
		System.out.println(shopper.toString());
		System.out.println("    ");
		shopper.discountPerishable(LocalDate.now().plusDays(25), 0.15);
		System.out.println(shopper.toString());
	}
}
