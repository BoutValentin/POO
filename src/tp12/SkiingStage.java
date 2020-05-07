package tp12;

import java.util.List;

public class SkiingStage extends Stage {
	private double distance;
	public SkiingStage(double distance) {
		super();
		this.distance = distance;
	}
	public String toString() {
		return this.getID()+"(Skiing)"+this.distance+"m";
	}
	public String getType() {
		return "Skiing";
	}
	public int getLength() {
		return (int)this.distance;
	}
	public int getNbShots() {
		return 0;
	}
	public int getScore(Competitor aCompetitor) throws Exception_NoResult{
	Integer feedback = this.results.get(aCompetitor);
	if(feedback==null) throw new Exception_NoResult();
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
