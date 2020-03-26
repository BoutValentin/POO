package tp04;

public class Card {
	private Color color;
	private Rank rank;
	
	public Card(Color color, Rank rank){
		this.color = color;
		this.rank = rank ;
	}
	
	public Card(String color, String rank){
		this.color = Color.valueOf(color);
		this.rank = Rank.valueOf(rank);
	}
	
	public Color getColor() {
		return this.color ;
	}
	
	public Rank getRank() {
		return this.rank ;
	}
	
	public int compareRanK(Card carte) {
		return this.rank.compareTo(carte.rank);
	}
	
	public int compareColor(Card carte) {
		return this.color.compareTo(carte.color);
	}
	
	public boolean isBefore(Card carte) {
		if(this.compareRanK(carte) < 0) {
			return true;
		}
		
		return false; 
	}
	
	public boolean equals(Card carte) {
		if(this == carte) return true;
		if(carte == null) return false;
		if(! this.color.equals(carte.color)) return false;
		if(! this.rank.equals(carte.rank)) return false ;
		return true;
	}
	
	public String toString() {
		return "["+this.color+", "+this.rank+"]";
	}
}
