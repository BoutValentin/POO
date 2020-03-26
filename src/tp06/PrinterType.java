package tp06;

public enum PrinterType {
	DOTMATRIX('D'), INKJET('I'), LASER('L'), DYESUBLIMATION('S'), THREED('T');
	
	private char type ;
	
	private PrinterType(char type) {
		this.type = type;
	}
	
	public char getType() {
		return this.type;
	}
	
}
