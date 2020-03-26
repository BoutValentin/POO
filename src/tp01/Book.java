package tp01;

public class Book {
	String author;
	String title;
	int year;
	//constructor
	Book(String a, String t, int an){
		author=a;
		title=t;
		year=an;	
	}
	//methods
	String getAuthor() {
		return author;
	}
	String getTitle() { 
		return title;
	}
	String getYear() {
		return year +"";
	}
	
	public String toString() {
		return getAuthor() + ": author, " + getTitle() + ": title, " + getYear() + ": year" ;
	}
}
