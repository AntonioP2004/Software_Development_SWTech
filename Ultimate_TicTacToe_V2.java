package Final_Projects;

/*
Author: Antonio Parrinello
Date: 1/6/23

this program can run regular Tic-Tac-Toe and it can run Ultimate Tic-Tac-toe.

V2 changes:
- using classes i shortened the length of the code by half to make it easier to go through.
- fixed the bug that will allow the next player to replace the last chosen space.
- removed most "if" and "switch" statements used in original version.
- compressed all arrays for UTTT to fit into 1 array and using 2 arrays to manage if a zone is taken and if the game has been won.
-compressed win conditions down to 1 if statement for both versions.
- added 3 players option to UTTT while normal sets to 2 players.
*/

import java.util.Scanner;

class Ultimate_TicTacToe_V2 {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			UltimateTicTacToe ut = new UltimateTicTacToe();
			String[] space = new String[10];
			space[1] = "1";
			space[2] = "2";
			space[3] = "3";
			space[4] = "4";
			space[5] = "5";
			space[6] = "6";
			space[7] = "7";
			space[8] = "8";
			space[9] = "9";
			String[] zones = new String[10];
			zones[1] = "No Owner";
			zones[2] = "No Owner";
			zones[3] = "No Owner";
			zones[4] = "No Owner";
			zones[5] = "No Owner";
			zones[6] = "No Owner";
			zones[7] = "No Owner";
			zones[8] = "No Owner";
			zones[9] = "No Owner";
			String[][] spaces = new String[10][10];
			spaces[1][1] = "1"; spaces[1][2] = "1"; spaces[1][3] = "1"; spaces[1][4] = "1"; spaces[1][5] = "1"; spaces[1][6] = "1"; spaces[1][7] = "1"; spaces[1][8] = "1"; spaces[1][9] = "1";
			spaces[2][1] = "2";	spaces[2][2] = "2"; spaces[2][3] = "2"; spaces[2][4] = "2"; spaces[2][5] = "2"; spaces[2][6] = "2"; spaces[2][7] = "2"; spaces[2][8] = "2"; spaces[2][9] = "2";
			spaces[3][1] = "3"; spaces[3][2] = "3"; spaces[3][3] = "3"; spaces[3][4] = "3"; spaces[3][5] = "3"; spaces[3][6] = "3"; spaces[3][7] = "3"; spaces[3][8] = "3"; spaces[3][9] = "3";
			spaces[4][1] = "4"; spaces[4][2] = "4"; spaces[4][3] = "4"; spaces[4][4] = "4"; spaces[4][5] = "4"; spaces[4][6] = "4"; spaces[4][7] = "4"; spaces[4][8] = "4"; spaces[4][9] = "4";
			spaces[5][1] = "5"; spaces[5][2] = "5"; spaces[5][3] = "5"; spaces[5][4] = "5"; spaces[5][5] = "5"; spaces[5][6] = "5"; spaces[5][7] = "5"; spaces[5][8] = "5"; spaces[5][9] = "5";
			spaces[6][1] = "6"; spaces[6][2] = "6"; spaces[6][3] = "6"; spaces[6][4] = "6"; spaces[6][5] = "6"; spaces[6][6] = "6"; spaces[6][7] = "6"; spaces[6][8] = "6"; spaces[6][9] = "6";
			spaces[7][1] = "7"; spaces[7][2] = "7"; spaces[7][3] = "7"; spaces[7][4] = "7"; spaces[7][5] = "7"; spaces[7][6] = "7"; spaces[7][7] = "7"; spaces[7][8] = "7"; spaces[7][9] = "7";
			spaces[8][1] = "8"; spaces[8][2] = "8"; spaces[8][3] = "8"; spaces[8][4] = "8"; spaces[8][5] = "8"; spaces[8][6] = "8"; spaces[8][7] = "8"; spaces[8][8] = "8"; spaces[8][9] = "8";
			spaces[9][1] = "9"; spaces[9][2] = "9"; spaces[9][3] = "9"; spaces[9][4] = "9"; spaces[9][5] = "9"; spaces[9][6] = "9"; spaces[9][7] = "9"; spaces[9][8] = "9"; spaces[9][9] = "9";
			System.out.println("Welcome to ultimate Tic-Tac-Toe");
			System.out.println("what level of Tic-Tac-Toe would you like to play?");
			System.out.println("Level 1: Regular Tic-Tac-Toe estimated playtime 2 minutes");
			System.out.println("Level 2: Ultimate Tic-Tac-Toe estimated playtime 15 minutes");
			int level = input.nextInt();
			int players;
			if (level == 2) {
				System.out.println("Will this game be 2 player or 3 player? (0-O  1-X  2-S)");
				players = input.nextInt();
				ut.setPlayers(players); 
			} else {
				players = 2;
				ut.setPlayers(players);
			}
			int x = 0;
			int play = 0;
			if (level == 1) {
				while (x < 9) {
					System.out.println(TicTacToe.board(space));
					System.out.print("Player " + ((TicTacToe.c % 2) + 1) + " please select a spot: ");
					int select = input.nextInt();
					TicTacToe.setSelect(select);
					if (space[TicTacToe.Select] == "X" || space[TicTacToe.Select] == "O") {
						System.out.println("This space is already taken please try again");
						x--;
					}
					x++;
				}
				System.out.println("Draw!");
			} else if (level == 2) { 
				while (x < 81) {
					if (players == 2) {
						play = (ut.c % 2);
					}
					if (players == 3) {
						play = (ut.c % 3);
					}
				int select = 0;
				System.out.println(ut.board(spaces, zones));
				if (x == 0) {
					System.out.println("Please select a starting zone player 0: ");
					ut.c = 0;
					select = input.nextInt();
					ut.setSelect(select);
					x++;
				} else {
					System.out.print("Player: " + play + "\nzone: " + ut.zone + "\nplease select a spot: ");
					select = input.nextInt();
					UltimateTicTacToe.setSelect(select);
					if (spaces[ut.Select][ut.zone] == "X" || spaces[ut.Select][ut.zone] == "O" || spaces[ut.Select][ut.zone] == "S") {
						System.out.println("This space is already taken please try again");
						x--;
					}
					x++;
				}
			}
			System.out.println("Draw!");
		}
	}
}
class TicTacToe {
	static String winCon = "Not Yet";
	static int Select;
	static int c = 0;
	static String board(String[] space) {
		if (space[Select] != "X" && space[Select] != "O"){
			if (c % 2 == 0) {
				space[Select] = "O";
				c++;
			} else if (c % 2 == 1) {
				space[Select] = "X";
				c++;
			}
		}
		if ((space[1].equals("X") && space[2].equals("X") && space[3].equals("X") ) || (space[4].equals("X") && space[5].equals("X") && space[6].equals("X") ) || (space[7].equals("X") && space[8].equals("X") && space[9].equals("X") ) || (space[1].equals("X") && space[4].equals("X") && space[7].equals("X") ) || (space[2].equals("X") && space[5].equals("X") && space[8].equals("X") ) || (space[3].equals("X") && space[6].equals("X") && space[9].equals("X") ) || (space[1].equals("X") && space[5].equals("X") && space[9].equals("X") ) || (space[3].equals("X") && space[5].equals("X") && space[7].equals("X") ) || (space[1].equals("O") && space[2].equals("O") && space[3].equals("O") ) || (space[4].equals("O") && space[5].equals("O") && space[6].equals("O") ) || (space[7].equals("O") && space[8].equals("O") && space[9].equals("O") ) || (space[1].equals("O") && space[4].equals("O") && space[7].equals("O") ) || (space[2].equals("O") && space[5].equals("O") && space[8].equals("O") ) || (space[3].equals("O") && space[6].equals("O") && space[9].equals("O") ) || (space[1].equals("O") && space[5].equals("O") && space[9].equals("O") ) || (space[3].equals("O") && space[5].equals("O") && space[7].equals("O") ) ) {
					System.out.println("|---|---|---|" +
					"\n| " + space[1] + " | " + space[2] + " | " + space[3] + " |" +
					"\n|---|---|---|" +
					"\n| " + space[4] + " | " + space[5] + " | " + space[6] + " |" +
					"\n|---|---|---|" +
					"\n| " + space[7] + " | " + space[8] + " | " + space[9] + " |" +
					"\n|---|---|---|" +
					"\nWinner is player " + ((c % 2) + 1));
					System.exit(0);
			}
		return "|---|---|---|" +
				"\n| " + space[1] + " | " + space[2] + " | " + space[3] + " |" +
				"\n|---|---|---|" +
				"\n| " + space[4] + " | " + space[5] + " | " + space[6] + " |" +
				"\n|---|---|---|" +
				"\n| " + space[7] + " | " + space[8] + " | " + space[9] + " |" +
				"\n|---|---|---|" ;
	}
	public static int setSelect(int select) {
		return Select = select;
	}
}
class UltimateTicTacToe {
	Scanner input = new Scanner(System.in);
	public int winCon;
	static int c;
	static int Players;
	static int Select;
	static int zone = 0;
	String board(String[][] spaces,String[] zones) {
		if (spaces[Select][zone] != "X" && spaces[Select][zone] != "O" && spaces[Select][zone] != "S"){
			if (Players == 2) {
				if (c % 2 == 0) {
					spaces[Select][zone] = "X";
					zone = Select;
					c++;
				} else if (c % 2 == 1) {
					spaces[Select][zone] = "O";
					zone = Select;
					c++;
				} 
			} else if (Players == 3) {
				if (c % 3 == 0) {
					spaces[Select][zone] = "X";
					zone = Select;
					c++;
				} else if (c % 3 == 1) {
					spaces[Select][zone] = "O";
					zone = Select;
					c++;
				} else if (c % 3 == 2) {
					spaces[Select][zone] = "S";
					zone = Select;
					c++;
				}
			}
		}
		while (zone != 0) {
			if ( (spaces[1][zone].equals("X") && spaces[2][zone].equals("X") && spaces[3][zone].equals("X") ) || (spaces[4][zone].equals("X") && spaces[5][zone].equals("X") && spaces[6][zone].equals("X") ) || (spaces[7][zone].equals("X") && spaces[8][zone].equals("X") && spaces[9][zone].equals("X") ) || (spaces[1][zone].equals("X") && spaces[4][zone].equals("X") && spaces[7][zone].equals("X") ) || (spaces[2][zone].equals("X") && spaces[5][zone].equals("X") && spaces[8][zone].equals("X") ) || (spaces[3][zone].equals("X") && spaces[6][zone].equals("X") && spaces[9][zone].equals("X") ) || (spaces[1][zone].equals("X") && spaces[5][zone].equals("X") && spaces[9][zone].equals("X") ) || (spaces[3][zone].equals("X") && spaces[5][zone].equals("X") && spaces[7][zone].equals("X") ) || (spaces[1][zone].equals("O") && spaces[2][zone].equals("O") && spaces[3][zone].equals("O") ) || (spaces[4][zone].equals("O") && spaces[5][zone].equals("O") && spaces[6][zone].equals("O") ) || (spaces[7][zone].equals("O") && spaces[8][zone].equals("O") && spaces[9][zone].equals("O") ) || (spaces[1][zone].equals("O") && spaces[4][zone].equals("O") && spaces[7][zone].equals("O") ) || (spaces[2][zone].equals("O") && spaces[5][zone].equals("O") && spaces[8][zone].equals("O") ) || (spaces[3][zone].equals("O") && spaces[6][zone].equals("O") && spaces[9][zone].equals("O") ) || (spaces[1][zone].equals("O") && spaces[5][zone].equals("O") && spaces[9][zone].equals("O") ) || (spaces[3][zone].equals("O") && spaces[5][zone].equals("O") && spaces[7][zone].equals("O") ) || (spaces[1][zone].equals("S") && spaces[2][zone].equals("S") && spaces[3][zone].equals("S") ) || (spaces[4][zone].equals("S") && spaces[5][zone].equals("S") && spaces[6][zone].equals("S") ) || (spaces[7][zone].equals("S") && spaces[8][zone].equals("S") && spaces[9][zone].equals("S") ) || (spaces[1][zone].equals("S") && spaces[4][zone].equals("S") && spaces[7][zone].equals("S") ) || (spaces[2][zone].equals("S") && spaces[5][zone].equals("S") && spaces[8][zone].equals("S") ) || (spaces[3][zone].equals("S") && spaces[6][zone].equals("S") && spaces[9][zone].equals("S") ) || (spaces[1][zone].equals("S") && spaces[5][zone].equals("S") && spaces[9][zone].equals("S") ) || (spaces[3][zone].equals("S") && spaces[5][zone].equals("S") && spaces[7][zone].equals("S") ) ) {
					String obj = "Owned by player " + (c % Players);
					if (!zones[zone].equals(obj)) {
							zones[zone] = obj;
							if (zones[zone].equals(obj)) {
								System.out.println("zone " + zones[zone] + " please select a new zone ");
								zone = input.nextInt();
								break;
							}
					} else if (zones[zone].equals(obj)) {
						if ( (zones[1].equals(obj) && zones[2].equals(obj) && zones[3].equals(obj) ) || (zones[4].equals(obj) && zones[5].equals(obj) && zones[6].equals(obj) ) || (zones[7].equals(obj) && zones[8].equals(obj) && zones[9].equals(obj) ) || (zones[1].equals(obj) && zones[4].equals(obj) && zones[7].equals(obj) ) || (zones[2].equals(obj) && zones[5].equals(obj) && zones[8].equals(obj) ) || (zones[3].equals(obj) && zones[6].equals(obj) && zones[9].equals(obj) ) || (zones[1].equals(obj) && zones[5].equals(obj) && zones[9].equals(obj) ) || (zones[3].equals(obj) && zones[5].equals(obj) && zones[7].equals(obj) ) ) {
							System.out.println("|---------------|---------------|---------------|" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n| " + "| " + spaces[1][1] + " | " + spaces[2][1] + " | " + spaces[3][1] + " |" + " | " + "| " + spaces[1][2] + " | " + spaces[2][2] + " | " + spaces[3][2] + " |" + " | " + "| " + spaces[1][3] + " | " + spaces[2][3] + " | " + spaces[3][3] + " |" + " |" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n| " + "| " + spaces[4][1] + " | " + spaces[5][1] + " | " + spaces[6][1] + " |" + " | " + "| " + spaces[4][2] + " | " + spaces[5][2] + " | " + spaces[6][2] + " |" + " | " + "| " + spaces[4][3] + " | " + spaces[5][3] + " | " + spaces[6][3] + " |" + " |" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n| " + "| " + spaces[7][1] + " | " + spaces[8][1] + " | " + spaces[9][1] + " |" + " | " + "| " + spaces[7][2] + " | " + spaces[8][2] + " | " + spaces[9][2] + " |" + " | " + "| " + spaces[7][3] + " | " + spaces[8][3] + " | " + spaces[9][3] + " |" + " |" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n|---------------|---------------|---------------|" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n| " + "| " + spaces[1][4] + " | " + spaces[2][4] + " | " + spaces[3][4] + " |" + " | " + "| " + spaces[1][5] + " | " + spaces[2][5] + " | " + spaces[3][5] + " |" + " | " + "| " + spaces[1][6] + " | " + spaces[2][6] + " | " + spaces[3][6] + " |" + " |" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n| " + "| " + spaces[4][4] + " | " + spaces[5][4] + " | " + spaces[6][4] + " |" + " | " + "| " + spaces[4][5] + " | " + spaces[5][5] + " | " + spaces[6][5] + " |" + " | " + "| " + spaces[4][6] + " | " + spaces[5][6] + " | " + spaces[6][6] + " |" + " |" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n| " + "| " + spaces[7][4] + " | " + spaces[8][4] + " | " + spaces[9][4] + " |" + " | " + "| " + spaces[7][5] + " | " + spaces[8][5] + " | " + spaces[9][5] + " |" + " | " + "| " + spaces[7][6] + " | " + spaces[8][6] + " | " + spaces[9][6] + " |" + " |" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n|---------------|---------------|---------------|" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n| " + "| " + spaces[1][7] + " | " + spaces[2][7] + " | " + spaces[3][7] + " |" + " | " + "| " + spaces[1][8] + " | " + spaces[2][8] + " | " + spaces[3][8] + " |" + " | " + "| " + spaces[1][9] + " | " + spaces[2][9] + " | " + spaces[3][9] + " |" + " |" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n| " + "| " + spaces[4][7] + " | " + spaces[5][7] + " | " + spaces[6][7] + " |" + " | " + "| " + spaces[4][8] + " | " + spaces[5][8] + " | " + spaces[6][8] + " |" + " | " + "| " + spaces[4][9] + " | " + spaces[5][9] + " | " + spaces[6][9] + " |" + " |" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n| " + "| " + spaces[7][7] + " | " + spaces[8][7] + " | " + spaces[9][7] + " |" + " | " + "| " + spaces[7][8] + " | " + spaces[8][8] + " | " + spaces[9][8] + " |" + " | " + "| " + spaces[7][9] + " | " + spaces[8][9] + " | " + spaces[9][9] + " |" + " |" +
								"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
								"\n|---------------|---------------|---------------|" +
								"\nWinner is player " + ((c % 2) + 1));
								System.exit(0);
					}
							break;
				}
			}
			break;
		}
		return "|---------------|---------------|---------------|" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n| " + "| " + spaces[1][1] + " | " + spaces[2][1] + " | " + spaces[3][1] + " |" + " | " + "| " + spaces[1][2] + " | " + spaces[2][2] + " | " + spaces[3][2] + " |" + " | " + "| " + spaces[1][3] + " | " + spaces[2][3] + " | " + spaces[3][3] + " |" + " |" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n| " + "| " + spaces[4][1] + " | " + spaces[5][1] + " | " + spaces[6][1] + " |" + " | " + "| " + spaces[4][2] + " | " + spaces[5][2] + " | " + spaces[6][2] + " |" + " | " + "| " + spaces[4][3] + " | " + spaces[5][3] + " | " + spaces[6][3] + " |" + " |" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n| " + "| " + spaces[7][1] + " | " + spaces[8][1] + " | " + spaces[9][1] + " |" + " | " + "| " + spaces[7][2] + " | " + spaces[8][2] + " | " + spaces[9][2] + " |" + " | " + "| " + spaces[7][3] + " | " + spaces[8][3] + " | " + spaces[9][3] + " |" + " |" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n|---------------|---------------|---------------|" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n| " + "| " + spaces[1][4] + " | " + spaces[2][4] + " | " + spaces[3][4] + " |" + " | " + "| " + spaces[1][5] + " | " + spaces[2][5] + " | " + spaces[3][5] + " |" + " | " + "| " + spaces[1][6] + " | " + spaces[2][6] + " | " + spaces[3][6] + " |" + " |" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n| " + "| " + spaces[4][4] + " | " + spaces[5][4] + " | " + spaces[6][4] + " |" + " | " + "| " + spaces[4][5] + " | " + spaces[5][5] + " | " + spaces[6][5] + " |" + " | " + "| " + spaces[4][6] + " | " + spaces[5][6] + " | " + spaces[6][6] + " |" + " |" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n| " + "| " + spaces[7][4] + " | " + spaces[8][4] + " | " + spaces[9][4] + " |" + " | " + "| " + spaces[7][5] + " | " + spaces[8][5] + " | " + spaces[9][5] + " |" + " | " + "| " + spaces[7][6] + " | " + spaces[8][6] + " | " + spaces[9][6] + " |" + " |" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n|---------------|---------------|---------------|" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n| " + "| " + spaces[1][7] + " | " + spaces[2][7] + " | " + spaces[3][7] + " |" + " | " + "| " + spaces[1][8] + " | " + spaces[2][8] + " | " + spaces[3][8] + " |" + " | " + "| " + spaces[1][9] + " | " + spaces[2][9] + " | " + spaces[3][9] + " |" + " |" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n| " + "| " + spaces[4][7] + " | " + spaces[5][7] + " | " + spaces[6][7] + " |" + " | " + "| " + spaces[4][8] + " | " + spaces[5][8] + " | " + spaces[6][8] + " |" + " | " + "| " + spaces[4][9] + " | " + spaces[5][9] + " | " + spaces[6][9] + " |" + " |" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n| " + "| " + spaces[7][7] + " | " + spaces[8][7] + " | " + spaces[9][7] + " |" + " | " + "| " + spaces[7][8] + " | " + spaces[8][8] + " | " + spaces[9][8] + " |" + " | " + "| " + spaces[7][9] + " | " + spaces[8][9] + " | " + spaces[9][9] + " |" + " |" +
				"\n| " + "|---|---|---|" + " | " + "|---|---|---|" + " | " + "|---|---|---|" + " |" +
				"\n|---------------|---------------|---------------|";
	}
	public static int setSelect(int select) { return Select = select; }
	public static int setPlayers(int players) { return Players = players; }
	public static int setZoneSet(int zoneSet) { return zone = zoneSet; }  
}