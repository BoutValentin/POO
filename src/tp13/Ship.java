package tp13;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ship implements Serializable{

	private String name;
	private Set<Sailor> crew;
	
	public Ship() {
		this.name = "defaultName";
		this.crew = new HashSet<Sailor>();
	}
	public Ship(String name) {
		this.name = name;
		this.crew = new HashSet<Sailor>();
	}
	public Ship(String name, Set<Sailor> set ) {
		this.name = name;
		this.crew = set;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Sailor> getCrew() {
		return crew;
	}
	public void setCrew(Set<Sailor> crew) {
		this.crew = crew;
	}
	public void addSailor(Sailor s) {
		try {
			this.crew.add(s);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("nameBoat:"+this.name);
		for(Sailor s: this.crew) {
			sb.append(s.toString()+"\n");
		}
		return sb.toString();
	}
}
