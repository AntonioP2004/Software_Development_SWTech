package Exercises19_3_5_9;

import java.util.ArrayList;

public class Ex19_9 {
	static ArrayList<Integer> list = new ArrayList<Integer>();
  public static void main(String[] args) {
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Ex19_9.<Integer>sort(list);
  }
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
	  
	  boolean small = false;
	  for (int i = 0; i < list.size(); i++) {
		  small = false;
		  for (int j = 0; j < list.size(); j++) {
			  if (list.get(i).compareTo(list.get(j)) >= j)
				  small = true;
			  else
				  break;
		  }
		  if (small == false)
			  System.out.print(list.get(i) + " ");
	  }
	  
	  boolean big = false;
	  for (int i = 0; i < list.size(); i++) {
		  big = false;
		  for (int j = 0; j < list.size(); j++) {
			  if (list.get(i).compareTo(list.get(j)) < j)
				  big = true;
			  else
				  break;
		  }
		  if (big == false)
			  System.out.print(list.get(i) + " ");
	  }
  }
}