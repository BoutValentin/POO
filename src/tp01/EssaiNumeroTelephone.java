package tp01;

import java.util.Random;

import td01.NumeroTelephone;
public class EssaiNumeroTelephone {
	public static void main(String[] args) {
		if(args.length==1) {
			Random nd = new Random();
			int nbNumero = Integer.parseInt(args[0]);
			NumeroTelephone[] tab = new NumeroTelephone[nbNumero];
			for(int i=0; i<nbNumero ; i++) {
				tab[i] = new NumeroTelephone(nd.nextInt(999), nd.nextInt(9)+1, nd.nextInt(100), nd.nextInt(100), nd.nextInt(100),nd.nextInt(100));
				
				for(int j=0 ; j<i; j++) {
					if(tab[i].equals(tab[j])) { 
						System.out.println(i);
						
						tab[j] = new NumeroTelephone(nd.nextInt(999), nd.nextInt(9)+1, nd.nextInt(100), nd.nextInt(100), nd.nextInt(100),nd.nextInt(100));
						
					}
				}
				System.out.println(tab[i].affichageStandard() + "          " + tab[i].affichageInternational());
			}
		}
	}
}
