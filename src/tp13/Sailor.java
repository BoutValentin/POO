package tp13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class Sailor implements Serializable{
	private String name;
	private LocalDate birthDate;
	private transient long age;
	private boolean experiencedSailor;
	
	public Sailor(String name, LocalDate d, boolean b) {
		this.name = name;
		this.birthDate = d;
		this.experiencedSailor =b;
		this.age = LocalDate.now().getYear()-this.birthDate.getYear();
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public LocalDate getBirthDate() {
		return this.birthDate;
	}
	public void setBirthDate(LocalDate b) {
		this.birthDate = b;
	}
	public long getAge() {
		return this.age;
	}
	public void setAge() {
		this.age = LocalDate.now().getYear()-this.birthDate.getYear();
	}
	public boolean isExperiencedSailor() {
		return this.experiencedSailor;
	}
	public void setExperiencedSailor(boolean b) {
		this.experiencedSailor =b;
	}
	public String toString() {
		return this.name+"birtday "+this.birthDate.toString()+"age"+this.age+"boolean"+(this.experiencedSailor ? "IsExpericence" : "IsNotExperienced");
	}
	
	//On peut implementer les methodes read et write objec tpour definir porpore utilisation
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		this.name = (String) ois.readObject();
		this.birthDate = (LocalDate) ois.readObject();
		this.experiencedSailor = (boolean) ois.readObject();
		this.setAge();
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		oos.writeObject(this.name);
		oos.writeObject(this.birthDate);
		oos.writeObject(this.experiencedSailor);
	}
	
	
	
}
