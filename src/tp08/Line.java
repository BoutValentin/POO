package tp08;

import java.util.*;

public class Line {
	private ArrayList<Integer> myLine ;
	public Line(Collection<Integer> collec){
		this.myLine = (ArrayList<Integer>)collec;
	}
	public ArrayList<Integer> getValues(){
		return (ArrayList<Integer>) this.myLine;
	}
	public String toString() {
		return this.myLine.toString();
	}
}
