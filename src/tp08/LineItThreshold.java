package tp08;
import java.util.*;
public class LineItThreshold implements Iterator<Integer>{
	private ArrayList<Integer> list;
	private int idx;
	private int threshold;
	
	LineItThreshold(ArrayList<Integer> list, int thre){
		this.list = list;
		this.threshold = thre;
		this.idx = -1;
		this.findNextElement();
	}
	
	private void findNextElement() {
		this.idx++;
		while(this.idx<this.list.size() && this.list.get(this.idx)<=this.threshold) this.idx++;
		
	}
	public boolean hasNext() {
		return this.idx<this.list.size();
	}
	
	public Integer next() {
		Integer i = this.list.get(this.idx);
		this.findNextElement();
		return i;
	}
	
}
