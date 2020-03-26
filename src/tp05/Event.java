package tp05;

import java.time.LocalDate;

import tp04.Task;
import tp04.ToDoList;

public class Event {
	private String label;
	private String place;
	private LocalDate start;
	private LocalDate end;
	private ToDoList task;
	
	public Event(String label, String place, LocalDate start, LocalDate end, ToDoList tasks) {
		//Verif date fin apres debut
		//list tache defau vide
		//date fin event un jour apres celui debut
		//date debut aujoud'hui par defaut
		this.label = label;
		this.place = place;
		if(start.isAfter(end)) {
			this.start = null;
			this.end = null;
		}
		this.start = start;
		this.end = end;
		this.task = tasks;
	}
	
	public Event(String label, String place, LocalDate start, LocalDate end) {
		this(label, place, start, end, new ToDoList());
	}
	public Event(String label, String place, LocalDate start) {
		this(label, place, start, start.plusDays(1));
	}
	public Event(String label, String place) {
		this(label, place, LocalDate.now());
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public ToDoList getTask() {
		return task;
	}

	public void setTask(ToDoList task) {
		this.task = task;
	}
	
	public String toString() {
		return this.label + " "+ this.place +" start:"+this.start.toString()+" end:"+this.end.toString()+" task:"+this.task.toString();
	}

	public void addTask(Task aTask) {
		task.addTask(aTask);
	}

	public void removeTask(Task aTask) {
		task.removeTask(aTask);
	}

	public void removeTask(int i) {
		task.removeTask(i);
	}

	public int getNbStack() {
		return task.getNbStack();
	}

	public Task[] dueTask() {
		return task.dueTask();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}
	 
	public boolean overlap(Event evt) {
		/*if(this.start.isEqual(evt.start) && this.end.isEqual(evt.start)) return true;
		if(this.start.isAfter(evt.start) && this.end.isAfter(evt.end) && this.start.isBefore(evt.end)) return true ;
		if(this.start.isBefore(evt.start) && this.end.isBefore(evt.end) && this)*/
		if(this.end.isBefore(evt.start)) return false;
		if(evt.end.isBefore(this.start)) return false;
		return true;
	}
	
	
}
