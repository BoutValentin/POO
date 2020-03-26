package tp04;

import java.time.LocalDate;


import util.Keyboard;


public class UseLocalDate {
	
	static String dateOfTheDay() {
		return LocalDate.now().toString();
	}
	
	static LocalDate inputDate() {
		int year, month, date ; 
		do {
			year = Keyboard.readInt("Entrez l'année");
		}while(year<0);
		do {	
			month = Keyboard.readInt("Entrez le mois");
		}while(month<0 || month >=13);
		do {
			date = Keyboard.readInt("Entrez le jour");
		}while(date<=0 || date>=LocalDate.of(year, month, 1).lengthOfMonth());
		return LocalDate.of(year, month, date);
	}
	
	static String diffDate() {
		LocalDate date1 = UseLocalDate.inputDate();
		System.out.println("Ta deuxieme date");
		LocalDate date2 = UseLocalDate.inputDate();
		if(date1.isBefore(date2)) {
			
			return date1.toString() + " "+ date2.toString() + " until:"+ date1.until(date2).toString() ;
		}
			return date2.toString() + " "+ date1.toString() + " until" + date2.until(date1).toString() ;		
	}
	
	public static void main(String[] args) {
		System.out.println(UseLocalDate.diffDate());
	}
}
