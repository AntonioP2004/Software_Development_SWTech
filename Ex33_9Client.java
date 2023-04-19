package Exercises31_1_9;

import javafx.application.Application;
import javafx.application.Platform;

import static javafx.application.Application.launch;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex33_9Client extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
 
  DataOutputStream toServer = null;
  DataInputStream fromServer = null;
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws IOException {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    //taServer.setDisable(true);

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
    primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    taClient.setOnKeyPressed(event -> {
  	  if (event.getCode() == KeyCode.ENTER){
  		   String temp = taClient.getText();
  			try {
  				toServer.writeUTF(temp);
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  			taServer.appendText("C: " + temp + "\n");
  			taClient.clear();
  	  }
  	});
    
    try {
    	Socket socket = new Socket("LocalHost", 8000);
	     fromServer = new DataInputStream(socket.getInputStream());
	     toServer = new DataOutputStream(socket.getOutputStream());
    
    new Thread(() -> {
	    try {
		   while (true) {
			   String ServerMessage = fromServer.readUTF();
			   taServer.appendText("S: " + ServerMessage + "\n");
			}
	    }
	   catch (IOException ex) {
	     ex.printStackTrace();
	   }
  }).start();
  }
    catch (IOException ex) {
	     taServer.appendText(ex.toString() + '\n');
	   }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}