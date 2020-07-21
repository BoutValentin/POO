package tp13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class UseDirectory {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(new File("res/directory.txt")))){
			String read = br.readLine();
			while(read!=null) {
				String name= read.substring(0, read.indexOf("\t")+1);
				String naissance = read.substring(read.indexOf("\t")+1);
				
				System.out.println(name+" "+(LocalDate.now().getYear()-Integer.parseInt(naissance)));
				read=br.readLine();
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
