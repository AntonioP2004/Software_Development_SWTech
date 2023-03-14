package Ex12_3_15;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise12_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Object[] raNum = new Object[100];
		try {
			for (int x = 0; raNum.length > x; x++) {
				Object n = (int)(Math.random() * 15);
				raNum[x] = n;
			}
			
			System.out.println("please enter the index of the following array.");
			System.out.println(Arrays.toString(raNum));
			System.out.print("answer (do not enter bellow 0): ");
			int a = input.nextInt();
			System.out.println(raNum[a]);
			
			} catch (ArrayIndexOutOfBoundsException Ex) {
				System.out.println("Out of Bounds.");
			}
	}
}