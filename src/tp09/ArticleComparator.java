package tp09;

import java.util.Comparator;

public class ArticleComparator implements Comparator<PerishableArticle>{
	
	public int compare(PerishableArticle a, PerishableArticle b) {
		return (a.getDeadLine().isBefore(b.getDeadLine()))? -1:1;
	}
}
