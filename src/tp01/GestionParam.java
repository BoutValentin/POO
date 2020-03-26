package tp01;

public class GestionParam {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("Aucun paramètre");
		}
		for(int i=0; i<args.length; i++) {
			System.out.println("(" + (i+1) + ")" + args[i]);
		}
	}
}
