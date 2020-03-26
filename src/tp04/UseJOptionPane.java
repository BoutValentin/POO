package tp04;
import javax.swing.JOptionPane ;

public class UseJOptionPane {
	
	public static void main(String[] args) {
		int dialog = JOptionPane.showConfirmDialog(null, "COUCOU");
		System.out.println(dialog);
		String input = JOptionPane.showInputDialog("HELLO");
		System.out.println(input);
		JOptionPane.showMessageDialog(null, "BRAVI");
	}
}
