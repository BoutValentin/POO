package tp03;

public class Student {
	private double[] grades;
	private Person pers ;
	
	public double[] getGrades() {
		return grades;
	}

	public void setGrades(double[] grades) {
		this.grades = grades;
	}

	public Person getPers() {
		return pers;
	}

	public void setPers(Person pers) {
		this.pers = pers;
	}

	public Student(String id, String name, String forename, double[] grade) {
		this.pers = new Person(id, name, forename);
		this.grades = grade;
	}
	
	public String toString() {
		String res = null;
		for(int i=0 ; i<this.grades.length; i++){
			res = res.concat((this.grades[i]+""));
		}
		return pers.toString() + res ; 
	}
	
	public boolean equals(Student other) {
		if(other==null)return false;
		if(this == other) return true;
		if(! this.pers.equals(other.pers)) return false;
		for(int i=0; i<this.grades.length ; i++) {
			if(this.grades[i] != other.grades[i]) return false;
		}
		return true;
	}
	
	public double getAverage() {
		double moy = 0.0;
		for(int i =0; i<this.grades.length ; i++)
		{
			moy += this.grades[i];
		}
		return moy/this.grades.length ;
	}
	
	public void addGrade(double aGrade) {
		double[] grades2 = new double[this.grades.length+1];
		for(int i = 0; i<this.grades.length; i++) {
			grades2[i] = this.grades[i];
		}
		grades2[this.grades.length] = aGrade;
		this.grades = grades2;
	}

	
	
	public String getId() {
		return this.pers.getId();
	}

	public String getName() {
		return this.pers.getName();
	}

	public String getForename() {
		return this.pers.getForename();
	}
	
}
