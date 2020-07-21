package tp13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class UseBinarySerialization {
	public static void main(String[] args) {
		UseBinarySerialization ubs = new UseBinarySerialization();
		Sailor aSailor = new Sailor("dede", LocalDate.of(1967, 4, 19),false);
		Sailor aSailor2 = new Sailor("bbo", LocalDate.of(1970, 9, 27),false);
		Sailor aSailor3 = new Sailor("riblot", LocalDate.of(1989, 10, 1),true);
		Ship ship = new Ship("monBateua");
		ship.addSailor(aSailor);ship.addSailor(aSailor2);ship.addSailor(aSailor3);
		
		File aFile = new File("saveShip");
		try {
			if(aFile.exists())aFile.delete();
		}catch (Exception e) {
			e.printStackTrace();
		}
		ubs.saveShip(ship);
		
		Ship sh = ubs.loadShip("res/saveShip");
		System.out.println(sh.toString());
		/*Sailor aSailor = new Sailor("dede", LocalDate.of(1967, 04, 19),false);
		File aFile = new File("saveSailor");
		try {
			if(aFile.exists())aFile.delete();
		}catch (Exception e) {
			e.printStackTrace();
		}
		ubs.saveSailor(aSailor);*/
		//Sailor s = ubs.loadSailor("res/saveSailor");
		//System.out.println(s.toString());
	}
	public void saveSailor(Sailor s) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream( new File("res/saveSailor")))){
			oos.writeObject(s);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Sailor loadSailor(String filename) {
		Sailor s = null;
		try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(new File(filename)))){
			 s = (Sailor) ios.readObject();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	public void saveShip(Ship s) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream( new File("res/saveShip")))){
			oos.writeObject(s);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Ship loadShip(String filename) {
		Ship s = null;
		try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(new File(filename)))){
			 s = (Ship) ios.readObject();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
}
