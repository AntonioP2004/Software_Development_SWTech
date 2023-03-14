package Exercises18_3_9_19;

import java.util.Scanner;

public class Ex18_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("please enter an integer: ");
		int I1 = input.nextInt();
		
		System.out.println("please enter another integer: ");
		int I2 = input.nextInt();
		
		System.out.print("the greatest common divisor of " + I1 + " and " + I2 + " is " + GCD(I1, I2));
	}
	public static int GCD(int I1, int I2) {
		if (I1 % I2 == 0)
			return I2;
		else
			return I2 * factorial(I1 % I2);
		
	}
	private static int factorial(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}