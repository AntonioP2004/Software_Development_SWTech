package Exercises22_1_3;

import java.util.*;

// abcabcdgabxy
// defghijkabczadfghi

public class Ex22_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String s = input.nextLine();
		
		String Max = "";
		String Cur = "";
		Cur += s.charAt(0);
		for (int j = 1; j < s.length(); j++) {
			if (s.charAt(j - 1) < s.charAt(j)) {
				Cur += s.charAt(j);
			} else if (Cur.length() > Max.length()){
				System.out.println(j);
				Max = Cur;
				Cur = "" + s.charAt(j);
			} else {
				Cur = "" + s.charAt(j);
			}
		}
		System.out.print(Max);
	}
}