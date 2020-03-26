package tp07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import tp04.Task;
import util.BarChart;

public class UseJFreeChart {
	private static Random rnd = new Random();
	private double[] tabl ;
	
	UseJFreeChart(){
		this.tabl = new double[100];
		for(int i = 0 ; i < this.tabl.length ; i++) {
			this.tabl[i] = rnd.nextDouble();
		}
	}
	
	public static void main(String[] args)  {
		UseJFreeChart test = new UseJFreeChart();
		BarChart his = new BarChart("Frequence", "Nombre", "nbOcurrence", test.tabl, 10);
		barChartTask();
	}
	
	public static ArrayList<Task> generateTasks(){
		ArrayList<Task> myTask = new ArrayList<Task>();
		System.out.println(LocalDate.now().getMonthValue());
		for(int i = LocalDate.now().getMonthValue() ; i<13 ; i++ ) {
			System.out.println(i + "voixi i");
			for(int j = 0 ; j<rnd.nextInt(5); j++) {
				
				Task el = new Task("Task"+i+j, LocalDate.now(), LocalDate.of(2020, i, 1), rnd.nextInt(10)+1);
				
				myTask.add(el);
			}
		}
		
		return myTask;
	}
	
	public static void barChartTask() {
		ArrayList<Task> pa = generateTasks();
		double[] pa2 = new double[12];
		for(int i = 0; i< pa.size() ; i++) {
			pa2[(int)pa.get(i).getDeadkube().getMonthValue()-1] += 1;
			System.out.println(i);
			System.out.println((int) pa.get(i).getDeadkube().getMonthValue()+"theget");
			System.out.println(pa2[(int)pa.get(i).getDeadkube().getMonthValue()-1]+"theValue");
		}
		BarChart ho = new BarChart("Tache", "Months", "nbOccurences", pa2, 12); 
	}
}
