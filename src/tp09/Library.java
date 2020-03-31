package tp09;
import java.util.*;
public class Library {
	private List<Book> catalog ;
	
	public Library() {
		this.catalog = new ArrayList<Book>();
	}
	public Book getBook(String s) {
		for(int i = 0; i<this.catalog.size(); i++) {
			if(this.catalog.get(i).getCode().equals(s)) return this.catalog.get(i);
		}
		return null;
	}
	public List<Book> getCatalog(){
		return this.catalog;
	}
	private boolean isInBook(String s) {
		for(int i = 0; i<this.catalog.size(); i++) {
			if(this.catalog.get(i).getCode().equals(s)) return true;
		}
		return false;
	}
	public boolean addBook(Book b) {
		if( this.isInBook(b.getCode()))return false;
		this.catalog.add(b);
		return false;
	}
	public boolean removeBook(String code) {
		if(this.isInBook(code)) return false;
		for(int i = 0; i<this.catalog.size(); i++) {
			if(this.catalog.get(i).getCode().equals(code)) this.catalog.remove(i);
		}
		return true;
	}
	public boolean removeBook(Book b) {
		if(this.isInBook(b.getCode())) return false;
		this.catalog.remove(b);
		return true;
	}
	public String toString() {
		String res = "";
		for(Book b : this.catalog) {
			res += b.toString();
		}
		return res;
	}
	public String borrowings() {
		String res = "";
		for(Book b : this.catalog) {
			if(! b.isAvaible()) res+= b.toString()+b.getBorrow()+b.getDate();
		}
		return res;
	}
	public boolean borrow(String code, int borrower) {
		if(! this.isInBook(code)) return false;
		for(int i = 0; i<this.catalog.size(); i++) {
			if(this.catalog.get(i).getCode().equals(code)) {
				this.catalog.get(i).borrow(borrower);
				return true;
			}
		}
		return false;
	}
	public boolean giveBack(String code) {
		if(! this.isInBook(code)) return false;
		for(int i =0; i<this.catalog.size(); i++) {
			if(this.catalog.get(i).getCode().equals(code)){
				this.catalog.get(i).giveBack();
				return true;
			}
		}
		return false;
	}
	
}
