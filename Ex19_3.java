package Exercises19_3_5_9;

import java.util.ArrayList;

public class Ex19_3 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  
  @SuppressWarnings("unchecked")
public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
	  ArrayList<Integer> newList = new ArrayList<Integer>();

	  boolean dupe;
	  for (int i = 0; i < list.size(); i++) {
		  dupe = false;
		  for (int j = i + 1; j < list.size(); j++) {
			  if (list.get(i) == list.get(j)) {
				  System.out.println("Found duplicates at " + i + " " + j);
				  dupe = true;
				  break;
			  }
		  }
		  if (dupe == false) {
			  newList.add((Integer) list.get(i));
		  }
	  }
	return (ArrayList<E>) newList;
  }
}