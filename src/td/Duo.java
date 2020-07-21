package td;

import java.util.ArrayList;
import java.util.List;

public class Duo<E> {
	
	private E anElement;
	private E aSecondElement;
	
	public Duo(E enElemetn, E second){
		this.anElement = enElemetn;
		this.aSecondElement=second;
	}
	public Duo(E elemen) {
		this.anElement = elemen;
		this.aSecondElement = elemen;
	}
	public E getFirst() {
		return this.anElement;
	}
	public E getSecond() {
		return this.aSecondElement;
	}
	
	public void setFirst(E fi) {
		this.anElement=fi;
	}
	public void setSecond(E sd) {
		this.aSecondElement=sd;
	}
	public String toString() {
		return ""+anElement.toString() + aSecondElement.toString();
	}
	public void swap() {
		E tmp = this.anElement;
		this.anElement = this.aSecondElement;
		this.aSecondElement = tmp;
	}
	public boolean identialElements() {
		return anElement.equals(aSecondElement);
	}
	public boolean orderedEquals(Duo<E> other) {
		if(other.getFirst().equals(this.getFirst()) && other.getSecond().equals(this.getSecond())) return true;
		return false;
	}
	public boolean nonOrderedEquals(Duo<E> other) {
		if(orderedEquals(other)) return true;
		if(other.getFirst().equals(this.getSecond()) && other.getSecond().equals(this.getFirst())) return true;
		return false;
	}
	public static <E> void mixDuos(Duo<E> dos1,Duo<E> dos2) {
		E tmp = dos1.getFirst();
		dos1.setFirst(dos2.getSecond());
		dos2.setSecond(tmp);
	}
	public static<T> List<Duo<T>> randomDuos(List<T> elements){
		List<Duo<T>> theReturn = new ArrayList<>();
		for(int i=0 ; i<elements.size();i+=2) {
			if(i<elements.size()-1) {
				Duo<T> aDuo = new Duo<T>(elements.get(i),elements.get(i+1));
				theReturn.add(aDuo);
			}
		}
		if(elements.size()%2==1) {
			Duo<T> aDuo = new Duo<T>(elements.get(elements.size()-1));
			theReturn.add(aDuo);
		}
		return theReturn;
	}
	
	public static void main(String[] args) {
		Duo<String> duoStr = new Duo<String>("bruno","alice");
		Duo<String> duoStr2 = new Duo<String>("bruno","alice");
		if(duoStr.orderedEquals(duoStr2)) System.out.println(" ordere st1 str2 ");
		else System.out.println("not Equals ordere st1 str2");
		System.out.println(duoStr);
		duoStr.swap();
		System.out.println(duoStr);
		if(duoStr.orderedEquals(duoStr2)) System.out.println(" ordere st1 str2 ");
		else System.out.println("not Equals ordere st1 str2");
		Duo<Boolean> duoBool = new Duo<Boolean>(false,true);
		System.out.println(duoBool);
		duoBool.swap();
		System.out.println(duoBool);
		Duo<Integer> duo1 = new Duo<>(4,3);
		Duo<Integer> duo2 = new Duo<>(2,1);
		System.out.println("Before: " + duo1 + "\t" + duo2);
		mixDuos(duo1, duo2);
		System.out.println("After: " + duo1 + "\t" + duo2);
		String s1 = "toto";String s2="tata";String s3="albert";String s4="philou";String s5="BErnard";String s6="Bog";
		List<String> aList = new ArrayList<>();
		aList.add(s1);aList.add(s2);aList.add(s3);aList.add(s4);aList.add(s5);aList.add(s6);
		List<Duo<String>> secondList = Duo.randomDuos(aList);
		System.out.println(secondList);
	}
	
}
