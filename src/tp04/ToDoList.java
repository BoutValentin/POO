package tp04;

import java.time.LocalDate;

public class ToDoList {
	private Task[] chores ;
	
	public ToDoList() {
		this.chores = new Task[5];
	}
	
	public void enLarge() {
		Task[] tabSave = this.chores.clone();
		this.chores = new  Task[this.chores.length+5];
		for(int i =0 ;i<tabSave.length ; i++) {
			this.chores[i] = tabSave[i];
		}
	}
	public String toString() {
		String str = null;
		for(int i =0 ; i<chores.length; i++) {
			str = str + chores[i].toString();
		}
		return str;
	}
	
	private int LibreCase(){
		int i =0;
		while(i<this.chores.length && this.chores[i]!=null) {
			i++;
		}
		return i;
	}
	public void addTask(Task aTask) {
		int liber = this.LibreCase();
		this.chores[liber] = aTask ;
	}
	private int TaskPos(Task aTask) {
		int i = 0;
		while(this.chores.length > i && ! this.chores[i].equals(aTask)) {
			i++;
		}
		return i;
	}
	public void removeTask(Task aTask) {
		int liber = this.TaskPos(aTask);
		this.chores[liber] = null;
	}
	
	public void removeTask(int i) {
		if(i < this.chores.length)this.chores[i]=null;
	}
	
	public boolean isOverwhelmed() {
		if(this.LibreCase()!=this.chores.length-1 && this.chores[this.LibreCase()]!=null) return true;
		return true;
	}
	
	public int getNbStack() {
		if(! this.isOverwhelmed()) return this.LibreCase();
		return this.chores.length-1;
	}
	
	public void onSickLeave(int nbDays) {
		for(int i = 0; i<this.LibreCase(); i++) {
			this.chores[i].delay(nbDays);
		}
	}
	
	public Task[] dueTask() {
		int cpt = 0;
		for(int i = 0 ; i<this.LibreCase(); i++) {
			if(this.chores[i].getDeadkube().equals(LocalDate.now())) cpt++ ;
		}
		Task[] tabreturn = new Task[cpt];
		for(int i = 0 ; i<this.LibreCase(); i++) {
			if(this.chores[i].getDeadkube().equals(LocalDate.now())) tabreturn[i]=this.chores[i] ;
		}
		
		return tabreturn ; 
	}
	
	public void emergencySort() {
		
	}
	
	public void durationSort() {
		
	}
	
	public void senioritySort() {
		
	}
}
