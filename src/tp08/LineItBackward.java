package tp08;
import java.util.*;

public class LineItBackward implements Iterator<Integer>{
	private ArrayList<Integer> list;
	private int idx;
	LineItBackward(ArrayList<Integer> array){
		this.list = array;
		this.idx = this.list.size()-1;
	}
	
	public boolean hasNext() {
		return this.idx>=0;
	}
	public Integer next() {
		Integer i = this.list.get(this.idx);
		this.idx--;
		return i;
	}
}
