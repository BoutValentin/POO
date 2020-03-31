package tp09;

import java.time.LocalDate;
import java.util.*;

public class Shop {
	List<Article> catalog ;
	public Shop() {
		this.catalog = new ArrayList<Article>();
	}
	
	public String toString() {
		String res ="";
		for(Article a : this.catalog) {
			res += a.toString() + "\n";
		}
		return res;
	}
	private boolean isIn(String ref) {
		for(Article a : this.catalog) {
			if(a.getRef().equals(ref)) return true;
		}
		return false;
	}
	
	public boolean addArticle(Article a) {
		if(this.isIn(a.getRef())) return false;
		this.catalog.add(a);
		return true;
	}
	public List<PerishableArticle> getPerishable(){
		List<PerishableArticle> l =  new ArrayList<PerishableArticle>();
		for(Article a : this.catalog) {
			if(a instanceof PerishableArticle) l.add((PerishableArticle)a);
		}
		return l;
	}
	public void discountPerishable(LocalDate threshold, double rate) {
		List<PerishableArticle> l = this.getPerishable();
		for(int i =0; i<l.size(); i++) {
			if(l.get(i).getDeadLine().isAfter(threshold)) l.get(i).setSalePrice(l.get(i).getSalePrice()*rate);
		}
	}
	
	public void discountNotPerishable(int nb, double rate) {
		List<PerishableArticle> l = this.getPerishable();
		l.sort(new ArticleComparator());
		for(int i = 0; i<l.size() && i<nb; i++) {
			l.get(i).setSalePrice(l.get(i).getSalePrice()*rate);
		}

	}
	private List<Article> getNotPerishable(){
		List<Article> l =  new ArrayList<Article>();
		for(Article a : this.catalog) {
			if(a instanceof PerishableArticle == false) l.add(a);
		}
		return l;
	}
	public void discountNotPerishable(double rate) {
		List<Article> l = this.getNotPerishable();
		for(int i =0; i<l.size();i++) {
			l.get(i).setSalePrice(l.get(i).getSalePrice()*rate);
		}
	}
	public Article mostProfitable() {
		List<Article> l = this.catalog;
		l.sort(new ArticleComparatorMargin());
		return l.get(l.size()-1);
	}
	public Article lessProfitable() {
		List<Article> l = this.catalog;
		l.sort(new ArticleComparatorMargin());
		return l.get(0);
	}
	public void leastProfitableRemoval() {
		Article a =  this.lessProfitable();
		this.catalog.remove(a);
	}
	
}
