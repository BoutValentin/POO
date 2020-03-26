package tp01;

public class UseBook {

	public static void main(String[] args) {
		Book [] biblio = new Book[5];
		biblio[0]= new Book("Conan Doyle", "Sherlock Holmes", 1804);
		biblio[1]= new Book("Kernighan B Ritchie D", "The C programming languages", 1970);
		biblio[2]= new Book("Uderzo Goscinny", "Astérix le Gaulois", 1980);
		biblio[3]= new Book("Stehphen Hawking", "Une bréve histoire de temps", 1980);
		biblio[4]= new Book("Conan Doyle", "Sherlock Holmes 2 ", 1805);
		for(int i = 0 ; i< biblio.length ; i++) {
			System.out.println(biblio[i]);
		}
	}
	
}
