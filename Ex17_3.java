package Exercises17_1_3_7_14X15;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex17_3 {
	public static void main(String[] args) throws IOException {
		try (
			RandomAccessFile inout = new RandomAccessFile("Exercise17_3.dat", "rw");
		) {
		inout.setLength(0);
		
		for (int i = 0; i < 25; i++) {
			int n = (int) (Math.random() * i);
			inout.writeInt(n);
		}
		
		System.out.println("Current file length is " + inout.length());
		Data();
		}
	}
	
	public static int Data() throws IOException {
		try (
				RandomAccessFile inout = new RandomAccessFile("Exercise17_3.dat", "rw");
			) {
			for (int i = 0; i < 100; i++) {
				inout.seek(i);
				try {
					System.out.println("numer " + i + ": " + inout.readInt());
				} catch (EOFException ex) {
					System.out.print("End of file!");
				}
			}
		}
		return 0;
	}
}