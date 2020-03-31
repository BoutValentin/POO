package tp09;

import java.time.LocalDate;

public class PerishableArticle extends Article{
	private static int dateLim = 10;
	private LocalDate deadLine ;
	
	public PerishableArticle(String idRef, String label, double pa, double pv, LocalDate d1) {
		super(idRef, label, pa,pv);
		this.deadLine=d1;
	}
	public PerishableArticle(String idRef, String label, double pa, LocalDate d1) {
		this(idRef, label, pa, pa*0.2+pa, d1);
	}
	public PerishableArticle(String idRef, String label, double pa, double pv) {
		this(idRef, label, pa, pv, LocalDate.now().plusDays(PerishableArticle.dateLim));
	}
	public PerishableArticle(String idRef, String label, double pa) {
		this(idRef, label, pa, pa*0.2+pa, LocalDate.now().plusDays(PerishableArticle.dateLim));
	}
	
	public LocalDate getDeadLine() {
		return this.deadLine;
	}
	public String toString() {
		return "Perishable "+ super.toString() + this.deadLine ;
	}
}
