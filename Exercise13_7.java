package Ex13_1_7_11;

import java.util.Scanner;

public class Exercise13_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int i = 1;
		
		String[] GeoObject = new String[6];
		GeoObject[1] = "";
		GeoObject[2] = "";
		GeoObject[3] = "";
		GeoObject[4] = "";
		GeoObject[5] = "";
		
		while (i < 5) {
		
			System.out.println("please enter the sides and then the color of the triangles sides.");
			System.out.print("Please enter Side1: ");
			double side1 = input.nextDouble();
			String color1 = input.next();
			System.out.print("Please enter Side2: ");
			double side2 = input.nextDouble();
			String color2 = input.next();
			System.out.print("Please enter Side3: ");
			double side3 = input.nextDouble();
			String color3 = input.next();
			System.out.println("is this Triangle filled? true or false?");
			String full = input.next();
			
			Triangle.setSide1(side1);
			Triangle.setSide2(side2);
			Triangle.setSide3(side3);
			Colorable.howToColor.setColor1(color1);
			Colorable.howToColor.setColor2(color2);
			Colorable.howToColor.setColor3(color3);
			GeometricObj.setFull(full);
			
			System.out.println("Triangle: " + Triangle.toStringT());
			System.out.println("the Area of the triangle is: " + GeometricObj.getArea());
			System.out.println("the Perimeter of the triangle is: " + GeometricObj.getPerimeter());
			System.out.println(GeometricObj.toStringG());
			
			GeoObject[i] = GeometricObj.toStringG();
			i++; 
		}
		System.out.println(" ");
		System.out.println("Now you can enter 1 - 5 to view them.");
		while (0 < 1) {
			i = input.nextInt();
			System.out.println(GeoObject[i]);
		}
	}	
}
	
// this is the abstract GeometricObject class same as in the book.
abstract class GeometricObj {
		private static String Full;
		
		GeometricObj() {
		}

		protected GeometricObj(String Color, String Full) {
			GeometricObj.Full = Full;
		}
		
		public static void setFull(String full) {
			GeometricObj.Full = full;
		}

		public static String Full() {
			return Full;
		}
		
// the methods that are new/changed for the assignment
		public static String toStringG() {
			return "colors are: side1: "  + getColor1() + " side2: "+ getColor2() + " side3: " + getColor3() + " and filled: " + Full();
		}
		
		public static double getArea() {
			double s = (Triangle.Side1 + Triangle.Side2 + Triangle.Side3) / 2;
			return Math.sqrt((s * (s - Triangle.Side1)) + (s * (s - Triangle.Side2)) + (s * (s - Triangle.Side3)));
		}

		public static double getPerimeter() {
			return Triangle.Side1 + Triangle.Side2 + Triangle.Side3;
		}
		public static String getColor1() {
			return Colorable.Color1;
		}
		public static String getColor2() {
			return Colorable.Color2;
		}
		public static String getColor3() {
			return Colorable.Color3;
		}
	}

//this is the Triangle class that extends from the GeometricObjects class.
class Triangle extends GeometricObj {
	static double Side1 = 0;
	static double Side2 = 0;
	static double Side3 = 0;
	
	public static String toStringT() {
		return "Side1 = " + Side1 + " | Side2 = " + Side2 + " | Side3 = " + Side3;
	}
	public static void setSide1(double side1) {
		Triangle.Side1 = side1;
	}
	public static void setSide2(double side2) {
		Triangle.Side2 = side2;
	}
	public static void setSide3(double side3) {
		Triangle.Side3 = side3;
	}
}

// This class extends the Triangle class to color the sides in by default they will be "white".
class Colorable extends Triangle {
	static String Color1 = null;
	static String Color2 = null; 
	static String Color3 = null; 
		
	public interface howToColor {	
		public static void setColor1(String color1) {  
			Colorable.Color1 = color1; 
		}
		public static void setColor2(String color2) { 
			Colorable.Color2 = color2; 
		}	
		public static void setColor3(String color3) { 
			Colorable.Color3 = color3; 
		}
	}
}