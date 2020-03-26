package tp03;

public class Person {
	private String id ;
	private String name ;
	private String forename;
	
	public Person(String id, String name, String forename) {
		this.id = id;
		this.name = name;
		this.forename = forename;
	}
	
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}

	public String getForename() {
		return this.forename;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	public boolean equals(Person people) {
		if(this==null || this.id!=people.id)return false;
		return true;
	}
	
	public String toString() {
		return "id: "+this.id+" name: "+this.name+" forename: "+this.forename;
	}
}