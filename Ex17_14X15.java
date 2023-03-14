package Exercises17_1_3_7_14X15;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ex17_14X15 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Please save/rename \"Output.dat\" it will be cleared and all data will be lost.");
		System.out.println("1) Encrypt a file");
		System.out.println("2) Decrypt a file");
		int ED = input.nextInt();
		
		if (ED == 1) Encrypt();
		else if (ED == 2) Decrypt();
	}
	public static void Encrypt() throws IOException {
		new PrintWriter(new FileOutputStream("Output.dat", true));
		Scanner input = new Scanner(System.in);
		
		System.out.print("please enter a File you would like Encrypted: ");
		String File = input.nextLine();
		try {
			RandomAccessFile inout = new RandomAccessFile(File, "rw");
			RandomAccessFile save = new RandomAccessFile("Output.dat", "rw");
			
			for (int i = 0; i < inout.length(); i++) {
				byte j = inout.readByte();
				inout.write(j + 5);
				inout.read();
				save.write(j);
				System.out.print(j + " ");
			}
		} catch (EOFException ex) {
			System.out.println(" ");
			System.out.println("End of File!");
		}
	}
	public static void Decrypt() throws IOException {
		new PrintWriter(new FileOutputStream("Output.dat", true));
		Scanner input = new Scanner(System.in);
		
		System.out.print("please enter a File you would like Unencrypted: ");
		String File = input.nextLine();
		try {
			RandomAccessFile inout = new RandomAccessFile(File, "rw");
			RandomAccessFile save = new RandomAccessFile("Output.dat", "rw");
			
			for (int i = 0; i < inout.length(); i++) {
				byte j = inout.readByte();
				inout.write(j - 5);
				inout.read();
				save.write(j);
				System.out.print(j + " ");
			}
		} catch (EOFException ex) {
			System.out.println(" ");
			System.out.println("End of File!");
		}
	}
}