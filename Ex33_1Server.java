package Exercises31_1_9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//Exercise31_01Server.java: The server can communicate with
//multiple clients concurrently using the multiple threads
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Ex33_1Server extends Application {
// Text area for displaying contents
private TextArea ta = new TextArea();

@Override // Override the start method in the Application class
public void start(Stage primaryStage) throws IOException {

	 // Create a scene and place it in the stage
	 Scene scene = new Scene(new ScrollPane(ta), 400, 200);
	 primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
	 primaryStage.setScene(scene); // Place the scene in the stage
	 primaryStage.show(); // Display the stage
	 
	new Thread(() -> {
		 ta.setWrapText(true);
		 try {
			ServerSocket serverSocket = new ServerSocket(8000);
			Platform.runLater(() ->
				ta.appendText("Server started at " + new Date() + '\n'));
				
				Socket socket = serverSocket.accept();
				
				DataInputStream inputFromClient = new DataInputStream(
						socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(
						socket.getOutputStream());
				
				while (true) {
					double tfAnnualInterestRate = inputFromClient.readDouble();
					double tfNumOfYears = inputFromClient.readDouble();
					double tfLoanAmount = inputFromClient.readDouble();
					
					Loan.setAnnualInterestRate(tfAnnualInterestRate);
					Loan.setNumberOfYears(tfNumOfYears);
					Loan.setLoanAmount(tfLoanAmount);
					
					outputToClient.writeDouble(Loan.getMonthlyPayment());
					outputToClient.writeDouble(Loan.getTotalPayment());
				
				Platform.runLater(() -> {
					ta.appendText("AIR received from client: " + tfAnnualInterestRate + '\n');
					ta.appendText("Number of Years received from client: " + tfNumOfYears + '\n');
					ta.appendText("Loan Amount received from client: " + tfLoanAmount + '\n');
					
					ta.appendText("Monthly Payment is: " + Loan.getMonthlyPayment() + '\n'); 
					ta.appendText("Loan Total is: " + Loan.getTotalPayment() + '\n'); 
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