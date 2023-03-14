/*
 * fixed the inputs from intager values to double values.
 */
package Ex11_1_3;

import java.util.Scanner;
import javax.xml.crypto.Data;
import java.util.Date;

public class Exercise11_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter Side1: ");
		double side1 = input.nextDouble();
		System.out.print("Please enter Side2: ");
		double side2 = input.nextDouble();
		System.out.print("Please enter Side3: ");
		double side3 = input.nextDouble();
		
		GeometricObject.TriangleFromGeometricObject.setSide1(side1);
		GeometricObject.TriangleFromGeometricObject.setSide2(side2);
		GeometricObject.TriangleFromGeometricObject.setSide3(side3);
		
		System.out.println("Triangle: " + GeometricObject.TriangleFromGeometricObject.toStringT());
		System.out.println("the Area of the triangle is: " + GeometricObject.TriangleFromGeometricObject.getArea());
		System.out.println("the Perimeter of the triangle is: " + GeometricObject.TriangleFromGeometricObject.getPerimeter());
		
	}
	
	
// this is the GeometricObject class same as in the book.
	public class GeometricObject {
		private String color = "White";
		private boolean filled;
		private java.util.Date dateCreated;
		
		public GeometricObject() {
			dateCreated = new java.util.Date();
		}
		
		public GeometricObject(String color, boolean filled) {
			dateCreated = new java.util.Date();
			this.color = color;
			this.filled = filled;
		}
		
		public String getColor() {
			return color;
		}
		
		public void setColor(String color) {
			this.color = color;
		}
		
		public boolean isFilled() {
			return filled;
		}
		
		public void setFilled(boolean filled) {
			this.filled = filled;
		}
		public java.util.Date getDateCreated() {
			return dateCreated;
		}
		
		public String toStringG() {
			return "Created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
		}
		
// this is the Triangle class that extends from the GeometricObjects class.
	public class TriangleFromGeometricObject
			extends GeometricObject {
		static double Side1 = 0;
		static double Side2 = 0;
		static double Side3 = 0;
		
		public static double getArea() {
			double s = (Side1 + Side2 + Side3) / 2;
			return Math.sqrt((s * (s - Side1)) + (s * (s - Side2)) + (s * (s - Side3)));
		}

		public static double getPerimeter() {
			return Side1 + Side2 + Side3;
		}
		
		public static String toStringT() {
			return "Side1 = " + Side1 + " | Side2 = " + Side2 + " | Side3 = " + Side3;
		}
		public static void setSide1(double side1) {
			TriangleFromGeometricObject.Side1 = side1;
		}
		public static void setSide2(double side2) {
			TriangleFromGeometricObject.Side2 = side2;
		}
		public static void setSide3(double side3) {
			TriangleFromGeometricObject.Side3 = side3;
		}
		}
	}
}