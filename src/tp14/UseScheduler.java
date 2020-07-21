package tp14;

public class UseScheduler {

	public static void useSchedulingQueue() {
		Task t1 = new Task(0, "task1");
		Task t2 = new Task(0, "task2");
		Task t3 = new Task(0, "task3");
		SchedulingQueue sq = new SchedulingQueue();
		if(sq.isEmpty())System.out.println("isEmpty now");
		sq.addElement(t1);
		sq.addElement(t2);
		sq.addElement(t3);
		System.out.println(sq.hightestPriority());
		if(sq.isEmpty())System.out.println("isEmpty now");
		System.out.println(sq.hightestPriority());
		System.out.println(sq.hightestPriority());
		if(sq.isEmpty())System.out.println("isEmpty now");
		
	}
	public static void usePriorityScheduler() {
		Task t1 = new Task(0, "task1");
		Task t2 = new Task(1, "task2");
		Task t3 = new Task(1, "task3");
		Task t4 = new Task(1, "task4");
		Task t5 = new Task(2, "task5");
		Task t6 = new Task(0, "task6");
		PriorityScheduler pq = new PriorityScheduler();
		if(pq.isEmpty()) System.out.println("is empty now");
		pq.addElement(t1);pq.addElement(t2);pq.addElement(t3);pq.addElement(t4);pq.addElement(t5);pq.addElement(t6);
		System.out.println(pq.hightestPriority());
		if(pq.isEmpty()) System.out.println("is empty now");
		System.out.println(pq.hightestPriority());
		System.out.println(pq.hightestPriority());
		System.out.println(pq.hightestPriority());
		System.out.println(pq.hightestPriority());
		System.out.println(pq.hightestPriority());
		if(pq.isEmpty()) System.out.println("is empty now");

	}
	public static void system() {
		//ProcessDisplay pd1= new ProcessDisplay(p, e, message, e2)
	}
	public static void main(String[] args) {
		UseScheduler.useSchedulingQueue();
		System.out.println("another systeme \n\n\n");
		UseScheduler.usePriorityScheduler();
	}
}
