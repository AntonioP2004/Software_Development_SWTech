package Ex13_1_7_11;

import java.util.Scanner;

public class Exercise13_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("please enter the length of all 8 sides on an octagon: ");
		double sides = input.nextDouble();
		Octagon.setSides(sides);
		System.out.print("and the color? ");
		String color = input.next();
		Octagon.setColor(color);
		System.out.print("is the Octagon full? ");
		String full = input.next();
		GeoObj.setFull(full);
		System.out.println("Created.");
		System.out.println("Perimeter: " + Octagon.getParimeter() + " Area: " + Octagon.getArea() + " Color: " + Octagon.getColor() + GeoObj.toStringA());
		System.out.print("Clone created: " + Octagon.compareToA(null));
	}
}
// this is the Geometric Object class.
class GeoObj {
	static String Full;
	
	static String isFull() {
		return Full;
	}
	
	static String setFull(String full) {
		return Full = full;
	}
	
	public static String toStringA() {
		return " Full: " + isFull();
	}
}
 // this is the extending Octagon class.
abstract class Octagon extends GeoObj implements Cloneable, Comparable<Octagon> {
	static double Sides;
	static String Color;
	
	public Octagon() {
		getColor();
		getArea();
		getParimeter();
	}
	
	static String getColor() {
		return Color;
	}
	
	static double getArea() {
		return (2 + (4 / Math.sqrt(2)) * Sides * Sides);
	}
	
	static double getParimeter() {
		return Sides * 8;
	}
	
	public static String setColor(String color) {
		return Color = color;
	}
	public static double setSides(double sides) {
		return Sides = sides;
	}
// the clone and compare methods the assignment asked for.
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	 
	public static String compareToA(Octagon o) {
		if (getArea() > o.getArea()) {
			return "Not equal";
		} else if (getArea() < o.getArea()) {
			return "Not equal";
		} else 
			return "Equal";
	}
}