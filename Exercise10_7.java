package Ex10_3_7;

import java.util.Scanner;

public class Exercise10_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(0 < 1) {
			int ID = 0;
			if (ID == 0) {
				System.out.print("please enter ID: ");
				ID = input.nextInt();
			}
			account account1 = new account();
		
			account1.setID(ID);
			
			System.out.print("Account details:"); System.out.println(ID);
		 	System.out.println("1) withdraw");
		 	System.out.println("2) deposit");
		 	System.out.println("3) chack balance");
		 	System.out.println("4) switch user");
		 	int option = input.nextInt();
		 	
		 	while (option == 1 || option == 2 || option == 3) {
		 		if (option == 1) {
		 				System.out.println("how much would you like to withdraw?: ");
		 				account1.setWit(input.nextDouble());
		 				account1.withdraw();
		 				System.out.println("\t\tyour new balance is " + "$" + account1.getBalance());
		 				System.out.println("Monthly interest: " + account1.getMonthlyInterest());
		 				System.out.println("1) withdraw");
		 			 	System.out.println("2) deposit");
		 			 	System.out.println("3) chack balance");
		 			 	System.out.println("4) switch user");
		 			 	option = input.nextInt();
		 		}
		 		if (option == 2) {
		 				System.out.println("how much would you like to deposit?: ");
		 				account1.setDep(input.nextDouble());
		 				account1.deposit();
		 				System.out.println("\t\tyour new balance is " + "$" + account1.getBalance());
		 				System.out.println("Monthly interest: " + account1.getMonthlyInterest());
		 				System.out.println("1) withdraw");
		 			 	System.out.println("2) deposit");
		 			 	System.out.println("3) chack balance");
		 			 	System.out.println("4) switch user");
		 			 	option = input.nextInt();
		 		}
		 		if (option == 3) {
		 			System.out.println("your balance is $" + account1.getBalance());
		 			System.out.println("1) withdraw");
	 			 	System.out.println("2) deposit");
	 			 	System.out.println("3) chack balance");
	 			 	System.out.println("4) switch user");
	 			 	option = input.nextInt();
		 		}
		 		if (option == 4) {
		 			ID = 0;
		 		}
		 		if (option != 1 && option != 2 && option != 3 && option != 4) {
		 				System.out.println("Not a valit input");
		 				System.out.print("Please enter a valid input: ");
		 				option = input.nextInt();
		 		}
		 	}
		}
	}
}
	class account {
		private static int ID = 0;
		java.util.Date date = new java.util.Date();
		private double balance = 100;
		private double annualInterestRate = 4.5;
		
// method is used to create the ID array.
		private static int[] ID() {
		int[] ID = new int[10];
		ID[1] = 1;
		ID[2] = 2;
		ID[3] = 3;
		ID[4] = 4;
		ID[5] = 5;
		ID[6] = 6;
		ID[7] = 7;
		ID[8] = 8;
		ID[9] = 9;
		ID[10] = 10;
		return ID;
		}
		
		static double getDep;
		static double getwit;
		
// these 2 methods get the monthly interest
		double getMonthlyInterestRate(){
			double monthlyInterestRate = annualInterestRate / 12;
			return monthlyInterestRate;
		}
		
		double getMonthlyInterest() {
			double monthlyInterest = getMonthlyInterestRate() * balance;
			return monthlyInterest;
		}
		
// these are the withdraw and deposit methods
		double withdraw() {
			balance = balance - getWit();
			return balance;
		}
		
		double deposit() {
			balance = balance + getDep();
			return balance;
		}

		
		
// all these methods are for the get/set
		public double getAnnualInterestRate() {
			return annualInterestRate;
		}
		public void setAnnualInterestRate(double annualInterestRate) {
			this.annualInterestRate = annualInterestRate;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public int getID() {
			return ID;
		}
		public void setID(int Id) {
			ID = Id;
		}
		public static double getDep() {
			return getDep;
		}
		public static void setDep(double Dep) {
			account.getDep = Dep;
		}
		public static double getWit() {
			return getwit;
		}
		public static void setWit(double Wit) {
			account.getwit = Wit;
		}
	}