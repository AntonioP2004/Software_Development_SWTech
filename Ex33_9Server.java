package Exercises31_1_9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex33_9Server extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
  
  DataInputStream inputFromClient = null;
  DataOutputStream outputToClient = null;
 
  @SuppressWarnings({ "deprecation", "unused" })
@Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws IOException {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    //taClient.setDisable(true);

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 200, 200);
    primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    taClient.setOnKeyPressed(event -> {
	  	if (event.getCode() == KeyCode.ENTER){
	  		String temp = taClient.getText();
	  		try {
	  			outputToClient.writeUTF(temp);
	  			outputToClient.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
	  		taServer.appendText("S: " + temp + "\n");
	  		taClient.clear();
	  	}
	});
	
    new Thread(() -> {
    	taServer.setWrapText(true);
    	//ServerSocket serverSocket;
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			Socket socket = serverSocket.accept();
			
			inputFromClient = new DataInputStream(
					socket.getInputStream());
			outputToClient = new DataOutputStream(
					socket.getOutputStream());
		
			taServer.appendText("Server started at " + new Date() + '\n');

			 while (true) {
				 String ClientMessage = inputFromClient.readUTF();
				 Platform.runLater(() -> {
					taServer.appendText("C: " + ClientMessage + "\n");
				 });
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}).start();
}

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
