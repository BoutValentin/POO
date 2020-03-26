package tp03;

public class PendingCaseQueue {
	private PendingCase[] myQueue ;
	private int capacityMax;
	private int head; 
	private int tail; 
	
	public PendingCaseQueue(int capacityMax){
		this.capacityMax = capacityMax;
		this.myQueue = new PendingCase[capacityMax];
		this.head = 0;
		this.tail = 0;
	}
	
	public void clear() {
		for(int i = 0; i<this.capacityMax ; i++) {
			this.myQueue[i] = null; 
		}
		this.head = 0;
		this.tail = 0;
	}
	
	public PendingCase getPendingCase(int pos) {
		return this.myQueue[(this.head+pos)%this.capacityMax];
	}
	
	public boolean isEmpty() {
		for(int i = 0; i<this.capacityMax; i++)
		{
			if(this.myQueue[i]!= null) return false;
		}
		return true;
	}
	
	public boolean isFull() {
		for(int i = 0; i<this.capacityMax; i++){
			if(this.myQueue[i]==null) return false;
		}
		return true;
	}
	
	public boolean addOne(PendingCase anotherPendingCase) {
		if(this.isFull())return false;
		this.myQueue[this.tail] = anotherPendingCase;
		this.tail = (++this.tail)%this.capacityMax;
		return true;
	}
	
	public int size() {
		if(this.isEmpty()) return this.capacityMax;
		return (this.head + this.tail)%this.capacityMax ; 
		
	}
	
	public PendingCase removeOne() {
		if(this.isEmpty()) return null;
		return this.myQueue[this.head];
	}
	
	public String toString() {
		String res = "";
		for(int i = 0; i<this.capacityMax;i++) {
			res = res.concat(this.myQueue[(i+this.head)%this.capacityMax].toString());
		}
		return res;
	}
	
	public double getTotalAmount() {
		double res = 0.0;
		for(int i = 0 ; i<this.capacityMax; i++ ) {
			res += this.myQueue[i].getAmount();
		}
		return res;
	}
	
	public void cheating(PendingCase anotherPendingCase, int position) {
		int posToAdd = (this.head + position)%this.capacityMax;
		if(! this.isFull()) {
			for(int i = 0 ; i<this.myQueue.length; i++) {
				//Faire le daclage + addOne jusqua ce quon rencontre le tail
				this.myQueue[i] = this.myQueue[i+1];
			}
			this.myQueue[posToAdd] = anotherPendingCase;
		}
	}
	
}
