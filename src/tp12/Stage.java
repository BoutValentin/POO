package tp12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Stage {
	protected static int cpt_modif=0;
	private int id ;
	Map<Competitor, Integer> results ;
	public Stage() {
		this.id = Stage.cpt_modif++;
		this.results = new HashMap<Competitor, Integer>();
	}
	public int getID() {
		return this.id;
	}
	public static void resetCpt() {
		Stage.cpt_modif=0;
	}
	public void clear() {
		this.results.clear();
	}
	public int getNbRecord() {
		return this.results.size();
	}
	
	public void record(Competitor aCompetitor, int value) throws Exception_InvalidRecord {
		Integer feedback = this.results.putIfAbsent(aCompetitor, (Integer) value);
		if(feedback != null) throw new Exception_InvalidRecord();
	}
	
	/*public int getScore(Competitor aCompetitor) throws Exception_NoResult{
		Integer feedback = this.results.get(aCompetitor);
		if(feedback==null) throw new Exception_NoResult();
		feedback+= (feedback - this.getNbShots())*this.pe
		return (int)feedback;
	}
	public int getScore(List<Competitor> competitors) throws Exception_NoResult{
		Integer res = 0;
		for(Competitor c : competitors) {
			res += getScore(c);
		}
		return (int)res;
		
	}*/
	public abstract int getScore(Competitor aCompetitor) throws Exception_NoResult;
	public abstract int getScore(List<Competitor> competitors) throws Exception_NoResult;
	public abstract String getType();
	protected abstract int getLength();
	protected abstract int getNbShots();
	
	
	
}
