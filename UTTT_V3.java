/*
 * Author: Antonio Parrinello
 * Date: 3/2/23
 * 
 * Program runs Tic-Tac-Toe and Ultimate Tic-Tac-Toe.
 */

package OOP2_Final;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UTTT_V3 extends Application{
	static boolean three = false;
	java.lang.String P = " ";
	int Q = 0;
	boolean Lock = false;
	boolean win = false;

	/*
	 * primary method for program.
	 */
	@Override
	public void start(Stage primaryStage) {
		BorderPane Menu = new BorderPane();
		BorderPane PlayselMenu = new BorderPane();
		BorderPane infoPane = new BorderPane();
		Scene scene = new Scene(Menu, 350, 75);
		Scene sceneUTTTsel = new Scene(PlayselMenu, 300, 75);
		Scene info = new Scene(infoPane, 385, 210);
		
		new TTT();
		Scene sceneTTT = new Scene(TTT.borderPane, 400, 400);
		new UTTT();
		Scene sceneUTTT = new Scene(UTTT.borderPane, 500, 500);
		
		Label Title = new Label("Ultimate Tic-Tac-Toe");
		Title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		Title.setTextFill(Color.BLACK);
		
		Label infoLabel = new Label("Tic-Tac-Toe:"
				+ "\n Regular Tic-Tac-Toe game!"
				+ "\n Ultimate Tic-Tac-Toe:"
				+ "\n In this version of Ultimate Tic-Tac-Toe you may play in"
				+ "\n any square at any time even when the zone has been taken"
				+ "\n (placing in taken zones does not take the zone it is meant"
				+ "\n to be a placeholder) the goal is to win 3 Tic-Tac-Toe games"
				+ "\n in a row to win the game!");
		infoLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		infoLabel.setTextFill(Color.BLACK);
		
		Button TTT = new Button("Tic-Tac-Toe");
		Button UTTT= new Button("Ultimate Tic-Tac-Toe");
		Button twoPlays = new Button("2 Players");
		Button threePlays = new Button("3 Players");
		Button BackUTTT = new Button("Back");
		
		Button infoButton = new Button("Rules and Info");
		Button infoBack = new Button("Back");
		
		HBox topPane = new HBox();
		topPane.getChildren().addAll(Title);
		topPane.setAlignment(Pos.CENTER);
		
		HBox bottomPane = new HBox();
		bottomPane.getChildren().addAll(TTT, UTTT, infoButton);
		bottomPane.setSpacing(10);
		bottomPane.setAlignment(Pos.CENTER);
		
		HBox Playsel = new HBox();
		Playsel.getChildren().addAll(twoPlays, threePlays, BackUTTT);
		Playsel.setSpacing(10);
		Playsel.setAlignment(Pos.CENTER);
		
		HBox infoCenterPane = new HBox();
		infoCenterPane.getChildren().add(infoLabel);
		HBox infoBottomPane = new HBox();
		infoBottomPane.getChildren().add(infoBack);
		
		Menu.setTop(topPane);
		Menu.setBottom(bottomPane);
		
		PlayselMenu.setCenter(Playsel);
		
		infoPane.setCenter(infoLabel);
		infoPane.setBottom(infoBack);
		
		infoButton.setOnAction(e -> primaryStage.setScene(info));
		infoBack.setOnAction(e -> primaryStage.setScene(scene));
		
		UTTT.setOnAction(e -> primaryStage.setScene(sceneUTTTsel));
		BackUTTT.setOnAction(e -> primaryStage.setScene(scene));
		
		TTT.setOnAction(e -> primaryStage.setScene(sceneTTT));
		twoPlays.setOnAction(e -> primaryStage.setScene(sceneUTTT));
		threePlays.setOnAction(e -> {
			three = true;
			setThree(three);
			primaryStage.setScene(sceneUTTT);
		});
		
		primaryStage.setTitle("Ultimate Tic-Tac-Toe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(java.lang.String[] args) {
		launch(args);
	}
	
	public void setThree(boolean three) {
		UTTT.setThree(three);
	}
}

/*
 *  Class for Tic-Tac-Toe.
 */
class TTT extends Parent {
	public static BorderPane borderPane = new BorderPane();
	private char whoseTurn = 'X';
	private Cell[][] cell =  new Cell[3][3];
	private Label lblStatus = new Label("X's turn to play");
	public TTT() {
		GridPane pane = new GridPane();
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				pane.add(cell[i][j] = new Cell(), j, i);
		borderPane.setCenter(pane); 
		borderPane.setBottom(lblStatus);
}

	public boolean isFull() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (cell[i][j].getToken() == ' ')
					return false;
		return true;
	}

	public boolean isWon(char token) {
		for (int i = 0; i < 3; i++)
			if (cell[i][0].getToken() == token
			&& cell[i][1].getToken() == token
			&& cell[i][2].getToken() == token) {
				return true;
			}

		for (int j = 0; j < 3; j++)
			if (cell[0][j].getToken() ==  token
				&& cell[1][j].getToken() == token
				&& cell[2][j].getToken() == token) {
				return true;
			}

		if (cell[0][0].getToken() == token 
				&& cell[1][1].getToken() == token        
				&& cell[2][2].getToken() == token) {
			return true;
		}

		if (cell[0][2].getToken() == token
				&& cell[1][1].getToken() == token
				&& cell[2][0].getToken() == token) {
			return true;
		}

		return false;
	}

	public class Cell extends Pane {
		private char token = ' ';

		public Cell() {
			setStyle("-fx-border-color: black"); 
			this.setPrefSize(2000, 2000);
			this.setOnMouseClicked(e -> handleMouseClick());
		}

		public char getToken() {
			return token;
}

		public void setToken(char c) {
			token = c;

			if (token == 'X') {
				Line line1 = new Line(10, 10, 
						this.getWidth() - 10, this.getHeight() - 10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				Line line2 = new Line(10, this.getHeight() - 10, 
						this.getWidth() - 10, 10);
				line2.startYProperty().bind(
						this.heightProperty().subtract(10));
				line2.endXProperty().bind(this.widthProperty().subtract(10));

				this.getChildren().addAll(line1, line2); 
			}
			else if (token == 'O') {
				Ellipse ellipse = new Ellipse(this.getWidth() / 2, 
						this.getHeight() / 2, this.getWidth() / 2 - 10, 
						this.getHeight() / 2 - 10);
				ellipse.centerXProperty().bind(
						this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(
						this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(
						this.widthProperty().divide(2).subtract(10));        
				ellipse.radiusYProperty().bind(
						this.heightProperty().divide(2).subtract(10));   
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.WHITE);

				getChildren().add(ellipse);
			}
		}
		
		private void handleMouseClick() {
			if (token == ' ' && whoseTurn != ' ') {
				setToken(whoseTurn);
	
				if (isWon(whoseTurn)) {
					lblStatus.setText(whoseTurn + " won! The game is over");
					whoseTurn = ' ';
				}
				else if (isFull()) {
					lblStatus.setText("Draw! The game is over");
					whoseTurn = ' ';
				}
				else {
					whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
					lblStatus.setText(whoseTurn + "'s turn");
				}
			}
		}
	}
}
/*
 * Class for Ultimate Tic-Tac-Toe.
 */
class UTTT extends Parent {
	public static boolean Three = false;
	
	public static BorderPane borderPane = new BorderPane();
	private char whoseTurn = 'X';
	private Zone[][] zone = new Zone[3][3];
	private Cell[][] cell =  new Cell[9][9];
	private Label lblStatus = new Label("X's turn to play");

	GridPane pane = new GridPane();
	GridPane pane2 = new GridPane();
	StackPane pane3 = new StackPane();
	
	public boolean zone1;
	public boolean zone2;
	public boolean zone3;
	public boolean zone4;
	public boolean zone5;
	public boolean zone6;
	public boolean zone7;
	public boolean zone8;
	public boolean zone9;
	
	public char zonec1;
	public char zonec2;
	public char zonec3;
	public char zonec4;
	public char zonec5;
	public char zonec6;
	public char zonec7;
	public char zonec8;
	public char zonec9;
	
	public UTTT() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				pane.add(zone[i][j] = new Zone(), j, i);
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				pane2.add(cell[i][j] = new Cell(), i, j);
		
		pane3.getChildren().addAll(pane, pane2);
			
		borderPane.setCenter(pane3); 
		borderPane.setBottom(lblStatus);
	}
	
	public static void setThree(boolean three) {
		Three = three;
		
	}

	public boolean isFull() {
		int k = 0;
		int l = 0;
		for (; k < 9; k++) {
			for (; l < 9; l++) {
				if (cell[k][l].getToken() == ' ')
					return false;
			}
		}
		return true;
	}
	
	public void isZoneWon(char token) {
		Zone[][] zoneSet = new Zone[3][3];
		for (int i = 0; i < 3; i++) 
			for (int j = 0; j < 3; j++)
				zoneSet[i][j] = new Zone();
		
		if (zone1 != true) {
			//zone 1-----------------------------------------------------------------------------------------------------------
			for (int i = 0; i < 3; i++)
				if (cell[i][0].getToken() == token && cell[i][1].getToken() == token && cell[i][2].getToken() == token) {
					zone1 = true;
					zonec1 = token;
					if (token == 'X')
						zone[0][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[0][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[0][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			for (int j = 0; j < 3; j++)
				if (cell[0][j].getToken() ==  token && cell[1][j].getToken() == token && cell[2][j].getToken() == token) {
					zone1 = true;
					zonec1 = token;
					if (token == 'X')
						zone[0][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[0][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[0][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			if (cell[0][0].getToken() == token  && cell[1][1].getToken() == token && cell[2][2].getToken() == token) {
				zone1 = true;
				zonec1 = token;
				if (token == 'X')
					zone[0][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[0][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[0][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
			if (cell[2][0].getToken() == token && cell[1][1].getToken() == token && cell[0][2].getToken() == token) {
				zone1 = true;
				zonec1 = token;
				if (token == 'X')
					zone[0][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[0][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[0][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
		}
		if (zone2 != true) {
			//zone 2-----------------------------------------------------------------------------------------------------------
			for (int i = 3; i < 6; i++)
				if (cell[i][0].getToken() == token && cell[i][1].getToken() == token && cell[i][2].getToken() == token) {
					zone2 = true;
					zonec2 = token;
					if (token == 'X')
						zone[0][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[0][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[0][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			for (int j = 0; j < 3; j++)
				if (cell[3][j].getToken() ==  token && cell[4][j].getToken() == token && cell[5][j].getToken() == token) {
					zone2 = true;
					zonec2 = token;
					if (token == 'X')
						zone[0][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[0][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[0][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			if (cell[3][0].getToken() == token && cell[4][1].getToken() == token && cell[5][0].getToken() == token) {
				zone2 = true;
				zonec2 = token;
				if (token == 'X')
					zone[0][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[0][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[0][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
			if (cell[3][2].getToken() == token && cell[4][1].getToken() == token && cell[5][2].getToken() == token) {
				zone2 = true;
				zonec2 = token;
				if (token == 'X')
					zone[0][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[0][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[0][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
		}
		if (zone3 != true) {
			//zone 3-----------------------------------------------------------------------------------------------------------
			for (int i = 6; i < 9; i++)
				if (cell[i][0].getToken() == token && cell[i][1].getToken() == token && cell[i][2].getToken() == token) {
					zone3 = true;
					zonec3 = token;
					if (token == 'X')
						zone[0][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[0][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[0][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			for (int j = 0; j < 3; j++)
				if (cell[6][j].getToken() ==  token && cell[7][j].getToken() == token && cell[8][j].getToken() == token) {
					zone3 = true;
					zonec3 = token;
					if (token == 'X')
						zone[0][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[0][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[0][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			if (cell[6][0].getToken() == token && cell[7][1].getToken() == token && cell[8][2].getToken() == token) {
				zone3 = true;
				zonec3 = token;
				if (token == 'X')
					zone[0][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[0][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[0][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
			if (cell[8][0].getToken() == token && cell[7][1].getToken() == token && cell[6][2].getToken() == token) {
				zone3 = true;
				zonec3 = token;
				if (token == 'X')
					zone[0][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[0][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[0][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
		}
		if (zone4 != true) {
			//zone 4-----------------------------------------------------------------------------------------------------------
			for (int i = 0; i < 3; i++)
				if (cell[i][3].getToken() == token && cell[i][4].getToken() == token && cell[i][5].getToken() == token) {
					zone4 = true;
					zonec4 = token;
					if (token == 'X')
						zone[1][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[1][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[1][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			for (int j = 3; j < 6; j++)
				if (cell[0][j].getToken() ==  token && cell[1][j].getToken() == token && cell[2][j].getToken() == token) {
					zone4 = true;
					zonec4 = token;
					if (token == 'X')
						zone[1][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[1][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[1][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			if (cell[0][3].getToken() == token  && cell[1][4].getToken() == token && cell[0][5].getToken() == token) {
				zone4 = true;
				zonec4 = token;
				if (token == 'X')
					zone[1][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[1][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[1][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
			if (cell[2][3].getToken() == token && cell[1][4].getToken() == token && cell[2][5].getToken() == token) {
				zone4 = true;
				zonec4 = token;
				if (token == 'X')
					zone[1][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[1][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[1][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
		}
		if (zone5 != true) {
			//zone 5-----------------------------------------------------------------------------------------------------------
			for (int i = 3; i < 6; i++)
				if (cell[i][3].getToken() == token && cell[i][4].getToken() == token && cell[i][5].getToken() == token) {
					zone5 = true;
					zonec5 = token;
					if (token == 'X')
						zone[1][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[1][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[1][1].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			for (int j = 3; j < 6; j++)
				if (cell[3][j].getToken() ==  token && cell[4][j].getToken() == token && cell[5][j].getToken() == token) {
					zone5 = true;
					zonec5 = token;
					if (token == 'X')
						zone[1][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[1][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[1][1].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			if (cell[3][3].getToken() == token && cell[4][4].getToken() == token && cell[5][5].getToken() == token) {
				zone5 = true;
				zonec5 = token;
				if (token == 'X')
					zone[1][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[1][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[1][1].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
			if (cell[5][3].getToken() == token && cell[4][4].getToken() == token && cell[3][5].getToken() == token) {
				zone5 = true;
				zonec5 = token;
				if (token == 'X')
					zone[1][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[1][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[1][1].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
		}
		if (zone6 != true) {
			//zone 6-----------------------------------------------------------------------------------------------------------
			for (int i = 6; i < 9; i++)
				if (cell[i][3].getToken() == token && cell[i][4].getToken() == token && cell[i][5].getToken() == token) {
					zone6 = true;
					zonec6 = token;
					if (token == 'X')
						zone[1][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[1][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[1][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			for (int j = 3; j < 6; j++)
				if (cell[6][j].getToken() ==  token && cell[7][j].getToken() == token && cell[8][j].getToken() == token) {
					zone6 = true;
					zonec6 = token;
					if (token == 'X')
						zone[1][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[1][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[1][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			if (cell[6][3].getToken() == token && cell[7][4].getToken() == token && cell[6][5].getToken() == token) {
				zone6 = true;
				zonec6 = token;
				if (token == 'X')
					zone[1][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[1][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[1][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
			if (cell[8][3].getToken() == token && cell[7][4].getToken() == token && cell[8][5].getToken() == token) {
				zone6 = true;
				zonec6 = token;
				if (token == 'X')
					zone[1][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[1][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[1][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
		}
		if (zone7 != true) {
			//zone 7-----------------------------------------------------------------------------------------------------------
			for (int i = 0; i < 3; i++)
				if (cell[i][6].getToken() == token && cell[i][7].getToken() == token && cell[i][8].getToken() == token) {
					zone7 = true;
					zonec7 = token;
					if (token == 'X')
						zone[2][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[2][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[2][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			for (int j = 6; j < 9; j++)
				if (cell[0][j].getToken() ==  token && cell[1][j].getToken() == token && cell[2][j].getToken() == token) {
					zone7 = true;
					zonec7 = token;
					if (token == 'X')
						zone[2][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[2][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[2][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			if (cell[0][6].getToken() == token  && cell[1][7].getToken() == token && cell[0][8].getToken() == token) {
				zone7 = true;
				zonec7 = token;
				if (token == 'X')
					zone[2][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[2][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[2][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
			if (cell[2][6].getToken() == token && cell[1][7].getToken() == token && cell[2][8].getToken() == token) {
				zone7 = true;
				zonec7 = token;
				if (token == 'X')
					zone[2][0].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[2][0].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[2][0].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
		}
		if (zone8 != true) {
			//zone 8-----------------------------------------------------------------------------------------------------------
			for (int i = 3; i < 6; i++)
				if (cell[i][6].getToken() == token && cell[i][7].getToken() == token && cell[i][8].getToken() == token) {
					zone8 = true;
					zonec8 = token;
					if (token == 'X')
						zone[2][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[2][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[2][1].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			for (int j = 6; j < 9; j++)
				if (cell[3][j].getToken() ==  token && cell[4][j].getToken() == token && cell[5][j].getToken() == token) {
					zone8 = true;
					zonec8 = token;
					if (token == 'X')
						zone[2][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[2][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[2][1].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			if (cell[3][6].getToken() == token && cell[4][7].getToken() == token && cell[3][8].getToken() == token) {
				zone8 = true;
				zonec8 = token;
				if (token == 'X')
					zone[2][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[2][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[2][1].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
			if (cell[5][6].getToken() == token && cell[4][7].getToken() == token && cell[5][8].getToken() == token) {
				zone8 = true;
				zonec8 = token;
				if (token == 'X')
					zone[2][1].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[2][1].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[2][1].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
		}
		if (zone9 != true) {
			//zone 9-----------------------------------------------------------------------------------------------------------
			for (int i = 6; i < 9; i++)
				if (cell[i][6].getToken() == token && cell[i][7].getToken() == token && cell[i][8].getToken() == token) {
					zone9 = true;
					zonec9 = token;
					if (token == 'X')
						zone[2][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[2][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[2][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			for (int j = 6; j < 9; j++)
				if (cell[6][j].getToken() ==  token && cell[7][j].getToken() == token && cell[8][j].getToken() == token) {
					zone9 = true;
					zonec9 = token;
					if (token == 'X')
						zone[2][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
					else if (token == 'O')
						zone[2][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
					else if (token == '⚫')
						zone[2][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
				}
			if (cell[6][6].getToken() == token && cell[7][7].getToken() == token && cell[6][8].getToken() == token) {
				zone9 = true;
				zonec9 = token;
				if (token == 'X')
					zone[2][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[2][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[2][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
			if (cell[8][6].getToken() == token && cell[7][7].getToken() == token && cell[8][8].getToken() == token) {
				zone9 = true;
				zonec9 = token;
				if (token == 'X')
					zone[2][2].setStyle("-fx-background-color: rgba(255, 0, 0, .5);");
				else if (token == 'O')
					zone[2][2].setStyle("-fx-background-color: rgba(0, 0, 255, .5);");
				else if (token == '⚫')
					zone[2][2].setStyle("-fx-background-color: rgba(0, 255, 0, .5);");
			}
		}
			//-----------------------------------------------------------------------------------------------------------------
	}
	
	public boolean isWon(char token) {
		if (zonec1 == token && zonec2 == token && zonec3 == token) {
			return true;
		}
		if (zonec4 ==token && zonec5 == token && zonec6 == token) {
			return true;
		}
		if (zonec7 == token && zonec8 == token && zonec9 == token) {
			return true;
		}
		if (zonec1 == token && zonec4 == token && zonec7 == token) {
			return true;
		}
		if (zonec2 == token && zonec5 == token && zonec8 == token) {
			return true;
		}
		if (zonec3 == token && zonec6 == token && zonec9 == token) {
			return true;
		}
		if (zonec1 == token && zonec5 == token && zonec9 == token) {
			return true;
		}
		if (zonec3 == token && zonec5 == token && zonec7 == token) {
			return true;
		}
		return false;
	}
	
	public class Zone extends Pane {
		public Zone() {
			setStyle("-fx-background-color: rgba(0, 100, 100, .4); -fx-background-radius: 10;");
			this.setPrefSize(2000, 2000);
		}
	}
	
	public class Cell extends Pane {
		private char token = ' ';

		public Cell() {
			setStyle("-fx-background-color: transparent; -fx-border-color: black"); 
			this.setPrefSize(2000, 2000);
			this.setOnMouseClicked(e -> handleMouseClick());
		}

		public char getToken() {
			return token;
		}

		public void setToken(char c) {
			token = c;

			if (token == 'X') {
				Line line1 = new Line(10, 10, this.getWidth() - 10, this.getHeight() - 10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				
				Line line2 = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
				line2.startYProperty().bind(this.heightProperty().subtract(10));
				line2.endXProperty().bind(this.widthProperty().subtract(10));

				this.getChildren().addAll(line1, line2); 
			}
			else if (token == 'O') {
				Ellipse ellipse = new Ellipse(this.getWidth() / 2, this.getHeight() / 2, this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
				ellipse.centerXProperty().bind(this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));        
				ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));   
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.WHITE);

				getChildren().add(ellipse);
			}
			else if (token == '⚫') {
				Ellipse ellipse = new Ellipse(this.getWidth() / 2, this.getHeight() / 2, this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
				ellipse.centerXProperty().bind(this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));        
				ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.BLACK);
				
				getChildren().addAll(ellipse);
			}
		}
		
		private void handleMouseClick() {
			
			if (token == ' ' && whoseTurn != ' ') {
				setToken(whoseTurn);
				
				isZoneWon(token);
				
				if (isWon(token)) {
					lblStatus.setText(whoseTurn + " won! The game is over");
					whoseTurn = ' ';
				}
				else if (isFull()) {
					lblStatus.setText("Draw! The game is over");
					whoseTurn = ' ';
				}
				else {
					if (Three == true) {
						if (whoseTurn == 'X')
							whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
						else if (whoseTurn == 'O')
							whoseTurn = (whoseTurn == 'O') ? '⚫' : 'O';
						else if (whoseTurn == '⚫')
							whoseTurn = (whoseTurn == '⚫') ? 'X' : '⚫';
						lblStatus.setText(whoseTurn + "'s turn");
					} else {
						if (whoseTurn == 'X')
							whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
						else if (whoseTurn == 'O')
							whoseTurn = (whoseTurn == 'O') ? 'X' : 'O';
						lblStatus.setText(whoseTurn + "'s turn");
					}
				}
			}
		}
	}
}