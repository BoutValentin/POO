package tp13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DicoJava {
	
	public static void main(String[] args) {
		StringBuilder aStringRes = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(new File("res/DicoJava.txt")))){
			
			String sb = br.readLine();
			while(sb!=null) {
				String sbCopye = sb ;
				sbCopye=sbCopye.substring(sbCopye.indexOf("\t")+1, sbCopye.indexOf("\t")+8);
				System.out.println(sbCopye);
				if(sbCopye.contains("Mot-clé")) {
					aStringRes.append(sb);
					aStringRes.append("\n");
				}
				sb=br.readLine();
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		try(FileWriter fw = new FileWriter(new File("res/MotsJava.txt"))){
			fw.write(aStringRes.toString());
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
