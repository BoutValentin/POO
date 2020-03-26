package tp08;

import java.util.*;

public class UseLine {

	public static void main(String[] args) {
				test_itThreshold();
		
	}
	
	public static void test_iterable() {
		Collection<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i<=55 ; i++) {
			if(i%2==1) list.add((Integer)i);
		}
		Line myLine = new Line(list);
		for(Integer i : myLine.getValues()) {
			System.out.println(i);
		}
		System.out.println(myLine.toString());
	}
	public static void test_iterable_explicit() {
		Collection<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i<=55 ; i++) {
			if(i%2==1) list.add((Integer)i);
		}
		Line myLine = new Line(list);
		Iterator<Integer> it = myLine.getValues().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public static void test_itBackward() {
		Collection<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i<=55 ; i++) {
			if(i%2==1) list.add((Integer)i);
		}
		Line myLine = new Line(list);
		Iterator<Integer> it = new LineItBackward(myLine.getValues());
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public static void test_itThreshold() {
		Collection<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i<=55 ; i++) {
			if(i%2==1) list.add((Integer)i);
		}
		Line myLine = new Line(list);
		Iterator<Integer> it = new LineItThreshold(myLine.getValues(), 50);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
