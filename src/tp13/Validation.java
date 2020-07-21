package tp13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

	public static void main(String[] args) {
		try {
			checkFiles("res/testScan.csv");
		}catch (InputMismatchException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (InvalidStructureException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("File goood");
	}
	public static boolean checkFiles(String path) throws IOException,InputMismatchException,FileNotFoundException,InvalidStructureException{
		Scanner sc = new Scanner(new File(path));
		Scanner sc2;
		int compteurInLine = 0;
		int type = 0;
		int numberToRead = 0;
		while(sc.hasNextLine()) {
			sc2 = new Scanner(sc.nextLine()).useDelimiter(";");
			while(sc2.hasNext()) {
				String readNow = sc2.next();
				if(compteurInLine==0) {
					type = Integer.parseInt(readNow);
					compteurInLine++;
				}else if(compteurInLine==1) {
					numberToRead = Integer.parseInt(readNow);
					compteurInLine++;
				}else {
					switch (type) {
					case 1:
						if(!readNow.equals("true") && !readNow.equals("false")) throw new InputMismatchException();
						compteurInLine++;
						break;
					case 2:
						Integer.parseInt(readNow);
						compteurInLine++;
						break;
					default:
						compteurInLine++;
						break;
					}
					//System.out.println(sc2.next());
				}
			}
			if((compteurInLine-2)!=numberToRead) throw new InvalidStructureException();
			compteurInLine=type=numberToRead=0;
			sc2.close();
		}
		sc.close();
		return true;
	}
}
