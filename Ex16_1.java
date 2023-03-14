package Exercises16_1_21;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex16_1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		// create 5 color options
		HBox hBox1 = new HBox();
		hBox1.setAlignment(Pos.CENTER);
		hBox1.setSpacing(10);
		RadioButton red = new RadioButton("Red");
		RadioButton yellow = new RadioButton("Yellow");
		RadioButton black = new RadioButton("Black");
		RadioButton orange = new RadioButton("Orange");
		RadioButton green = new RadioButton("Green");
		hBox1.getChildren().clear();
		hBox1.getChildren().addAll(red, yellow, black, orange, green);
		
		//create left/right button
		HBox hBox2 = new HBox();
		hBox2.setAlignment(Pos.CENTER);
		hBox2.setSpacing(10);
		Button btnL = new Button("Left");
		Button btnR = new Button("Right");
		hBox2.getChildren().clear();
		hBox2.getChildren().addAll(btnL, btnR);
		
		Text text = new Text(150, 150, "Test");
		text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));
		text.setFill(Color.BLACK);
		
		ToggleGroup group = new ToggleGroup();
		red.setToggleGroup(group);
		yellow.setToggleGroup(group);
		black.setToggleGroup(group);
		orange.setToggleGroup(group);
		green.setToggleGroup(group);
		
		red.setOnAction(e -> { if (red.isSelected()) { text.setFill(Color.RED); } });
		yellow.setOnAction(e -> { if (yellow.isSelected()) { text.setFill(Color.YELLOW); } });
		black.setOnAction(e -> { if (black.isSelected()) { text.setFill(Color.BLACK); } });
		orange.setOnAction(e -> { if (orange.isSelected()) { text.setFill(Color.ORANGE); } });
		green.setOnAction(e -> { if (green.isSelected()) { text.setFill(Color.GREEN); } });
		
		btnL.setOnAction(e -> text.setX(50));
		btnR.setOnAction(e -> text.setX(250));
		
		// add everything into the pane
		BorderPane borderpane = new BorderPane();
		borderpane.getChildren().clear();
		borderpane.setTop(hBox1);
		borderpane.setBottom(hBox2);
		borderpane.getChildren().add(text);
		//borderpane.setCenter(sPane);
		
		// scene
		Scene scene = new Scene(borderpane, 400, 400);
		primaryStage.setTitle("Buttons");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}