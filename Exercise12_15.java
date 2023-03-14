package Ex12_3_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise12_15 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		java.io.File File = new java.io.File("Exercise12_15.txt");
		if (File.exists()) {
			System.out.println("File already exists.");
			System.exit(0);
		} else {
			System.out.println("File created.");
		}
			
		Object[] raNum = new Object[100];
		for (int x = 0; raNum.length > x; x++) {
			Object n = (int)(Math.random() * 15);
			raNum[x] = n;
		}
		
		try (java.io.PrintWriter output = new java.io.PrintWriter("Exercise12_15.txt")) {
			output.print(Arrays.toString(raNum));
		}
		
		Scanner FileS = new Scanner(new File("Exercise12_15.txt"));
		System.out.println(FileS.nextLine());
		
	}
} 