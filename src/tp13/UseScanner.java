package tp13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.NotActiveException;
import java.util.Scanner;

public class UseScanner {
	
	public static void main(String[] args) {
		int resultat = 0;
		boolean valid = true;
		try (Scanner sc = new Scanner(System.in)){
			while(sc.hasNext() && valid) {
				String sb = sc.next();
				if(sb.equals("bye")) {
					valid=false; break;
				}
				int aRes;
				try{
					aRes= Integer.parseInt(sb);
					resultat+=aRes;
				}catch (NumberFormatException e) {
					System.out.println("not a number");
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("resultat"+resultat);
	}
}
