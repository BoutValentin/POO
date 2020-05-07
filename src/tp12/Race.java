package tp12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Race {
	private final String NAME;
	Map<Integer,Competitor> competitors ;
	Set<Stage> stages;
	public Race(String N) {
		this.NAME = N;
		this.competitors = new HashMap<Integer, Competitor>();
		this.stages = new LinkedHashSet<Stage>();
	}
	public void addStage(Stage aStage) {
		this.stages.add(aStage);
	}

	public Stage getStage(int id) {
		int i =0;
		for(Stage s : this.stages) {
			if(id==i++)return s;
		}
		return null;
	}
	public void addCompetitor(Competitor c) {
		this.competitors.put(c.getID(), c);
	}
	public Competitor getCompetitor(int id) throws Exception_UnknownCompetitor{
		Competitor feedback = this.competitors.get((Integer)id);
		if(feedback==null) throw new Exception_UnknownCompetitor();
		return feedback;
	}
	public int getNbCompetitors() {
		return this.competitors.size();
	}
	private boolean isInList(List<Team> l, Team n) {
		for(Team t : l) {
			if(t.equals(n)) return true;
		}
		return false;
	}
	public int getNbTeams() {
		int cpt = 0;
		List<Team> save = new ArrayList<Team>();
		for(Map.Entry<Integer, Competitor> c : this.competitors.entrySet()) {
			if(! this.isInList(save, c.getValue().getTeam())) {
				save.add(c.getValue().getTeam());
				cpt++;
			}
		}
		return cpt;
	}
	private boolean isInList(List<Country> l, Country c) {
		for(Country pays: l) {
			if(pays.equals(c)) return true;
		}
		return false;
	}
	public int getNbCountries() {
		int cpt=0;
		List<Country> save = new ArrayList<Country>();
		for(Map.Entry<Integer, Competitor> c : this.competitors.entrySet()) {
			if(! this.isInList(save, c.getValue().getNationality())) {
				save.add(c.getValue().getNationality());
				cpt++;
			}
		}
		return cpt;
	}
	public int getTotalNbShots() {
		int cpt = 0;
		for(Stage s : this.stages) {
			cpt+=s.getNbShots();
		}
		return cpt;
	}
	public int getTotalLength() {
		int cpt = 0;
		for(Stage s : this.stages) {
			cpt+=s.getLength();
		}
		return cpt;
	}
	public void clearResults() {
		for(Stage s : this.stages) {
			s.clear();
		}
	}
	public void isValid(Competitor c) throws Exception_UnknownCompetitor {
		if(!this.competitors.containsValue(c)) throw new Exception_UnknownCompetitor();
	}
	public void isValid(int id) throws Exception_UnknownCompetitor{
		if(!this.competitors.containsKey((Integer) id)) throw new Exception_UnknownCompetitor();
	}
	public void record(Competitor c, Stage s, int value) throws Exception_UnknownCompetitor,Exception_InvalidRecord {
		this.isValid(c);
		s.record(c, value);
	}
	public int getScore(Competitor c, Stage stage) throws Exception_UnknownCompetitor, Exception_NoResult {
		this.isValid(c);
		return stage.getScore(c);
	}
	public int getScore(int cID, int sID) throws Exception_UnknownCompetitor, Exception_NoResult{
		return this.getScore(this.getCompetitor(cID), this.getStage(sID));
	}
	public int getCompetitorScore(Competitor c)  {
		int res = 0;
		for(Stage s : this.stages) {
			try {
			res+=this.getScore(c, s);
			}
			catch(Exception_UnknownCompetitor e) {
				System.out.println(e.getStackTrace()+"unknowCompetitor compeitroscore");
			}catch(Exception_NoResult e) {
				System.out.println(e.getStackTrace()+"noreuslts noResult");
			}
		}
		return res;
	}
	private int getNumberInTeam(Team t) {
		int res = 0;
		for(Map.Entry<Integer, Competitor> entry : this.competitors.entrySet()) {
			if(entry.getValue().getTeam().equals(t))res++;
		}
		return res;
	}
	private List<Competitor> sameTeam(Team t){
		List<Competitor> res = new ArrayList<Competitor>();
		for(Map.Entry<Integer, Competitor> entry : this.competitors.entrySet()) {
			if(entry.getValue().getTeam().equals(t))res.add(entry.getValue());
		}
		return res;
	}
	public int getTeamScore(Team team) {
		int numberInTeam = this.getNumberInTeam(team);
		if(numberInTeam==0) return (int)Double.MAX_VALUE;
		List<Competitor> aTeam = this.sameTeam(team);
		int res = 0;
		for(Stage s : this.stages) {
			for(Competitor c : aTeam) {
				try {
				res += this.getScore(c, s);
				}catch(Exception_UnknownCompetitor e) {
					System.out.println(e.getStackTrace()+"unknowCompetitor in teamScore");
				}catch(Exception_NoResult e) {
					System.out.println(e.getStackTrace()+"noresultTeamScore");
				}
			}
		}
		return (int)(res/numberInTeam);
		
	}
	private int getNumberInCountry(Country c) {
		int res = 0;
		for(Map.Entry<Integer, Competitor> entry : this.competitors.entrySet()){
			if(entry.getValue().getNationality().equals(c)) res++;
		}
		return res;
	}
	private List<Competitor> sameCountry(Country c){
		List<Competitor> res = new ArrayList<Competitor>();
		for(Map.Entry<Integer, Competitor> entry : this.competitors.entrySet()){
			if(entry.getValue().getNationality().equals(c)) res.add(entry.getValue());
		}
		return res;
	}
	public double getCountryScore(Country country) {
		int numberCOuntry = this.getNumberInCountry(country);
		if(numberCOuntry==0) return Double.MAX_VALUE;
		List<Competitor> coom = this.sameCountry(country);
		 double res = 0;
		for(Stage s : this.stages) {
			for(Competitor c : coom) {
				try {
					res += this.getScore(c, s);
				}catch(Exception_UnknownCompetitor e) {
					System.out.println(e.getStackTrace()+"unknowCompetitor in teamScore");
				}catch(Exception_NoResult e) {
					System.out.println(e.getStackTrace()+"noresultTeamScore");
				}
			}
		}
		return (res/numberCOuntry);
	}
}
