package tp09;

import java.util.Comparator;

public class ArticleComparatorMargin implements Comparator<Article>{
	
	public int compare(Article a, Article b) {
		return (a.getMargin()<b.getMargin()) ? -1 :1;
	}
}
