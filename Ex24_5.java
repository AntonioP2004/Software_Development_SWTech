package Exercises24_1_3_5;

import java.util.LinkedList;

public class Ex24_5<E> {
	 @SuppressWarnings("rawtypes")
	public static LinkedList list  = new LinkedList();
	  
	  public static void main(String[] args) {
		  
		  System.out.println("List before enqueue: " + list);
		  System.out.print("List after enqueue: ");
		  enqueue(list);
		  System.out.println(list);
		  
		  System.out.println(" ");
		  
		  System.out.println("List before dequeue: " + list);
		  System.out.print("List after dequeue: ");
		  dequeue(list);
		  System.out.println(list);
	  }
	  
	    @SuppressWarnings("unchecked")
		public static void enqueue(@SuppressWarnings("rawtypes") LinkedList list) {
	      list.addLast(list);
	    }
	  
	    public static Object dequeue(@SuppressWarnings("rawtypes") LinkedList list) {
	      return list.removeFirst();
	    }
	  
	    public int getSize() {
	      return list.size();
	    }
	  
	    @Override
	    public String toString() {
	      return "Queue: " + list.toString();
	    }
  }