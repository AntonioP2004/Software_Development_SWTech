package Exercises18_3_9_19;

import java.util.Scanner;

public class Ex18_9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a String: ");
		String value = input.nextLine();
		
		display(value);
	}
	public static void display(String value) {
		if (value.length() <= 1)
			System.out.print(value);
		else if (value.length() != 1) {
			StringBuilder reverse = new StringBuilder();
			reverse.append(value);
			reverse.reverse();
			System.out.print(reverse.toString());
		}
	}
}