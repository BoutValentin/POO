package tp07;

public class Participant {
	private String name;
	private Participant partner;
	
	public Participant(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	public Participant getPartner() {
		return this.partner;
	}
	public String getParterName() {
		return this.partner.name;
	}
	
	public String toString() {
		return "["+ this.getName() +"-> "+ this.getParterName() +"]";
	}
	
	public boolean isMatched() {
		if(this.partner==null) return false;
		return true;
	}
	public boolean isMatchedWidth(Participant p) {
		if(this==p || p==null) return false;
		if(this.partner.name!=p.getName() || this.name!= p.getParterName())return false;
		return true;
	}
	
	public boolean match(Participant p) {
		if(this.partner==null)return false;
		this.partner = p;
		p.match(this);
		return true;
	}
	public void breakOff() {
		this.partner.partner=null;
		this.partner=null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((partner == null) ? 0 : partner.hashCode());
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
		Participant other = (Participant) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (partner == null) {
			if (other.partner != null)
				return false;
		} else if (!partner.equals(other.partner))
			return false;
		return true;
	}
	
}
