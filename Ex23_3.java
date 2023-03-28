package Exercises23_3_7;

import java.util.Comparator;

public class Ex23_3 {
  public static void main(String[] args) {
    int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    for (int i = 0; i < list.length; i++)
    	for (int j = 0; j < list.length; j++)
    		quickSort(list, i, j);
    
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
   
    for (int i = 0; i < list1.length; i++)
    	for (int j = 0; j < list1.length; j++) 
    		quickSortN(list1, new GeometricObjectComparator(), i, j);
    		
    for (int i = 0; i < list1.length; i++)
    	System.out.println(list1[i] + " ");
  }

public static <E extends GeometricObject> void quickSortN(E[] list1, Comparator<? super E> comparator, int first, int last) {
	  if (last > first) {
          int pivotIndex = partitionN(list1, new GeometricObjectComparator(), first, last);
          quickSortN(list1, comparator, first, pivotIndex - 1);
         quickSortN(list1, comparator, pivotIndex + 1, last);
       }
  } 
  
  public static <E extends GeometricObject> int partitionN(E[] list1, GeometricObjectComparator geometricObjectComparator, int first, int last) {
      E pivot = list1[first]; // Choose the first element as the pivot
      int low = first + 1; // Index for forward search
      int high = last; // Index for backward search
  
      while (high > low) {
        // Search forward from left
        while (low <= high && geometricObjectComparator.compare(list1[low], pivot) <= 0)
          low++;
  
        // Search backward from right
        while (low <= high && geometricObjectComparator.compare(list1[high], pivot) > 0)
          high--;
  
        // Swap two elements in the list
        if (high > low) {
          E temp = list1[high]; 
          list1[high] = list1[low];
          list1[low] = temp;
        }
      }
      
      while (high > first && geometricObjectComparator.compare(list1[high], pivot) >= 0)
        high--;
  
      // Swap pivot with list[high]
      if (geometricObjectComparator.compare(pivot, list1[high]) > 0) {
        list1[first] = list1[high];
        list1[high] = pivot; 
        return high;
      }
      else {
        return first;
      }
    }

	public static void quickSort(int[] list, int first, int last) {
		  if (last > first) {
	         int pivotIndex = partition(list, first, last);
	         quickSort(list, first, pivotIndex - 1);
	         quickSort(list, pivotIndex + 1, last);
		  }
	 }
	   
	     /** Partition the array list[first..last] */
	     public static int partition(int[] list, int first, int last) {
	       int pivot = list[first]; // Choose the first element as the pivot
	       int low = first + 1; // Index for forward search
	       int high = last; // Index for backward search
	   
	       while (high > low) {
	         // Search forward from left
	         while (low <= high && list[low] <= pivot) 
	           low++;
	   
	         // Search backward from right
	         while (low <= high && list[high] > pivot) 
	           high--;
	   
	         // Swap two elements in the list
	         if (high > low) {
	           int temp = list[high]; 
	           list[high] = list[low];
	           list[low] = temp;
	         }
	       }
	   
	       while (high > first && list[high] >= pivot)
	         high--;
	   
	       // Swap pivot with list[high]
	       if (pivot > list[high]) {
	         list[first] = list[high];
	         list[high] = pivot; 
	         return high;
	       }
	       else {
	         return first;
	       }
	     }
}