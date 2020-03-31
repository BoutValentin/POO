package tp09;

import java.util.Iterator;
import java.util.List;

public class bookLine implements Iterator<Book>{
	private List<Book> l;
	private int i;
	
	public bookLine(List<Book> l) {
		this.l=l;
		this.i=-1;
		this.findNextElement();
	}
	private void findNextElement() {
		this.i++;
		while(this.i<this.l.size() && ! this.l.get(i).isAvaible() ) this.i++;
	}
	public boolean hasNext() {
		return this.i<this.l.size();
	}
	public Book next() {
		Book b = this.l.get(i);
		this.findNextElement();
		return b;
	}
	
}
