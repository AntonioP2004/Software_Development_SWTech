package Exercises32_17_20_22;

/*
 * READ ME:
 * To save on time i reused the template for assignment 33_1.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex32_17 extends Application {
	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfNumOfYears = new TextField();
	private TextField tfInvestmentAmount = new TextField();
	private Button btCalc= new Button("Calculate");
	private TextArea ta = new TextArea();
	
	public void start(Stage primaryStage) {
		ta.setWrapText(true);
		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Annual Interest Rate"), 0, 0);
		gridPane.add(new Label("Number Of Years"), 0, 1);
		gridPane.add(new Label("Investment Amount"), 0, 2);
		gridPane.add(tfAnnualInterestRate, 1, 0);
		gridPane.add(tfNumOfYears, 1, 1);
		gridPane.add(tfInvestmentAmount, 1, 2);
		gridPane.add(btCalc, 2, 1);
		        
		BorderPane pane = new BorderPane();
		pane.setCenter(new ScrollPane(ta));
		pane.setTop(gridPane);
		
		Scene scene = new Scene(pane, 400, 250);
		primaryStage.setTitle("Ex32_17");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(() -> {
			while(true) {
				btCalc.setOnAction(e -> {
					ta.clear();
					
					double Investment = Double.parseDouble(tfInvestmentAmount.getText().trim());
					double NumOfYears = Double.parseDouble(tfNumOfYears.getText().trim());
					double AnnualRate = Double.parseDouble(tfAnnualInterestRate.getText().trim());
					
					System.out.println(Investment);
					System.out.println(NumOfYears);
					System.out.println(AnnualRate);
					
					double S = Investment * Math.pow((1 + AnnualRate / 97.41), NumOfYears);
					
					ta.appendText("Investment after " + NumOfYears + " years will be: " + S);
				});
			}
		}).start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
