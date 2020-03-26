package tp03;

public class StudentAbs {
	private int nbAbsence;
	private Student etu;
	
	public int getNbAbsence() {
		return nbAbsence;
	}
	public void setNbAbsence(int nbAbsence) {
		this.nbAbsence = nbAbsence;
	}
	public Student getEtu() {
		return etu;
	}
	public void setEtu(Student etu) {
		this.etu = etu;
	}
	
	public StudentAbs(String id, String name, String forename, double[] grade) {
		this.etu = new Student(id, name, forename, grade);
		this.nbAbsence = 0;
	}
	
	public String toString() {
		return "nbAsence: "+ this.nbAbsence+ this.etu.toString();
	}
	
	public boolean equals(StudentAbs other) {
		if(other==null)return false;
		if(this.etu==null) {
			if(other.etu!=null) return false;
		}
		if(this==other)return true;
		if(this.nbAbsence != other.nbAbsence) return false;
		if(! this.etu.equals(other.etu)) return false;
		return true;
	}
	
	public boolean warning(int thresholdAbs, double thresholdAvg) {
		return (this.nbAbsence>= thresholdAbs || this.etu.getAverage() <= thresholdAvg) ;
	}
	
	public boolean validation(int thresholdAbs, double thresholdAvg) {
		return (this.nbAbsence<thresholdAbs && this.etu.getAverage()> thresholdAvg);
	}
	
}
