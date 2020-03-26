package tp04;

import javax.swing.JOptionPane;


public class Input {
	
	static int inputInteger(int min, int max) {
		String value ;
		do {
			value = JOptionPane.showInputDialog("Entrez un num entre"+min+"et"+max);
			if(! Input.inputControlInteger(value, min, max)) JOptionPane.showMessageDialog(null, "AIE Pas bon dans l'interval");
		}while(! Input.inputControlInteger(value, min, max));
		
		return Integer.parseInt(value);
	}
	
	static boolean inputControlInteger(String s, int min, int max) {
		
		if(! s.matches("[0-9]+"))return false;
		if(Integer.parseInt(s)<min || Integer.parseInt(s)>max) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Input.inputInteger(25, 38);
	}
	
	
}
