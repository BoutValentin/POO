package tp12;

import java.util.List;

public class ShootingStage extends Stage{
	private  int goodShot;
	private int penalty;
	public ShootingStage(int g, int p) {
		super();
		this.goodShot=g;
		this.penalty=p;
	}
	public ShootingStage(int g) {
		super();
		this.goodShot=g;
		this.penalty=10;
	}
	public String toString() {
		return this.getID()+"(Shooting)"+this.goodShot+"shots/penaltyPerMiss="+this.penalty+"s";
	}
	public String getType() {
		return "Shooting";
	}
	public int getNbShots() {
		return this.goodShot;
	}
	public int getLength() {
		return 0;
	}
	public int getScore(Competitor aCompetitor) throws Exception_NoResult{
	Integer feedback = this.results.get(aCompetitor);
	if(feedback==null) throw new Exception_NoResult();
	feedback*=this.penalty;
	return (int)feedback;
}
	public int getScore(List<Competitor> competitors) throws Exception_NoResult{
	Integer res = 0;
	for(Competitor c : competitors) {
		res += getScore(c);
	}
	return (int)res;
	
}
}
