package tp02;

import java.util.Random;

public class Dice {
	int numberSides ;
	Random rand = new Random();
	int value;
	
	Dice(int numberSides){
		if(numberSides>=2) {
			this.numberSides = numberSides;
			
		}else {
			this.numberSides = 1;
		}
		this.value = this.rand.nextInt(this.numberSides);
	}
		
}
