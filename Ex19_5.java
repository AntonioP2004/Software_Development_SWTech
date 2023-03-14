package Exercises19_3_5_9;

public class Ex19_5 {
	static Integer[] numbers = {1, 2, 3};
	static String[] words = {"red", "green", "blue"};
	static Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
	
  public static void main(String[] args) {
    System.out.println(max1(numbers));
    System.out.println(max2(words));
    System.out.println(max3(circles));
  }
  
  public static <E extends Comparable<E>> E max1(E[] numbers) {
	  	if (numbers[0].compareTo(numbers[1]) > 0)
	  		return (E) numbers[0];
	  	else if (numbers[1].compareTo(numbers[2]) > 0)
	  		return (E) numbers[1];
  		else 
  			return (E) numbers[2];
  }
  
  public static <E extends Comparable<E>> E max2(E[] words) {
	  if (words[0].compareTo(words[1]) > 0)
	  		return (E) words[0];
	  	else if (words[1].compareTo(words[2]) > 0)
	  		return (E) words[1];
		else 
			return (E) words[2];
  }
  
  public static <E extends Comparable<E>> E max3(E[] circles) {
	  if (circles[0].compareTo(circles[1]) > 0)
	  		return (E) circles[0];
	  	else if (circles[1].compareTo(circles[2]) > 0)
	  		return (E) circles[1];
		else 
			return (E) circles[2];
  }
  
  static class Circle implements Comparable<Circle> {
    double radius;
    
    public Circle(double radius) {
      this.radius = radius;
    }
    
    @Override
    public int compareTo(Circle c) {
      if (radius < c.radius) 
        return -1;
      else if (radius == c.radius)
        return 0;
      else
        return 1;
    }
    
    @Override
    public String toString() {
      return "Circle radius: " + radius;
    }
  }
}
