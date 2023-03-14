package Ex10_3_7;

import java.util.Scanner;

public class Exercise10_3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("please select 1 or 2 to test.");
		System.out.println("1) numbers.");
		System.out.println("2) characters.");
		double c = input.nextDouble();
		
		while (1 > 0) {
			if (c == 1) {
				System.out.print("Please enter: ");
				int value = input.nextInt();
		
				myInteger.setvalue(value);
		
				myInteger myInteger1 = new myInteger();
					System.out.println(myInteger.getvalue2);
					myInteger1.isEven();
					myInteger1.isOdd();
					myInteger1.isPrime();
					System.out.println(" ");
			}
			if (c == 2) {
				System.out.print("Please enter: ");
				String letters = input.nextLine();
				
				myInteger.setLetters(letters);
				
				myInteger myInteger1 = new myInteger();
				System.out.println(myInteger.parceInt(null));
				myInteger1.isEven();
				myInteger1.isOdd();
				myInteger1.isPrime();
				System.out.println(" ");
			}
		}
	}
}

class myInteger {
	static int getvalue2;
	static int dev1;
	
	static String result1;
	static String result2;
	static String result3;
	myInteger() {
		if (parceInt(null) == 0) {
			dev1 = parseInt();
		} else {
			dev1 = parceInt(null);
		}
	}
// non-static methods.
	void isEven() {
		System.out.println("Even: " + isEven(dev1));
	}
	void isOdd() {
		System.out.println("Odd: " + isOdd(dev1));
	}
	void isPrime() {
		System.out.println("Prime: " + isPrime(dev1));
	}
// static int methods these also double as the MyInteger methods since i am setting dev1 to either a char input or String of numbers.
	public boolean isEven(int dev12) {

		if  (dev1 % 2 == 0) {
			return true;
		}
		return false;
	}
	public boolean isOdd(int dev12) {
		
		if (dev1 % 2 != 0) {
			return true;
		}
		return false;
	}
	public boolean isPrime(int dev12) {
		
		if (dev1 == 2 || dev1 == 3) {
			return true;
		}
		if (dev1 <= 1 || dev1 % 2 == 0 || dev1 % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= dev1; i += 6) {
			if (dev1 % i == 0 || dev1 % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
// parceInt(String) method. did not use String in method because it was having problems with the char[] when trying to assign to dev1
	public static int parseInt() {
		int total = 0;
		if (getvalue2 != ' ') {
			total = total + getvalue2;
		}
		return total;
	}
	
	static String getvalueS;
// parceInt(char[]) method.
	public static int parceInt(char[] Letters) {
		int y = 0;
		int b = 0;
		if (getvalueS != null) {
			while (y < getvalueS.length()) {
			
				b = b + getvalueS.charAt(y);
			
				y++;
			}
		}
		return b;
	}
// these methods assign getvalue2 or getvalueS there values from the main method
	public static void setLetters(String Letters) {
		myInteger.getvalueS = Letters;
	}
	public static void setvalue(int value) {
		myInteger.getvalue2 = value;
	}
}