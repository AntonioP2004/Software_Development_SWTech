package Ex13_1_7_11;

import java.util.Scanner;

public class Exercise13_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
			
			System.out.print("Please enter Side1: ");
			double side1 = input.nextDouble();
			System.out.print("Please enter Side2: ");
			double side2 = input.nextDouble();
			System.out.print("Please enter Side3: ");
			double side3 = input.nextDouble();
			System.out.println("what color is the Triangle?");
			String color = input.next();
			System.out.println("is this Triangle filled? true or false?");
			String full = input.next();
			
			Triangle.setSide1(side1);
			Triangle.setSide2(side2);
			Triangle.setSide3(side3);
			GeometricObject.setColor(color);
			GeometricObject.setFull(full);
			
			System.out.println("Triangle: " + Triangle.toStringT());
			System.out.println("the Area of the triangle is: " + GeometricObject.getArea());
			System.out.println("the Perimeter of the triangle is: " + GeometricObject.getPerimeter());
			System.out.println(GeometricObject.toStringG());
		}
	}
	
// this is the abstract GeometricObject class same as in the book.
	abstract class GeometricObject {
		private static String Color = "White";
		private static String Full;
		
		protected GeometricObject() {
		}

		protected GeometricObject(String Color, String Full) {
			GeometricObject.Color = Color;
			GeometricObject.Full = Full;
		}
		
		public static void setColor(String color) {
			GeometricObject.Color = color;
		}
		
		public static String Color() {
			return Color;
		}
		
		public static void setFull(String full) {
			GeometricObject.Full = full;
		}

		public static String Full() {
			return Full;
		}
		
		
		public static String toStringG() {
			return "color: " + Color() + " and filled: " + Full();
		}
		
		public static double getArea() {
			double s = (Triangle.Side1 + Triangle.Side2 + Triangle.Side3) / 2;
			return Math.sqrt((s * (s - Triangle.Side1)) + (s * (s - Triangle.Side2)) + (s * (s - Triangle.Side3)));
		}

		public static double getPerimeter() {
			return Triangle.Side1 + Triangle.Side2 + Triangle.Side3;
		}
	}

// this is the Triangle class that extends from the GeometricObjects class.
	class Triangle extends GeometricObject {
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