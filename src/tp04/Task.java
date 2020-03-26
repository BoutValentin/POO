package tp04;

import java.time.LocalDate;

public class Task {
	
	private static String numid;
	private LocalDate creationDate;
	private LocalDate deadkube;
	private String description;
	private int duration;
	private TaskStatus state;
	public String getNumid() {
		return Task.numid;
	}
	public TaskStatus getStatus() {
		return this.state;
	}
	public LocalDate getCreationDate() {
		return this.creationDate;
	}
	
	public LocalDate getDeadkube() {
		return this.deadkube;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public Task(String description, int duration){
		this.description = description;
		this.duration = duration;
		this.creationDate = LocalDate.now();
		this.deadkube = this.creationDate.plusDays(10);
		this.state = TaskStatus.valueOf("TODO");
		Task.numid = ""+(Math.abs(LocalDate.now().getYear()) % 10) + (LocalDate.now().getMonth()) + (Integer.parseInt(Task.numid.substring(4))+1) +"1";
	
	}
	
	public Task(String description, LocalDate creation, LocalDate deadline, int duration){
		this.description = description;
		
		this.creationDate = creation;
		this.deadkube = deadline;
		this.duration = duration;
		this.state = TaskStatus.valueOf("TODO");
		System.out.println(Task.numid);
		//Task.numid = ""+(Math.abs(LocalDate.now().getYear()) % 10) + (LocalDate.now().getMonth()) + (Integer.parseInt(Task.numid.substring(4))+1);
		System.out.println("compiler");
	}
	
	public void changeStatus() {
		this.state = TaskStatus.values()[(this.state.ordinal()+1) % (TaskStatus.values().length)];
	}
	
	public void changeStatus(TaskStatus st) {
		this.state = st;
	}
	
	public void changeStatus(char c) {
		if(c=='T' || c=='t') {
			this.state = TaskStatus.valueOf("ONGOING");
		}else if(c=='O' || c=='o') {
			this.state = TaskStatus.valueOf("DELAYED");
		}else if(c=='D' || c=='d') {
			this.state = TaskStatus.valueOf("DONE");
		}
	}
	
	public String toString() {
		return "["+Task.numid+ " = "+this.description+":"+ this.getStatus().toString()+":"+this.deadkube ;
	}
	
	public boolean isLate() {
		if(this.deadkube.isBefore(LocalDate.now())) return false;
		return true;
	}
	
	public void delay(int nbDays) {
		this.deadkube = this.getDeadkube().plusDays(nbDays);
	}
}
