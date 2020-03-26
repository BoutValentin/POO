package tp01;

import java.util.Random;

public class SequenceAleatoire {
	
	public static void main(String[] args) {
		final String INT = "ENTIER";
		final String REEL = "REEL" ;
		Random nd = new Random();
		if(args.length>=2 && args.length<=3) {
		int valeurGenere = Integer.parseInt(args[0]);
		
		for(int i=0; i<valeurGenere; i++) {
			if(args.length == 3) {
				if(INT.equals(args[2])) {
					int valeurMax = Integer.parseInt(args[1]);
					System.out.println(nd.nextInt(valeurMax));
				}else if (REEL.equals(args[2])) {
					double valeurMax = Double.parseDouble(args[1]);
					System.out.println(nd.nextDouble()*valeurMax);
				}else {
					System.out.println("\"Utilisation incorrecte: <nbElt> <maxVal> [ENTIER|REEL]\"");
					break;
				}
			}
		}
		}else {
			System.out.println("\"Utilisation incorrecte: <nbElt> <maxVal> [ENTIER|REEL]\"");
		}
	}
}
