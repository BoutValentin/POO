package tp14;
import java.util.ArrayList;
import java.util.List;
public class PriorityScheduler implements Scheduler {
	SchedulingQueue[] queues;
	
	public PriorityScheduler() {
		this.queues = new SchedulingQueue[3];
		for(int i=0;i<3;i++) {
			this.queues[i] = new SchedulingQueue();
		}
	}
	
	public void addElement(Priority p) {
		if(p.getPriority()>=this.queues.length) {
			//this.queues.add(p.getPriority(), new SchedulingQueue());
			System.out.println(this.queues.length);

		}else {
			this.queues[p.getPriority()].addElement(p);
		}
		
	}
	private boolean bigEmpty() {
		for(int i=0;i<this.queues.length;i++) {
			if(this.queues[i]!=null) return false;
		}
		return true;
	}
	public Priority hightestPriority() {
		if(this.bigEmpty()) return null;
		int i =0;
		while(i<this.queues.length && (this.queues[i].isEmpty() )) i++;
		if(i==this.queues.length) return null;
		return this.queues[i].hightestPriority();
	}
	public boolean isEmpty() {
		if(this.bigEmpty()) return true;
		for(SchedulingQueue q : this.queues) {
			if(!q.isEmpty()) return false;
		}
		return true;
	}
}
