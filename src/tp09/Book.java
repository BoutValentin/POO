package tp09;

import java.time.LocalDate;
import java.util.Date;

public class Book {
	private String code;
	private String title;
	private String author;
	private int publicationYear;
	private int isBorrow;
	private LocalDate borrowingDate;
	public Book(String c, String t, String a, int p) {
		this.code=c;
		this.title=t;
		this.author=a;
		this.publicationYear=p;
		this.isBorrow = -1;
		this.borrowingDate=null;
	}
	public int getBorrow() {
		return this.isBorrow;
	}
	public void setBorrow(int b) {
		this.isBorrow = b;
	}
	public LocalDate getDate() {
		return this.borrowingDate;
	}
	public void setDate(LocalDate date) {
		this.borrowingDate=date;
	}
	public boolean borrow(int borrower) {
		if(this.isBorrow>0)return false;
		this.isBorrow = borrower;
		this.borrowingDate = LocalDate.now().plusDays(15);
		return true;
	}
	public int getDurationMax() {
		return 15;
	}
	public boolean giveBack() {
		if(this.isBorrow<0)return false;
		this.isBorrow = -1;
		this.borrowingDate=null;
		return true;
	}
	public boolean isAvaible() {
		return this.isBorrow<0;
	}
	public String toString() {
		return "["+this.code+", "+this.title+", "+this.author+", "+this.publicationYear+"]";
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
}
