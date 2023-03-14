package Ex11_1_3;

import java.util.Scanner;
import java.util.Date;

public class Exercise11_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Savings Savings1 = new Savings();
		Checking Checking1 = new Checking();
		
		while (0 < 1) {
			int accountNumber = 0;
			if (accountNumber == 0) {
				System.out.print("please enter an account number: ");
				accountNumber = input.nextInt();
			
				BankSystem.setID(accountNumber);
				
				if (accountNumber == BankSystem.ID) {
					System.out.println("Date accessed: " + BankSystem.getDateCreated());
					System.out.println("1) Checking");
					System.out.println("2) Savings");
					int accountType = input.nextInt();
					
					while (accountType == 1 || accountType == 2) {
						if (accountType == 1) {
							
							System.out.println("1) See account details");
							System.out.println("2) Deposit");
							System.out.println("3) Withdraw");
							System.out.println("4) Switch account");
							int accountOptions= input.nextInt();
							
							if (accountOptions == 1) {
								System.out.println(Checking1.BalanceC);
								System.out.println(Checking1.AIR);
							} else if (accountOptions == 2) {
								System.out.print("Howmuch would you like to deposit: ");
								double accountDeposit = input.nextDouble();
								
								BankSystem.setDeposit(accountDeposit);
								Checking1.Deposit();
								
								System.out.println(Checking1.BalanceC);
								System.out.println(Checking1.AIR);
								
							} else if (accountOptions == 3) {
								System.out.print("Howmuch would you like to withdraw: ");
								double accountWithdraw = input.nextDouble();
								
								BankSystem.setAccountWit(accountWithdraw);
								Checking1.Withdraw();
								
								
							} else if (accountOptions == 4) {
								accountNumber = 0;
								accountType = 0;
							}
							
							
							
						} else if (accountType == 2) {
								System.out.println("1) See account details");
								System.out.println("2) Deposit");
								System.out.println("3) Withdraw");
								System.out.println("4) Switch account");
								int accountOptions= input.nextInt();
							
							if (accountOptions == 1) {
								System.out.println(Savings1.BalanceS);
								System.out.println(Savings1.AIR);
							} else if (accountOptions == 2) {
								System.out.print("Howmuch would you like to deposit: ");
								double accountDeposit = input.nextDouble();
								
								BankSystem.setDeposit(accountDeposit);
								Savings1.Deposit();
								
								System.out.println(Savings1.BalanceS);
								System.out.println(Savings1.AIR);
								
							} else if (accountOptions == 3) {
								System.out.print("Howmuch would you like to withdraw: ");
								double accountWithdraw = input.nextDouble();
								
								BankSystem.setAccountWit(accountWithdraw);
								Savings1.Withdraw();
								
								
							} else if (accountOptions == 4) {
								accountNumber = 0;
								accountType = 0;
							}
						}
					}
				}
			}
		}
	}
}
	 class BankSystem {
		public static int ID = 0;
		private static java.util.Date dateCreated;
		static double Deposit;
		static double Withdraw;
		static int Type;
		
		public BankSystem() {
			dateCreated = new java.util.Date();
		}
		public static java.util.Date getDateCreated() {
			return dateCreated;
		}
		public static String toStringB() {
			return "Date created: " + dateCreated;
		}
		
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
		
		public int getID() {
			return ID;
		}
		public static void setID(int Id) {
			ID = Id;
		}
		public static void setDeposit(double accountDeposit) {
			Deposit = accountDeposit;
		}
		public static void setAccountWit(double accountWithdraw) {
			Withdraw = accountWithdraw;
		}
	 }
//----------------------------------------------------------------
		class Savings extends BankSystem {
			static double AIR = 4.5;
			static double BalanceS = 100;
			
			public double Deposit() {
				return this.BalanceS = this.Deposit + this.BalanceS;
			}
			public double Withdraw() {
				if (Withdraw < BalanceS) {
					this.BalanceS = this.BalanceS - this.Withdraw;
				} else if (Withdraw > BalanceS) {
					System.out.println("WARNING: This ammount exceeds your Balance. Transaction aborted.");
				}
				return BalanceS;
			}
		}
//----------------------------------------------------------------
		class Checking extends BankSystem {
			Scanner input = new Scanner(System.in);
			double AIR = 4.5;
			double BalanceC = 100;
			
			public void Deposit() {
				this.BalanceC = this.Deposit + this.BalanceC;
			}
			public double Withdraw() {
				if (Withdraw < BalanceC) {
					return this.BalanceC = this.BalanceC - this.Withdraw;
				} else if (Withdraw > BalanceC) {
					System.out.println("WARNING: This ammount exceeds your Balance.");
					System.out.println("1) Continue $35 overdraft fee.");
					System.out.println("2) return to options.");
					int overdraft = input.nextInt();
					if (overdraft == 1) {
						return this.BalanceC = this.BalanceC - this.Withdraw - 35;
					} else if (overdraft == 2) {
						System.out.println(" ");
					}
				}
				return BalanceC;
			}
		}