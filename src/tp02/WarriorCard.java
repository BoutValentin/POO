package tp02;

/** 
 * <p><i><a href="www.google.com">Link to google.com</a></i></p>
 * <p>Voici une présentation de la class <b>WarriorCard</b></p>
 * <img alt="javalogo" src="https://i.pinimg.com/originals/de/53/98/de5398f9aeacf2e0ebdac57ba8524319.jpg" >
 * */

public class WarriorCard {
	String name;
	int s;
	int ag;
	
	/** 
	 * Construceur d'une carte de guerrier
	 * 
	 * @param name un String pour nom de l'individu sur la carte
	 *@param s un entier entre 0 et 9 definissant sa force
	 *@param ag un entier entre 0 et 9 representant son agilite
	 * */
	WarriorCard(String name, int s, int ag){
		this.name = name;
		this.s = s;
		this.ag = ag;
	}
	
	/** 
	 * Détermine si la carte passer en parametre est égal a la carte courant
	 * @param other WarriorCard
	 * @return boolean true si les cartes sont egales
	 * */
	public boolean equals(WarriorCard other) {
		if(this == other)return true;
		if(other == null) return false;
		if( ! this.name.equals(other.name)) return false;
		if(this.s != other.s)return false;
		if(this.ag != other.ag) return false;
		return true;
	}
	
	/** 
	 * Compare la force des cartes courantes et celle en parametre
	 * @param other WarriorCard 
	 * @return 0 si les deux guerriers ont une force équivalente;
 inferieure 0 si la force du guerrier courant est inférieure à celle de celui passé en paramètre;
 superieure 0 si la force du guerrier courant est supérieure à celle de celui passé en paramètre.
	 * */
	public int compareStrength(WarriorCard other) {
		if(this.s==other.s)return 0;
		if(this.s<other.s)return -1;
		return 1;
	}

	/** 
	 * Compare l'agility des cartes courantes et celle en parametre
	 * @param other WarriorCard 
	 * @return 0 si les deux guerriers ont une agilité équivalente;
iferireir 0 si l’agilité du guerrier courant est inférieure à celle de celui passé en paramètre;
superieur 0 si l’agilité du guerrier courant est supérieure à celle de celui passé en paramètre. 
	 * */
	public int compareAgility(WarriorCard other) {
		if(this.ag==other.ag)return 0;
		if(this.ag < other.ag)return -1;
		return 1;
	}
	
	/** 
	 * Retoune une represenation textuelle de la carte
	 * @return string
	 * */
	public String toString() {
		return this.name + "[S=" + this.s + ",A=" + this.ag + "]";
	}
	
}
