package Exercises22_1_3;

import java.util.*;

public class Ex22_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter string 1: ");
		String s1 = input.nextLine();
		System.out.print("Please enter string 2: ");
		String s2 = input.nextLine();

		int index = 0;
		int firstIndex = 0;
		boolean readingSubString = false;
		int i = 0;
		
		for (int j = 0; j < s1.length(); j++) {
			if (s1.charAt(j) == s2.charAt(i)) {
				readingSubString = false;
			}
			if (readingSubString == false) {
				if (index != 0) {
					firstIndex = index - 1;
				}
				index = j;
				readingSubString = true;
			} 
			if (i != s2.length()) {
				i = 0;
			}
			i++;
		}
		System.out.print("Matched at index " + firstIndex);
	}
}
