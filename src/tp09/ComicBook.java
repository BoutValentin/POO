package tp09;

import java.time.LocalDate;

public class ComicBook extends Book {
	private String illustrator;
	public ComicBook(String code, String title, String author, int pu, String ill) {
		super(code, title, author, pu);
		this.illustrator=ill;
	}
	public String toString() {
		return "[Comic:"+super.getCode()+super.getAuthor()+super.getTitle()+super.getTitle()+this.illustrator+"]";
	}
	public int getDurationMax() {
		return (super.getPublicationYear()-LocalDate.now().getYear()<=2) ? 5 : super.getDurationMax();
	}

	public boolean borrow(int borrower) {
			if(super.getBorrow()>0)return false;
			super.setBorrow(borrower);
			super.setDate(LocalDate.now().plusDays(this.getDurationMax()));
			return true;
	}
	public boolean giveBack() {
		if(super.getBorrow()<0)return false;
		super.setBorrow(-1);
		super.setDate(null);
		return true;
	}
}
