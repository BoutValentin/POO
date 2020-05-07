package tp12;

public class Competitor {
	private static int compteur_id = 0;
	private final int id;
	private final String NAME;
	private Country nationnality;
	private Team team;
	
	public Competitor(String name, Country c, Team t) {
		this.NAME =name;
		this.nationnality = c;
		this.team = t;
		this.id = Competitor.compteur_id++;
	}
	
	public String toString() {
		return this.id+"-"+this.NAME+"("+this.nationnality.toString()+") -> " + this.team ;
	}
	
	public String getName() {
		return this.NAME;
	}
	public int getID() {
		return this.id;	
	}
	public Team getTeam() {
		return this.team;
	}
	public Country getNationality() {
		return this.nationnality;
	}
	public boolean isFrom(Team team) {
		if(team == null) return false;
		return this.team.equals(team);
	}
	public boolean isFrom(Country c) {
		if(c==null)return false;
		return this.nationnality.equals(c);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NAME == null) ? 0 : NAME.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competitor other = (Competitor) obj;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public static void resetCpt() {
		Competitor.compteur_id=0;
	}

}
