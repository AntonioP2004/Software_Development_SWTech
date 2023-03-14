package Final_Projects;

/*
Author: Antonio Parrinello
Date: 10/17/22

this program can run regular Tic-Tac-Toe and it can run Ultimate Tic-Tac-toe.
*/
import java.util.Scanner;
import java.util.Arrays;

class Ultimate_TicTacToe_V1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to ultimate Tic-Tac-Toe");
		System.out.println("what level of Tic-Tac-Toe would you like to play?");
		System.out.println("Level 1: Regular Tic-Tac-Toe estimated playtime 2 minutes");
		System.out.println("Level 2: Ultimate Tic-Tac-Toe estimated playtime 15 minutes");
		int level = input.nextInt();
		
		String s;
		int p = 0;
		 
		if (level == 1) {
			String[][] space = new String[10][10];
			space[1][1] = "1";
			space[2][2] = "2";
			space[3][3] = "3";
			space[4][4] = "4";
			space[5][5] = "5";
			space[6][6] = "6";
			space[7][7] = "7";
			space[8][8] = "8";
			space[9][9] = "9";
			for (int c = 0; c < 9; c++) {
				String[][] board = new String[][] { {
					"|---|---|---|",
					"| " + space[1][1] + " | " + space[2][2] + " | " + space[3][3] + " |",
					"|---|---|---|",
					"| " + space[4][4] + " | " + space[5][5] + " | " + space[6][6] + " |",
					"|---|---|---|",
					"| " + space[7][7] + " | " + space[8][8] + " | " + space[9][9] + " |",
					"|---|---|---|" }
				};
				Arrays.stream(board).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
				
				if (c % 2 == 0) {
					s = "X";
					p = 1;
				}
				else {
					s = "O";
					p = 2;
				}
				
				System.out.println("It is player " + p + "'s turn");
				
				int k = input.nextInt();
				
			if (!(s.equals(space[k][k]))) {
							space[k][k] = s;
			}
			else {
				System.out.println("Looks like that spot is taken please enter another spot: ");
				c++;
			}
			int winCon = 0;
			if (s.equals(space[1][1]) && s.equals(space[2][2]) && s.equals(space[3][3])) {
				winCon++;
			} else if (s.equals(space[4][4]) && s.equals(space[5][5]) && s.equals(space[6][6])) {
				winCon++;
			} else if (s.equals(space[7][7]) && s.equals(space[8][8]) && s.equals(space[9][9])) {
				winCon++;
			} else if (s.equals(space[1][1]) && s.equals(space[4][4]) && s.equals(space[7][7])) {
				winCon++;
			} else if (s.equals(space[2][2]) && s.equals(space[5][5]) && s.equals(space[8][8])) {
				winCon++;
			} else if (s.equals(space[3][3]) && s.equals(space[6][6]) && s.equals(space[9][9])) {
				winCon++;
			} else if (s.equals(space[1][1]) && s.equals(space[5][5]) && s.equals(space[9][9])) {
				winCon++;
			} else if (s.equals(space[7][7]) && s.equals(space[5][5]) && s.equals(space[3][3])) {
				winCon++;
			}
			if (winCon != 0) {
				System.out.println("Player " + p + " has won the game!");
				System.exit(1);
			}
		}
	}
	
		else if (level == 2) {
			String[][] space1 = new String[10][10];
			space1[1][1] = "1";
			space1[2][2] = "2";
			space1[3][3] = "3";
			space1[4][4] = "4";
			space1[5][5] = "5";
			space1[6][6] = "6";
			space1[7][7] = "7";
			space1[8][8] = "8";
			space1[9][9] = "9";
			String[][] space2 = new String[10][10];
			space2[1][1] = "1";
			space2[2][2] = "2";
			space2[3][3] = "3";
			space2[4][4] = "4";
			space2[5][5] = "5";
			space2[6][6] = "6";
			space2[7][7] = "7";
			space2[8][8] = "8";
			space2[9][9] = "9";
			String[][] space3 = new String[10][10];
			space3[1][1] = "1";
			space3[2][2] = "2";
			space3[3][3] = "3";
			space3[4][4] = "4";
			space3[5][5] = "5";
			space3[6][6] = "6";
			space3[7][7] = "7";
			space3[8][8] = "8";
			space3[9][9] = "9";
			String[][] space4 = new String[10][10];
			space4[1][1] = "1";
			space4[2][2] = "2";
			space4[3][3] = "3";
			space4[4][4] = "4";
			space4[5][5] = "5";
			space4[6][6] = "6";
			space4[7][7] = "7";
			space4[8][8] = "8";
			space4[9][9] = "9";
			String[][] space5= new String[10][10];
			space5[1][1] = "1";
			space5[2][2] = "2";
			space5[3][3] = "3";
			space5[4][4] = "4";
			space5[5][5] = "5";
			space5[6][6] = "6";
			space5[7][7] = "7";
			space5[8][8] = "8";
			space5[9][9] = "9";
			String[][] space6 = new String[10][10];
			space6[1][1] = "1";
			space6[2][2] = "2";
			space6[3][3] = "3";
			space6[4][4] = "4";
			space6[5][5] = "5";
			space6[6][6] = "6";
			space6[7][7] = "7";
			space6[8][8] = "8";
			space6[9][9] = "9";
			String[][] space7 = new String[10][10];
			space7[1][1] = "1";
			space7[2][2] = "2";
			space7[3][3] = "3";
			space7[4][4] = "4";
			space7[5][5] = "5";
			space7[6][6] = "6";
			space7[7][7] = "7";
			space7[8][8] = "8";
			space7[9][9] = "9";
			String[][] space8 = new String[10][10];
			space8[1][1] = "1";
			space8[2][2] = "2";
			space8[3][3] = "3";
			space8[4][4] = "4";
			space8[5][5] = "5";
			space8[6][6] = "6";
			space8[7][7] = "7";
			space8[8][8] = "8";
			space8[9][9] = "9";
			String[][] space9 = new String[10][10];
			space9[1][1] = "1";
			space9[2][2] = "2";
			space9[3][3] = "3";
			space9[4][4] = "4";
			space9[5][5] = "5";
			space9[6][6] = "6";
			space9[7][7] = "7";
			space9[8][8] = "8";
			space9[9][9] = "9";
			
			int player = 5;
			int[] winConK = new int[10];
			winConK[1] = 0;
			winConK[2] = 0;
			winConK[3] = 0;
			winConK[4] = 0;
			winConK[5] = 0;
			winConK[6] = 0;
			winConK[7] = 0;
			winConK[8] = 0;
			winConK[9] = 0;
			
			for (int c = 0; c < 81; c++) {
				String[][] ultimate = new String[][] { {
					"|---------------|---------------|---------------|",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"| " + "| " + space1[1][1] + " | " + space1[2][2] + " | " + space1[3][3] + " |" + " | " + "| " + space2[1][1] + " | " + space2[2][2] + " | " + space2[3][3] + " |" + " | " + "| " + space3[1][1] + " | " + space3[2][2] + " | " + space3[3][3] + " |" + " |",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"| " + "| " + space1[4][4] + " | " + space1[5][5] + " | " + space1[6][6] + " |" + " | " + "| " + space2[4][4] + " | " + space2[5][5] + " | " + space2[6][6] + " |" + " | " + "| " + space3[4][4] + " | " + space3[5][5] + " | " + space3[6][6] + " |" + " |",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"| " + "| " + space1[7][7] + " | " + space1[8][8] + " | " + space1[9][9] + " |" + " | " + "| " + space2[7][7] + " | " + space2[8][8] + " | " + space2[9][9] + " |" + " | " + "| " + space3[7][7] + " | " + space3[8][8] + " | " + space3[9][9] + " |" + " |",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"|---------------|---------------|---------------|",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"| " + "| " + space4[1][1] + " | " + space4[2][2] + " | " + space4[3][3] + " |" + " | " + "| " + space5[1][1] + " | " + space5[2][2] + " | " + space5[3][3] + " |" + " | " + "| " + space6[1][1] + " | " + space6[2][2] + " | " + space6[3][3] + " |" + " |",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"| " + "| " + space4[4][4] + " | " + space4[5][5] + " | " + space4[6][6] + " |" + " | " + "| " + space5[4][4] + " | " + space5[5][5] + " | " + space5[6][6] + " |" + " | " + "| " + space6[4][4] + " | " + space6[5][5] + " | " + space6[6][6] + " |" + " |",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"| " + "| " + space4[7][7] + " | " + space4[8][8] + " | " + space4[9][9] + " |" + " | " + "| " + space5[7][7] + " | " + space5[8][8] + " | " + space5[9][9] + " |" + " | " + "| " + space6[7][7] + " | " + space6[8][8] + " | " + space6[9][9] + " |" + " |",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"|---------------|---------------|---------------|",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"| " + "| " + space7[1][1] + " | " + space7[2][2] + " | " + space7[3][3] + " |" + " | " + "| " + space8[1][1] + " | " + space8[2][2] + " | " + space8[3][3] + " |" + " | " + "| " + space9[1][1] + " | " + space9[2][2] + " | " + space9[3][3] + " |" + " |",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"| " + "| " + space7[4][4] + " | " + space7[5][5] + " | " + space7[6][6] + " |" + " | " + "| " + space8[4][4] + " | " + space8[5][5] + " | " + space8[6][6] + " |" + " | " + "| " + space9[4][4] + " | " + space9[5][5] + " | " + space9[6][6] + " |" + " |",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"| " + "| " + space7[7][7] + " | " + space7[8][8] + " | " + space7[9][9] + " |" + " | " + "| " + space8[7][7] + " | " + space8[8][8] + " | " + space8[9][9] + " |" + " | " + "| " + space9[7][7] + " | " + space9[8][8] + " | " + space9[9][9] + " |" + " |",
					"| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |",
					"|---------------|---------------|---------------|" }
				};
				Arrays.stream(ultimate).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
				
				if (c % 2 == 0) {
					s = "X";
					p = 1;
				}
				else {
					s = "O";
					p = 2;
				}
				
				System.out.println("It is player " + p + "'s turn");
					int k = input.nextInt();
				
					if (winConK[k] != 0) {
						System.out.println("This zone is already taken Please enter zone you would like to go to:");
						player = input.nextInt();
						break;
					}
					
					switch (player) {
						case 1 :
						if (!(s.equals(space1[k][k]))) {
							space1[k][k] = s;
							player = k;
						}
						else {
							System.out.println("Looks like that spot is taken please enter another spot: ");
							c--;
						}
						break;
						case 2:
						if (!(s.equals(space2[k][k]))) {
							space2[k][k] = s;
							player = k;
						}
						else {
							System.out.println("Looks like that spot is taken please enter another spot: ");
							c--;
						}
						break;
						case 3:
						if (!(s.equals(space3[k][k]))) {
							space3[k][k] = s;
							player = k;
						}
						else {
							System.out.println("Looks like that spot is taken please enter another spot: ");
							c--;
						}
						break;
						case 4:
						if (!(s.equals(space4[k][k]))) {
							space4[k][k] = s;
							player = k;
						}
						else {
							System.out.println("Looks like that spot is taken please enter another spot: ");
							c--;
						}
						break;
						case 5:
						if (!(s.equals(space5[k][k]))) {
							space5[k][k] = s;
							player = k;
						}
						else {
							System.out.println("Looks like that spot is taken please enter another spot: ");
							c--;
						}
						break;
						case 6:
						if (!(s.equals(space6[k][k]))) {
							space6[k][k] = s;
							player = k;
						}
						else {
							System.out.println("Looks like that spot is taken please enter another spot: ");
							c--;
						}
						break;
						case 7:
						if (!(s.equals(space7[k][k]))) {
							space7[k][k] = s;
							player = k;
						}
						else {
							System.out.println("Looks like that spot is taken please enter another spot: ");
							c--;
						}
						break;
						case 8:
						if (!(s.equals(space8[k][k]))) {
							space8[k][k] = s;
							player = k;
						}
						else {
							System.out.println("Looks like that spot is taken please enter another spot: ");
							c--;
						}
						break;
						case 9:
						if (!(s.equals(space9[k][k]))) {
							space9[k][k] = s;
							player = k;
						}
						else {
							System.out.println("Looks like that spot is taken please enter another spot: ");
							c--;
						}
						break;
					}
				
				if (s.equals(space1[1][1]) && s.equals(space1[2][2]) && s.equals(space1[3][3])) {
					winConK[1]++;
				} else if (s.equals(space1[4][4]) && s.equals(space1[5][5]) && s.equals(space1[6][6])) {
					winConK[1]++;
				} else if (s.equals(space1[7][7]) && s.equals(space1[8][8]) && s.equals(space1[9][9])) {
					winConK[1]++;
				} else if (s.equals(space1[1][1]) && s.equals(space1[4][4]) && s.equals(space1[7][7])) {
					winConK[1]++;
				} else if (s.equals(space1[2][2]) && s.equals(space1[5][5]) && s.equals(space1[8][8])) {
					winConK[1]++;
				} else if (s.equals(space1[3][3]) && s.equals(space1[6][6]) && s.equals(space1[9][9])) {
					winConK[1]++;
				} else if (s.equals(space1[1][1]) && s.equals(space1[5][5]) && s.equals(space1[9][9])) {
					winConK[1]++;
				} else if (s.equals(space1[7][7]) && s.equals(space1[5][5]) && s.equals(space1[3][3])) {
					winConK[1]++;
				}
				if (winConK[1] != 0) {
					System.out.println("Player " + p + " has won this zone!");
				}
				
				if (s.equals(space2[1][1]) && s.equals(space2[2][2]) && s.equals(space2[3][3])) {
					winConK[2]++;
				} else if (s.equals(space2[4][4]) && s.equals(space2[5][5]) && s.equals(space2[6][6])) {
					winConK[2]++;
				} else if (s.equals(space2[7][7]) && s.equals(space2[8][8]) && s.equals(space2[9][9])) {
					winConK[2]++;
				} else if (s.equals(space2[1][1]) && s.equals(space2[4][4]) && s.equals(space2[7][7])) {
					winConK[2]++;
				} else if (s.equals(space2[2][2]) && s.equals(space2[5][5]) && s.equals(space2[8][8])) {
					winConK[2]++;
				} else if (s.equals(space2[3][3]) && s.equals(space2[6][6]) && s.equals(space2[9][9])) {
					winConK[2]++;
				} else if (s.equals(space2[1][1]) && s.equals(space2[5][5]) && s.equals(space2[9][9])) {
					winConK[2]++;
				} else if (s.equals(space2[7][7]) && s.equals(space2[5][5]) && s.equals(space2[3][3])) {
					winConK[2]++;
				}
				if (winConK[2] != 0) {
					System.out.println("Player " + p + " has won this zone!");
				}
				
				if (s.equals(space3[1][1]) && s.equals(space3[2][2]) && s.equals(space3[3][3])) {
					winConK[3]++;
				} else if (s.equals(space3[4][4]) && s.equals(space3[5][5]) && s.equals(space3[6][6])) {
					winConK[3]++;
				} else if (s.equals(space3[7][7]) && s.equals(space3[8][8]) && s.equals(space3[9][9])) {
					winConK[3]++;
				} else if (s.equals(space3[1][1]) && s.equals(space3[4][4]) && s.equals(space3[7][7])) {
					winConK[3]++;
				} else if (s.equals(space3[2][2]) && s.equals(space3[5][5]) && s.equals(space3[8][8])) {
					winConK[3]++;
				} else if (s.equals(space3[3][3]) && s.equals(space3[6][6]) && s.equals(space3[9][9])) {
					winConK[3]++;
				} else if (s.equals(space3[1][1]) && s.equals(space3[5][5]) && s.equals(space3[9][9])) {
					winConK[3]++;
				} else if (s.equals(space3[7][7]) && s.equals(space3[5][5]) && s.equals(space3[3][3])) {
					winConK[3]++;
				}
				if (winConK[3] != 0) {
					System.out.println("Player " + p + " has won this zone!");
				}
				
				if (s.equals(space4[1][1]) && s.equals(space4[2][2]) && s.equals(space4[3][3])) {
					winConK[4]++;
				} else if (s.equals(space4[4][4]) && s.equals(space4[5][5]) && s.equals(space4[6][6])) {
					winConK[4]++;
				} else if (s.equals(space4[7][7]) && s.equals(space4[8][8]) && s.equals(space4[9][9])) {
					winConK[4]++;
				} else if (s.equals(space4[1][1]) && s.equals(space4[4][4]) && s.equals(space4[7][7])) {
					winConK[4]++;
				} else if (s.equals(space4[2][2]) && s.equals(space4[5][5]) && s.equals(space4[8][8])) {
					winConK[4]++;
				} else if (s.equals(space4[3][3]) && s.equals(space4[6][6]) && s.equals(space4[9][9])) {
					winConK[4]++;
				} else if (s.equals(space4[1][1]) && s.equals(space4[5][5]) && s.equals(space4[9][9])) {
					winConK[4]++;
				} else if (s.equals(space4[7][7]) && s.equals(space4[5][5]) && s.equals(space4[3][3])) {
					winConK[4]++;
				}
				if (winConK[4] != 0) {
					System.out.println("Player " + p + " has won this zone!");
				}
				
				if (s.equals(space5[1][1]) && s.equals(space5[2][2]) && s.equals(space5[3][3])) {
					winConK[5]++;
				} else if (s.equals(space5[4][4]) && s.equals(space5[5][5]) && s.equals(space5[6][6])) {
					winConK[5]++;
				} else if (s.equals(space5[7][7]) && s.equals(space5[8][8]) && s.equals(space5[9][9])) {
					winConK[5]++;
				} else if (s.equals(space5[1][1]) && s.equals(space5[4][4]) && s.equals(space5[7][7])) {
					winConK[5]++;
				} else if (s.equals(space5[2][2]) && s.equals(space5[5][5]) && s.equals(space5[8][8])) {
					winConK[5]++;
				} else if (s.equals(space5[3][3]) && s.equals(space5[6][6]) && s.equals(space5[9][9])) {
					winConK[5]++;
				} else if (s.equals(space5[1][1]) && s.equals(space5[5][5]) && s.equals(space5[9][9])) {
					winConK[5]++;
				} else if (s.equals(space5[7][7]) && s.equals(space5[5][5]) && s.equals(space5[3][3])) {
					winConK[5]++;
				}
				if (winConK[5] != 0) {
					System.out.println("Player " + p + " has won this zone!");
				}
				
				if (s.equals(space6[1][1]) && s.equals(space6[2][2]) && s.equals(space6[3][3])) {
					winConK[6]++;
				} else if (s.equals(space6[4][4]) && s.equals(space6[5][5]) && s.equals(space6[6][6])) {
					winConK[6]++;
				} else if (s.equals(space6[7][7]) && s.equals(space6[8][8]) && s.equals(space6[9][9])) {
					winConK[6]++;
				} else if (s.equals(space6[1][1]) && s.equals(space6[4][4]) && s.equals(space6[7][7])) {
					winConK[6]++;
				} else if (s.equals(space6[2][2]) && s.equals(space6[5][5]) && s.equals(space6[8][8])) {
					winConK[6]++;
				} else if (s.equals(space6[3][3]) && s.equals(space6[6][6]) && s.equals(space6[9][9])) {
					winConK[6]++;
				} else if (s.equals(space6[1][1]) && s.equals(space6[5][5]) && s.equals(space6[9][9])) {
					winConK[6]++;
				} else if (s.equals(space6[7][7]) && s.equals(space6[5][5]) && s.equals(space6[3][3])) {
					winConK[6]++;
				}
				if (winConK[6] != 0) {
					System.out.println("Player " + p + " has won this zone!");
				}
				
				if (s.equals(space7[1][1]) && s.equals(space7[2][2]) && s.equals(space7[3][3])) {
					winConK[7]++;
				} else if (s.equals(space7[4][4]) && s.equals(space7[5][5]) && s.equals(space7[6][6])) {
					winConK[7]++;
				} else if (s.equals(space7[7][7]) && s.equals(space7[8][8]) && s.equals(space7[9][9])) {
					winConK[7]++;
				} else if (s.equals(space7[1][1]) && s.equals(space7[4][4]) && s.equals(space7[7][7])) {
					winConK[7]++;
				} else if (s.equals(space7[2][2]) && s.equals(space7[5][5]) && s.equals(space7[8][8])) {
					winConK[7]++;
				} else if (s.equals(space7[3][3]) && s.equals(space7[6][6]) && s.equals(space7[9][9])) {
					winConK[7]++;
				} else if (s.equals(space7[1][1]) && s.equals(space7[5][5]) && s.equals(space7[9][9])) {
					winConK[7]++;
				} else if (s.equals(space7[7][7]) && s.equals(space7[5][5]) && s.equals(space7[3][3])) {
					winConK[7]++;
				}
				if (winConK[7] != 0) {
					System.out.println("Player " + p + " has won this zone!");
				}
				
				if (s.equals(space8[1][1]) && s.equals(space8[2][2]) && s.equals(space8[3][3])) {
					winConK[8]++;
				} else if (s.equals(space8[4][4]) && s.equals(space8[5][5]) && s.equals(space8[6][6])) {
					winConK[8]++;
				} else if (s.equals(space8[7][7]) && s.equals(space8[8][8]) && s.equals(space8[9][9])) {
					winConK[8]++;
				} else if (s.equals(space8[1][1]) && s.equals(space8[4][4]) && s.equals(space8[7][7])) {
					winConK[8]++;
				} else if (s.equals(space8[2][2]) && s.equals(space8[5][5]) && s.equals(space8[8][8])) {
					winConK[8]++;
				} else if (s.equals(space8[3][3]) && s.equals(space8[6][6]) && s.equals(space8[9][9])) {
					winConK[8]++;
				} else if (s.equals(space8[1][1]) && s.equals(space8[5][5]) && s.equals(space8[9][9])) {
					winConK[8]++;
				} else if (s.equals(space8[7][7]) && s.equals(space8[5][5]) && s.equals(space8[3][3])) {
					winConK[8]++;
				}
				if (winConK[8]!= 0) {
					System.out.println("Player " + p + " has won this zone!");
				}
				
				if (s.equals(space9[1][1]) && s.equals(space9[2][2]) && s.equals(space9[3][3])) {
					winConK[9]++;
				} else if (s.equals(space9[4][4]) && s.equals(space9[5][5]) && s.equals(space9[6][6])) {
					winConK[9]++;
				} else if (s.equals(space9[7][7]) && s.equals(space9[8][8]) && s.equals(space9[9][9])) {
					winConK[9]++;
				} else if (s.equals(space9[1][1]) && s.equals(space9[4][4]) && s.equals(space9[7][7])) {
					winConK[9]++;
				} else if (s.equals(space9[2][2]) && s.equals(space9[5][5]) && s.equals(space9[8][8])) {
					winConK[9]++;
				} else if (s.equals(space9[3][3]) && s.equals(space9[6][6]) && s.equals(space9[9][9])) {
					winConK[9]++;
				} else if (s.equals(space9[1][1]) && s.equals(space9[5][5]) && s.equals(space9[9][9])) {
					winConK[9]++;
				} else if (s.equals(space9[7][7]) && s.equals(space9[5][5]) && s.equals(space9[3][3])) {
					winConK[9]++;
				}
				if (winConK[9] != 0) {
					System.out.println("Player " + p + " has won this zone!");
				}
				int winCon = 0;
				if (winConK[1] != 0 && winConK[2]!= 0 && winConK[3] != 0) {
					winCon++;
				} else if (winConK[4] != 0 && winConK[5] != 0 && winConK[6] != 0) {
					winCon++;
				} else if (winConK[7] != 0 && winConK[8] != 0 && winConK[9] != 0) {
					winCon++;
				} else if (winConK[1] != 0 && winConK[4] != 0 && winConK[7] != 0) {
					winCon++;
				} else if (winConK[2] != 0 && winConK[5] != 0 && winConK[8] != 0) {
					winCon++;
				} else if (winConK[3] != 0 && winConK[6] != 0 && winConK[9] != 0) {
					winCon++;
				} else if (winConK[1] != 0 && winConK[5] != 0 && winConK[9] != 0) {
					winCon++;
				} else if (winConK[7] != 0 && winConK[5] != 0 && winConK[3] != 0) {
					winCon++;
				}
				if (winCon != 0) {
					System.out.println("Player " + p + " has won the game!");
					System.exit(1);
				}
			}
		}
	}
}