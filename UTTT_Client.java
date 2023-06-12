package UTTT_V_4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UTTT_Client extends Application{
	static DataOutputStream toServer = null;
	static DataInputStream fromServer = null;
	static int maxNumberOfPlayers = 2;
	static String TokenPlayerTTT;
	static String TOKENPlayer11;
	static String TOKENPlayer21;
	static String TokenPlayerUTTT;
	static String TOKENPlayer12;
	static String TOKENPlayer22;
	static String TOKENPlayer13;
	static String TOKENPlayer23;
	static String TOKENPlayer33;
	static boolean gameIsOnline = false;
	static Socket socket;
	static int getGameSize = 1;
	static int i;
	static int turn;
	
	/*
	 * primary method for program.
	 */
	@Override
	public void start(Stage primaryStage) throws UnknownHostException, IOException {
		BorderPane Menu = new BorderPane();
		BorderPane infoPane = new BorderPane();
		BorderPane TTTselectPane = new BorderPane();
		BorderPane UTTTselectPane = new BorderPane();
		BorderPane TTTtokenPane = new BorderPane();
		BorderPane UTTTtokenPane = new BorderPane();
		BorderPane TTTofflinePane = new BorderPane();
		BorderPane UTTTofflinePane1 = new BorderPane();
		BorderPane UTTTofflinePane2 = new BorderPane();
		BorderPane UTTTofflinePane3 = new BorderPane();
		BorderPane loadingPane = new BorderPane();
		
		Scene MainMenu = new Scene(Menu, 350, 75);
		Scene info = new Scene(infoPane, 385, 210);
		Scene TTTselect = new Scene(TTTselectPane, 350, 75);
		Scene UTTTselect = new Scene(UTTTselectPane, 350, 75);
		Scene TTTtoken = new Scene(TTTtokenPane, 350, 75);
		Scene UTTTtoken = new Scene(UTTTtokenPane, 350, 75);
		Scene TTTofflineTokens = new Scene(TTTofflinePane, 350, 150);
		Scene UTTTofflineplayers = new Scene(UTTTofflinePane1, 350, 75);
		Scene UTTTofflineTokens2players = new Scene(UTTTofflinePane2, 350, 150);
		Scene UTTTofflineTokens3players = new Scene(UTTTofflinePane3, 350, 200);
		Scene LoadingScreen = new Scene(loadingPane, 350, 75);
		
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
		
		Label loadingMSG = new Label("Waiting for other players...");
		VBox loadingVBox = new VBox();
		loadingVBox.getChildren().add(loadingMSG);
		loadingPane.setCenter(loadingVBox);
		
		// Labels for TTT
		Label TTTselectInfo = new Label("Please select a game type.");
		TTTselectInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		TTTselectInfo.setTextFill(Color.BLACK);
		Label TTTtokenInfo = new Label("Please enter your prefered token.");
		TTTselectInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		TTTselectInfo.setTextFill(Color.BLACK);
		Label TTTofflineTokeninfo = new Label("Please X or O for player 1 and player 2.");
		TTTofflineTokeninfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		TTTofflineTokeninfo.setTextFill(Color.BLACK);
		Label TTTofflineTokeninfoPlayer1 = new Label("Player 1: ");
		TTTofflineTokeninfoPlayer1.setFont(Font.font("Times New Roman", 10));
		TTTofflineTokeninfoPlayer1.setTextFill(Color.BLACK);
		Label TTTofflineTokeninfoPlayer2 = new Label("Player 2: ");
		TTTofflineTokeninfoPlayer2.setFont(Font.font("Times New Roman", 10));
		TTTofflineTokeninfoPlayer2.setTextFill(Color.BLACK);
		
		// Labels for UTTT
		Label UTTTselectInfo = new Label("Please select a game type.");
		UTTTselectInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		UTTTselectInfo.setTextFill(Color.BLACK);
		Label UTTTtokenInfo = new Label("Please enter your prefered token (X or O).");
		UTTTselectInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		UTTTselectInfo.setTextFill(Color.BLACK);
		Label UTTTTokenplayerNumSel = new Label("Please select the number of players.");
		UTTTTokenplayerNumSel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		UTTTTokenplayerNumSel.setTextFill(Color.BLACK);
		Label UTTTofflineTokenSelInfo = new Label("Please select your Tokens (X, O, or ⚫).");
		UTTTofflineTokenSelInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		UTTTofflineTokenSelInfo.setTextFill(Color.BLACK);
		Label UTTTofflineTokenSelInfo2 = new Label("Please select your Tokens (X, O, or ⚫).");
		UTTTofflineTokenSelInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		UTTTofflineTokenSelInfo.setTextFill(Color.BLACK);
		Label UTTTofflineTokeninfoP1 = new Label("Player 1: ");
		UTTTofflineTokeninfoP1.setFont(Font.font("Times New Roman", 10));
		UTTTofflineTokeninfoP1.setTextFill(Color.BLACK);
		Label UTTTofflineTokeninfoP2 = new Label("Player 2: ");
		UTTTofflineTokeninfoP2.setFont(Font.font("Times New Roman", 10));
		UTTTofflineTokeninfoP2.setTextFill(Color.BLACK);
		Label UTTTofflineTokeninfoP3 = new Label("Player 3: ");
		UTTTofflineTokeninfoP3.setFont(Font.font("Times New Roman", 10));
		UTTTofflineTokeninfoP3.setTextFill(Color.BLACK);
		Label UTTTofflineTokeninfoP12 = new Label("Player 1: ");
		UTTTofflineTokeninfoP1.setFont(Font.font("Times New Roman", 10));
		UTTTofflineTokeninfoP1.setTextFill(Color.BLACK);
		Label UTTTofflineTokeninfoP22 = new Label("Player 2: ");
		UTTTofflineTokeninfoP2.setFont(Font.font("Times New Roman", 10));
		UTTTofflineTokeninfoP2.setTextFill(Color.BLACK);
		
		// TextFields for TTT
		TextField TTTtekenInputOnline = new TextField("X");
		TextField TTTtokenOffline1 = new TextField("X");
		TextField TTTtokenOffline2 = new TextField("X");
		
		// TextFields for UTTT
		TextField UTTTtokenInputOnline = new TextField("X");
		TextField UTTTtokenOffline12 = new TextField("X");
		TextField UTTTtokenOffline22 = new TextField("X");
		TextField UTTTtokenOffline1 = new TextField("X");
		TextField UTTTtokenOffline2 = new TextField("X");
		TextField UTTTtokenOffline3 = new TextField("X");
		
		//Buttons for main menu and info tab
		Button TT = new Button("Tic-Tac-Toe");
		Button UTT= new Button("Ultimate Tic-Tac-Toe");
		Button infoButton = new Button("Rules and Info");
		Button infoBack = new Button("Back");
		
		//Buttons under TTT
		Button TTTback = new Button("Back");
		Button TTToffline = new Button("Offline");
		Button TTTonline = new Button("Online");
		Button TTTonlinePlay = new Button("Play!");
		Button TTTtokenBack = new Button("Back");
		Button TTTofflinePlay = new Button("Play!");
		Button TTTofflineBack = new Button("Back");
		
		//Buttons underUTTT
		Button UTTT2players = new Button("2 Players");
		Button UTTT3players = new Button("3 Players");
		Button UTTT2or3Back = new Button("Back");
		Button UTTTback = new Button("Back");
		Button UTTToffline = new Button("Offline");
		Button UTTTonline = new Button("Online");
		Button UTTToffline2Players = new Button("2 players");
		Button UTTToffline3Players = new Button("3 players");
		Button UTTToffline2or3PlayersBack = new Button("Back");
		Button UTTTofflinePlay2 = new Button("Play!");
		Button UTTTofflinePlay3 = new Button("Play!");
		Button UTTTofflineBack2 = new Button("back");
		Button UTTTofflineBack3 = new Button("back");
		
		//Main menu
		HBox topPane = new HBox();
		topPane.getChildren().addAll(Title);
		topPane.setAlignment(Pos.CENTER);
		HBox bottomPane = new HBox();
		bottomPane.getChildren().addAll(TT, UTT, infoButton);
		bottomPane.setSpacing(10);
		bottomPane.setAlignment(Pos.CENTER);
		
		// Info tab stuff
		HBox infoCenterPane = new HBox();
		infoCenterPane.getChildren().add(infoLabel);
		HBox infoBottomPane = new HBox();
		infoBottomPane.getChildren().add(infoBack);
		Menu.setTop(topPane);
		Menu.setBottom(bottomPane);
		infoPane.setCenter(infoLabel);
		infoPane.setBottom(infoBack);
		
		// Token set for TTT
		// select game type for TTT
		HBox TTTselectHBox = new HBox();
		TTTselectHBox.getChildren().addAll(TTTback, TTToffline, TTTonline);
		TTTselectHBox.setSpacing(10);
		TTTselectHBox.setAlignment(Pos.CENTER);
		// label for selecting game type of TTT
		HBox TTTselectInfoHBox = new HBox();
		TTTselectInfoHBox.getChildren().add(TTTselectInfo);
		TTTselectInfoHBox.setAlignment(Pos.CENTER);
		TTTselectPane.setTop(TTTselectInfoHBox);
		TTTselectPane.setCenter(TTTselectHBox);
		// back button in token selection for TTT
		HBox TTTtokenBackT = new HBox();
		TTTtokenBackT.getChildren().addAll(TTTonlinePlay, TTTtokenBack);
		// setup for token page in TTT ONLINE
		VBox TTTtokenVBox = new VBox();
		TTTtokenVBox.getChildren().addAll(TTTtokenInfo, TTTtekenInputOnline);
		TTTtokenPane.setCenter(TTTtokenVBox);
		TTTtokenPane.setBottom(TTTtokenBackT);
		TTTtokenVBox.setAlignment(Pos.CENTER);
		TTTtokenBackT.setAlignment(Pos.CENTER);
		// setup for TTT offline tokens
		VBox TTTofflineTokenSel = new VBox();
		TTTofflineTokenSel.getChildren().addAll(TTTofflineTokeninfo, TTTofflineTokeninfoPlayer1, TTTtokenOffline1, TTTofflineTokeninfoPlayer2, TTTtokenOffline2);
		TTTofflineTokenSel.setAlignment(Pos.CENTER);
		HBox TTTofflineTokenSelButtons = new HBox();
		TTTofflineTokenSelButtons.getChildren().addAll(TTTofflinePlay, TTTofflineBack);
		TTTofflineTokenSelButtons.setAlignment(Pos.CENTER);
		TTTofflineTokenSelButtons.setSpacing(10);
		TTTofflinePane.setCenter(TTTofflineTokenSel);
		TTTofflinePane.setBottom(TTTofflineTokenSelButtons);
		
		// Token set for UTTT
		// select game type for UTTT
		HBox UTTTselectHBox = new HBox();
		UTTTselectHBox.getChildren().addAll(UTTTback, UTTToffline, UTTTonline);
		UTTTselectHBox.setSpacing(10);
		UTTTselectHBox.setAlignment(Pos.CENTER);
		// label for selecting game type of UTTT
		HBox UTTTselectInfoHBox = new HBox();
		UTTTselectInfoHBox.getChildren().add(UTTTselectInfo);
		UTTTselectInfoHBox.setAlignment(Pos.CENTER);
		UTTTselectPane.setTop(UTTTselectInfoHBox);
		UTTTselectPane.setCenter(UTTTselectHBox);
		// back button in token selection for UTTT
		HBox UTTT2or3Players = new HBox();
		UTTT2or3Players.getChildren().addAll(UTTT2players, UTTT3players, UTTT2or3Back);
		UTTT2or3Players.setSpacing(10);
		// setup for token page in UTTT ONLINE
		VBox UTTTtokenVBox = new VBox();
		UTTTtokenVBox.getChildren().addAll(UTTTtokenInfo, UTTTtokenInputOnline);
		UTTTtokenPane.setCenter(UTTTtokenVBox);
		UTTTtokenPane.setBottom(UTTT2or3Players);
		UTTTtokenVBox.setAlignment(Pos.CENTER);
		UTTT2or3Players.setAlignment(Pos.CENTER);
		// UTTT offline players # select
		VBox UTTTofflinePlaSel = new VBox();
		UTTTofflinePlaSel.getChildren().add(UTTTTokenplayerNumSel);
		HBox UTTTofflinePlaSelButtons = new HBox();
		UTTTofflinePlaSelButtons.getChildren().addAll(UTTToffline2Players, UTTToffline3Players, UTTToffline2or3PlayersBack);
		UTTTofflinePane1.setCenter(UTTTofflinePlaSel);
		UTTTofflinePane1.setBottom(UTTTofflinePlaSelButtons);
		UTTTofflinePlaSelButtons.setAlignment(Pos.CENTER);
		UTTTofflinePlaSel.setAlignment(Pos.CENTER);
		UTTTofflinePlaSelButtons.setSpacing(10);
		// UTTT offline player token selection 2 players
		VBox UTTTofflineTokens = new VBox();
		UTTTofflineTokens.getChildren().addAll(UTTTofflineTokenSelInfo2, UTTTofflineTokeninfoP12, UTTTtokenOffline12, UTTTofflineTokeninfoP22, UTTTtokenOffline22);
		HBox UTTTofflineTokensButtons = new HBox();
		UTTTofflineTokensButtons.getChildren().addAll(UTTTofflinePlay2, UTTTofflineBack2);
		UTTTofflineTokens.setAlignment(Pos.CENTER);
		UTTTofflineTokensButtons.setAlignment(Pos.CENTER);
		UTTTofflineTokensButtons.setSpacing(10);
		UTTTofflinePane2.setCenter(UTTTofflineTokens);
		UTTTofflinePane2.setBottom(UTTTofflineTokensButtons);
		// UTTT offline player token selection 3 players
		VBox UTTTofflineTokens3 = new VBox();
		UTTTofflineTokens3.getChildren().addAll(UTTTofflineTokenSelInfo, UTTTofflineTokeninfoP1, UTTTtokenOffline1, UTTTofflineTokeninfoP2, UTTTtokenOffline2, UTTTofflineTokeninfoP3, UTTTtokenOffline3);
		HBox UTTTofflineTokens3Buttons = new HBox();
		UTTTofflineTokens3Buttons.getChildren().addAll(UTTTofflinePlay3, UTTTofflineBack3);
		UTTTofflineTokens3.setAlignment(Pos.CENTER);
		UTTTofflineTokens3Buttons.setAlignment(Pos.CENTER);
		UTTTofflineTokens3Buttons.setSpacing(10);
		UTTTofflinePane3.setCenter(UTTTofflineTokens3);
		UTTTofflinePane3.setBottom(UTTTofflineTokens3Buttons);
		
		// Buttons for info tab
		infoButton.setOnAction(e -> { primaryStage.setScene(info); });
		infoBack.setOnAction(e -> { primaryStage.setScene(MainMenu); });
		
		// Buttons for TTT
		TT.setOnAction(e -> { primaryStage.setScene(TTTselect); });
		TTTback.setOnAction(e -> { primaryStage.setScene(MainMenu); });
		TTToffline.setOnAction(e -> { primaryStage.setScene(TTTofflineTokens); });
		TTTofflineBack.setOnAction(e -> { primaryStage.setScene(TTTselect); });
		TTTonline.setOnAction(e -> { primaryStage.setScene(TTTtoken); });
		TTTtokenBack.setOnAction(e -> { primaryStage.setScene(TTTselect); });
		
		// Buttons for UTTT
		UTT.setOnAction(e -> { primaryStage.setScene(UTTTselect); });
		UTTTback.setOnAction(e -> { primaryStage.setScene(MainMenu); });
		UTTToffline.setOnAction(e -> { primaryStage.setScene(UTTTofflineplayers); });
		UTTToffline2or3PlayersBack.setOnAction(E -> { primaryStage.setScene(UTTTselect); });
		UTTTonline.setOnAction(e -> { primaryStage.setScene(UTTTtoken); });
		UTTT2or3Back.setOnAction(e -> { primaryStage.setScene(UTTTselect); });
		UTTToffline2Players.setOnAction(e -> { primaryStage.setScene(UTTTofflineTokens2players); });
		UTTTofflineBack2.setOnAction(e -> { primaryStage.setScene(UTTTofflineplayers); });
		UTTToffline3Players.setOnAction(e -> { primaryStage.setScene(UTTTofflineTokens3players); });
		UTTTofflineBack3.setOnAction(e -> { primaryStage.setScene(UTTTofflineplayers); });
		
		
		
		TTTonlinePlay.setOnAction(event -> {
			if (TTTtekenInputOnline.getText() != "") {
				gameIsOnline = true;
				TokenPlayerTTT = TTTtekenInputOnline.getText();
				TOKENPlayer11 = TokenPlayerTTT;
				TOKENPlayer21 = TTTtokenOffline2.getText();
				primaryStage.setScene(LoadingScreen);
				new Thread(() -> {
					try {
						ConnectToServer();
						System.out.println("Connected to server");
						for (int currentNumberPlayers = fromServer.readInt(); currentNumberPlayers < maxNumberOfPlayers;) {
							currentNumberPlayers = fromServer.readInt();
						}
						String j = "";
						System.out.println("all players connected");
						
						turn = fromServer.readInt();
						do {
							if (turn == 1) {
								toServer.writeUTF(TOKENPlayer11);
								j = fromServer.readUTF();
							} else if (turn == 2) {
								j = fromServer.readUTF();
								toServer.writeUTF(TOKENPlayer11);
							}
							TOKENPlayer21 = j;
						}while (j.length() == 0 || j.charAt(0) == 0);
						toServer.flush();
						
						System.out.println("you are " + TOKENPlayer11);
						System.out.println("they are " + TOKENPlayer21);
						
						Platform.runLater(() -> {
							TTT ticTacToe = new TTT();
							TTT.online = true;
							
					 		@SuppressWarnings("static-access")
							Scene sceneTTT = new Scene(ticTacToe.borderPane, 400, 400);
							primaryStage.setScene(sceneTTT);
						});
					} catch (IOException e1) {
						e1.printStackTrace();
						try {
							socket.close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
				}).start();
			}
		});
		UTTT2players.setOnAction(e -> {
			
		});
		UTTT3players.setOnAction(e -> {
			
		});
		
		primaryStage.setTitle("Ultimate Tic-Tac-Toe");
		primaryStage.setScene(MainMenu);
		primaryStage.show();
	}
	
	public static void ConnectToServer() throws IOException {
		socket = new Socket("LocalHost", 8007);
	    fromServer = new DataInputStream(socket.getInputStream());
	    toServer = new DataOutputStream(socket.getOutputStream());
	}
	
	public static boolean checkForPlayers() throws IOException {
		if (fromServer.readInt() == maxNumberOfPlayers) {
			return true;
		}
		return false;
	}
	
	public static void main(java.lang.String[] args) {
		launch(args);
	}
	@SuppressWarnings("serial")
	static class TTT extends Parent implements Serializable{
		public static  BorderPane borderPane = new BorderPane();
		static public boolean online = true;
		private static char whoseTurn;
		private static Cell[][] cell =  new Cell[3][3];
		private static Label lblStatus = new Label(TOKENPlayer11 + "'s turn to play");
		static GridPane pane = new GridPane();
		static int getCell = 0;
		
		public TTT() {
			try {
				if (turn == 2) {
					whoseTurn = TOKENPlayer21.toString().charAt(0);
					lblStatus.setText(whoseTurn + "'s turn (Other players turn)");
				}
				if (turn == 1) {
					whoseTurn = TOKENPlayer11.toString().charAt(0);
					lblStatus.setText(whoseTurn + "'s turn (Your turn)");
				}
				
				for (int i = 0; i < 3 ; i++) {
					for (int j = 0; j < 3; j++) {
						getCell++;
						pane.add(cell[i][j] = new Cell(), i, j);
					}
				}
				
				new Thread(() -> {
					while (true) {
						if (turn == 1) {
							pane.setDisable(false);
						} else if (turn == 2) {
							pane.setDisable(true);
						}
					}
				}).start();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			borderPane.setCenter(pane); 
			borderPane.setBottom(lblStatus);
		}
		
		public static void getCell() throws IOException {
			int getFinalCell = fromServer.readInt();
			Platform.runLater(() -> {
				try {
					if (getFinalCell == cell[0][0].finalCell) {
						cell[0][0].handleMouseClick(getFinalCell);
			    	} else if (getFinalCell == cell[0][1].finalCell) {
			    		cell[0][1].handleMouseClick(getFinalCell);
			    	} else if (getFinalCell == cell[0][2].finalCell) {
			    		cell[0][2].handleMouseClick(getFinalCell);
			    	} else if (getFinalCell == cell[1][0].finalCell) {
			    		cell[1][0].handleMouseClick(getFinalCell);
			    	} else if (getFinalCell == cell[1][1].finalCell) {
			    		cell[1][1].handleMouseClick(getFinalCell);
			    	} else if (getFinalCell == cell[1][2].finalCell) {
			    		cell[1][2].handleMouseClick(getFinalCell);
			    	} else if (getFinalCell == cell[2][0].finalCell) {
			    		cell[2][0].handleMouseClick(getFinalCell);
			    	} else if (getFinalCell == cell[2][1].finalCell) {
			    		cell[2][1].handleMouseClick(getFinalCell);
			    	} else if (getFinalCell == cell[2][2].finalCell) {
			    		cell[2][2].handleMouseClick(getFinalCell);
			    	}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}

		public static boolean isFull() {
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++)
					if (cell[i][j].getToken() == ' ')
						return false;
			return true;
		}

		public static boolean isWon(char token) throws IOException {
			try {
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
			} catch(NullPointerException e) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						cell[i][j] = new Cell();
					}
				}
			}
			return false;
		}

		public static class Cell extends Pane implements Serializable {
			private static final long serialVersionUID = 1L;
			private char token = ' ';
			int finalCell = getCell;

			@SuppressWarnings("unchecked")
			public Cell() throws IOException {
				setStyle("-fx-border-color: black"); 
				pane.setPadding(new Insets(10));
				pane.setHgap(10);
	            pane.setVgap(10);
				this.setPrefSize(2000, 2000);
				System.out.println(finalCell);
				new Thread(() -> {
			        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			            public void handle(MouseEvent event) {
			                try {
			                    handleMouseClick(finalCell);
			                    System.out.println("Sending " + finalCell);
			                    toServer.writeInt(finalCell);
			                    toServer.flush();
			                    turn = 2;
			                } catch (Exception e) {
			                    e.printStackTrace();
			                }
			            }
			        });
				}).start();
				
				new Thread(() -> {
					
						try {
							getCell();
							turn = 1;
						} catch (IOException e) {
							e.printStackTrace();
						}
				}).start();
			}

			public char getToken() {
				return this.token;
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
			
			private void handleMouseClick(int getFinalCell) throws IOException {
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
						if(whoseTurn == TOKENPlayer21.toString().charAt(0)){
							whoseTurn = TOKENPlayer11.toString().charAt(0);
						}
						else {
							whoseTurn = TOKENPlayer21.toString().charAt(0);
						}
						lblStatus.setText(whoseTurn + "'s turn");
					}
				}
			}
		}
	}
}

	class UTTT extends Parent {
		public boolean Three = false;
		
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
		
		public void setThree(boolean three) {
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