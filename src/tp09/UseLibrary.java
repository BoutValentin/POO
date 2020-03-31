package tp09;

import java.util.Iterator;

public class UseLibrary {
	public static void main(String[] args) {
		Book b1 = new Book("H2G2", "The hitchiker guide to the galaxy", "D.Adams", 1979);
		Book b2 = new Book("FLTL", "Flatland", "E.Abbott ", 1884);
		Book b3 = new Book("42", "The restaurant at the end of the universe", "D.Adams", 1980);
		Book b4 = new ComicBook("Leug", "Leonard est un genie", "Bob de groot", 1977, "turl");
		Library lib = new Library();
		lib.addBook(b1);lib.addBook(b2);lib.addBook(b3);lib.addBook(b4);
	
		System.out.println("Borrower");
		lib.borrow(b1.getCode(), 879);
		lib.borrow(b4.getCode(), 39);
		System.out.println(lib.borrowings());
		System.out.println("avaible:");
		Iterator<Book> it = new bookLine(lib.getCatalog());
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		lib.borrow(b1.getCode(), 7);
		System.out.println(lib.borrowings());
		lib.giveBack(b1.getCode());
		System.out.println(lib.borrowings());
		Book get = lib.getBook("H2G2");
		System.out.println(get.toString());
		System.out.println(lib.toString());
	}
}
