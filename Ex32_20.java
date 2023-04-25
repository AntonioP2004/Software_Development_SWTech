package Exercises32_17_20_22;

import javax.swing.JRadioButton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex32_20 extends Application{

	public void start(Stage primaryStage) {
		
	    TabPane tabPane1 = new TabPane();
	    Tab tab1 = new Tab("Line");
	    StackPane pane1 = new StackPane();
	    pane1.getChildren().add(new Line(10, 10, 80, 80));
	    tab1.setContent(pane1);
	    Tab tab2 = new Tab("Rectangle");
	    tab2.setContent(new Rectangle(10, 10, 200, 200));
	    Tab tab3 = new Tab("Circle");
	    tab3.setContent(new Circle(50, 50, 20));    
	    Tab tab4 = new Tab("Ellipse");
	    tab4.setContent(new Ellipse(10, 10, 100, 80));
	    tabPane1.getTabs().addAll(tab1, tab2, tab3, tab4);
	    
	    RadioButton top = new RadioButton("Top");
	    RadioButton bottom = new RadioButton("Bottom");
	    RadioButton left = new RadioButton("Left");
	    RadioButton right = new RadioButton("Right");
	    
	    BorderPane pane = new BorderPane();
	    HBox RB = new HBox(20);
	    RB.setPadding(new Insets(5, 5, 5, 5));
	    RB.setStyle("-fx-border-color: green");
	    RB.setStyle("-fx-border-width: 2px; -fx-border-color: green");
	    
	    ToggleGroup group = new ToggleGroup();
	    top.setToggleGroup(group);
	    bottom.setToggleGroup(group);
	    left.setToggleGroup(group);
	    right.setToggleGroup(group);
	    
	    top.setOnAction(e -> {
	    	tabPane1.setRotate(0);
	    });
	    bottom.setOnAction(e -> {
	    	tabPane1.setRotate(180);
	    });
	    left.setOnAction(e -> {
	    	tabPane1.setRotate(-90);
	    });
	    right.setOnAction(e -> {
	    	tabPane1.setRotate(90);
	    });

	    RB.getChildren().addAll(top, bottom, left, right);
	    pane.setCenter(tabPane1);
	    pane.setBottom(RB);
	    
	    Scene scene = new Scene(pane, 300, 250);  
	    primaryStage.setTitle("DisplayFigure"); // Set the window title
	    primaryStage.setScene(scene); // Place the scene in the window
	    primaryStage.show(); // Display the window
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}