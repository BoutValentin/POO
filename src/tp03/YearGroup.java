package tp03;

public class YearGroup {
	private StudentAbs[] gp;
	
	public YearGroup(int nbrEtudiants) {
		this.gp = new StudentAbs[nbrEtudiants];
	}
	
	public StudentAbs getStudentsAbs(int i) {
		return gp[i];
	}
	
	public void setStudentAbs(int i, StudentAbs person) {
		this.gp[i] = person;
	}
	
	public void addGrades(double[] aTest) {
		for(int i = 0; i<this.gp.length ; i++) {
			this.gp[i].getEtu().addGrade(aTest[i]);  
		}
	}
	
	void validation(int thresholdAbs, int thresholdAvg) {
		for(int i = 0; i<this.gp.length; i++) {
			if(this.gp[i].validation(thresholdAbs, thresholdAvg)) {
				System.out.println(this.gp[i].getEtu().toString() + " a valider");
			}
		}
	}
}
