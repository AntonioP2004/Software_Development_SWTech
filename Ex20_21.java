package Exercises20_3_9_21;

import java.util.Comparator;

public class Ex20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    selectionSort(list, new GeometricObjectComparator());
    
    for (int i = 0; i < list.length; i++)
    	System.out.println(list[i].getArea() + " ");
    System.out.println(" ");
    selectionSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++)
        System.out.println(list1[i].getArea() + " ");
  }
  
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
	  E temp;
	  for (int j = 0; j < list.length; j++)
		  for (int i = 0; i < list.length; i++)
				  if (comparator.compare(list[i], list[j]) > 0) {
					  temp = list[i];
					  list[i] = list[j]; 
					  list[j] = temp;
				  }
  }
}