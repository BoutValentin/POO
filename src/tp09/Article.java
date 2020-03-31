package tp09;


public class Article {
	private static double marge = 0.2;
	private String idRef;
	private String label;
	private final double PURCHASE_PRICE;
	private double salePrice;
	
	public Article(String id, String l, double pp, double sp) {
		this.idRef = id;
		this.label = l;
		this.PURCHASE_PRICE = pp;
		this.salePrice = sp;
	}
	public String getRef() {
		return this.idRef;
	}
	public Article(String id, String l, double pp) {
		this(id,l,pp,Article.marge*pp+pp);
	}
	public double getSalePrice() {
		return this.salePrice;
	}
	public void setSalePrice(double s) {
		this.salePrice = s;
	}
	public double getPurchasePrice() {
		return this.PURCHASE_PRICE;
	}
	public double getMarge() {
		return Article.marge;
	}
	public void setMarge(double m) {
		Article.marge = m;
	}
	public double getMargin() {
		return this.salePrice-this.PURCHASE_PRICE;
	}
	public String toString() {
		return "["+this.idRef+":"+this.label+"="+this.PURCHASE_PRICE+"e/"+this.salePrice+"e]";
	}
}
