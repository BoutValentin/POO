package tp01;

class HallOfFame {
	int[] scores = new int[] {0, 0, 0} ;
	String[] noms = new String[] { "", "", ""} ;
	/**
	 * Enregistre une partie (score + nom).
	 * Les valeurs renseignées sont insérées à leur position (par ordre décroissant de score).
	 * Un score plus bas que la dernière ligne du tableau ne modifiera rien.
	 * Un score plus haut que la première ligne décalera toutes les lignes (et éjectera
	 * la dernière ligne). Si deux parties ont exactement le même score, c'est la plus ancienne 
	 * qui sera placée avant l'autre.
	 * @param score Le score à enregistrer.
	 * @param nom Le nom à enregistrer. Plusieurs parties différentes peuvent porter le même nom).
	 */
	void enregistrer(int score, String nom) {
		int tmpScore ;
		String tmpNom ;
		// Recherche la position où doit être inséré le score.
		int index = 0 ;
		while ((index < scores.length) && (score <= scores[index])) {
			index++ ;
		}
		// Pour chacune des lignes suivantes (et dans l'ordre), on permute
		// la valeur courante et l'élément des tableaux scores et noms
		while (index < scores.length) {
			tmpScore = score ; score = scores[index] ; scores[index] = tmpScore ;
			tmpNom = nom ; nom = noms[index] ; noms[index] = tmpNom ;
			index++ ;
		}
 	}
	/**
	 * Retourne la valeur du score de la ligne index.
	 * @param index La ligne désirée (0 à 3)
	 * @return le score
	 */
	int lireScore(int index) {
		return scores[index] ;
	}
	
	/**
	 * Retourne la valeur du nom de la ligne index.
	 * @param index La ligne désirée (0 à 3)
	 * @return le nom
	 */
	String lireNom(int index) {
		return noms[index] ;
	}
	
	/** 
	 * Affiche le nom et le score des membres du HallOfFame
	 */
	void affichage() {
		System.out.println(lireScore(0) + ":" + lireNom(0));
		System.out.println(lireScore(1) + ":" + lireNom(1));
		System.out.println(lireScore(2) + ":" + lireNom(2));
	}
}