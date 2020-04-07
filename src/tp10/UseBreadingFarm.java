package tp10;

public class UseBreadingFarm {

		public static void main(String[] args) {
			BreadingFarm farm = new BreadingFarm();
			for(int i = 0; i<5; i++) {
				farm.add(new Goose(150+i,10.0));
			}
			for(int i = 0; i<7; i++) {
				farm.add(new GuineaFowl(380+i,1.0));
			}
			for(int i = 0; i<8; i++) {
				farm.add(new Goose(700+i,15.0));
			}
			farm.add(new GuineaFowl(825, 2.5));
			
			System.out.println("Voici la ferme");
			System.out.println(farm.toString());
			
			farm.search(150).setWeight(15.0);
			farm.search(151).setWeight(15.0);
			
			farm.search(380).setWeight(1.5);
			farm.search(381).setWeight(1.5);
			
			System.out.println("le gain potentiel est de "+ farm.potentialProfit());
			
			System.out.println("Allez a l'abatoir");
			System.out.println(farm.slaughtering().toString());
			
			System.out.println("Ma nouvelle ferme apres l'abatage");
			System.out.println(farm.toString());
			
		}
}
