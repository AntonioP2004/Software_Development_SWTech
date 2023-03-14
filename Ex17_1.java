package Exercises17_1_3_7_14X15;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex17_1 {
	public static void main(String[] args) throws IOException {
		try (
			RandomAccessFile inout = new RandomAccessFile("Exercise17_1.txt", "rw");
		) {
		inout.setLength(0);
		
		for (int i = 0; i < 25; i++) {
			int n = (int) (Math.random() * i);
			inout.writeInt(n);
		}
		
		System.out.println("Current file length is " + inout.length());
		}
	}
}