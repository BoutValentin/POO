package tp02;

public class Competitor {
	String numberSign;
	int score;
	int time;
	
	//dossard entre 1 et 100, score 0 et 50, mniutes et sec <60
	Competitor(int numberSign, int score, int min, int sec){
		if(score>0 && score<=50 && min>=0 && min <=60 && sec>=0 && sec <=60 ) {
			this.numberSign = "N°"+numberSign;
			this.score = score;
			this.time = (min*60) +60;
		}else {
			this.numberSign = null;
		}	
	}
	
	public String display() {
		if(this.numberSign==null) {
			return "[" +  "<invalide>" + this.score + " points, " + this.time+"s]";
		
		}else {
			
		}
		return "[" + this.numberSign +", "+ this.score + " points, " + this.time+"s]";
	}
	
	public static void main(String[] args) {
		int[][] tabArgs = new int[100][5];
		tabArgs[0][0] = 1;
		tabArgs[0][1] = 45;
		tabArgs[0][2] = 15;
		tabArgs[0][3] = 20;
		
		tabArgs[1][0] = 2;
		tabArgs[1][1] = 32;
		tabArgs[1][2] = 12;
		tabArgs[1][3] = 45;

		tabArgs[2][0] = 5;
		tabArgs[2][1] = 12;
		tabArgs[2][2] = 13;
		tabArgs[2][3] = 59;

		tabArgs[3][0] = 12;
		tabArgs[3][1] = 12;
		tabArgs[3][2] = 15;
		tabArgs[3][3] = 70;
		
		tabArgs[4][0] = 32;
		tabArgs[4][1] = 75;
		tabArgs[4][2] = 15;
		tabArgs[4][3] = 20;

		for(int i = 0; i < tabArgs.length ; i ++) {
			Competitor compet = new Competitor(tabArgs[i][0], tabArgs[i][1], tabArgs[i][2], tabArgs[i][3]);
			if(compet.numberSign != null) {
			System.out.println(compet.display());
			}
		}
	}
}
