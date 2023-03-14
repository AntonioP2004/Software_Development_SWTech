package Exercises15_1_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Ex15_1 extends Application {
    @Override
    public void start(Stage primaryStage) {
    	Pane pane = new Pane();
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btnU = new Button("Up");
		Button btnD = new Button("Down");
		Button btnL = new Button("Left");
		Button btnR = new Button("Right");
		
		pane.getChildren().clear();
		hBox.getChildren().clear();
		pane.getChildren().add(circlePane.getCircle());
		hBox.getChildren().addAll(btnU, btnD, btnL, btnR);
		
		btnL.setOnAction(new CircleLeft());
		btnR.setOnAction(new CircleRight());
		btnD.setOnAction(new CircleDown());
		btnU.setOnAction(new CircleUp());
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(hBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);
    	
    	Scene scene = new Scene(borderPane, 400, 400);
	      primaryStage.setTitle("MoveTheBall");
	      primaryStage.setScene(scene);
	      primaryStage.show();
    }
}
    
class CircleLeft implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
			circlePane.Left();
	}
}
class CircleRight implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
			circlePane.Right();
	}
}
class CircleDown implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
			circlePane.Down();
	}
}
class CircleUp implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
			circlePane.Up();
	}
}
    	
class circlePane extends StackPane {
	private static Circle circle = new Circle(200, 200, 50); 
	
	public void CirclePane() {
		getCircle().setFill(Color.RED);
		getCircle().setStroke(Color.BLACK);
	}
	
    public static void Left() {
    	if (!((circle.getCenterX() - 50) < 0)) circle.setCenterX(circle.getCenterX() - 50);
    }
    public static void Right() {
    	if (!((circle.getCenterX() + 50) > 400)) circle.setCenterX(circle.getCenterX() + 50);
    }
    public static void Down() {
    	if (!((circle.getCenterY() + 50) > 400)) circle.setCenterY(circle.getCenterY() + 50);
    }
    public static void Up() {
    	if (!((circle.getCenterY() - 50) < 0)) circle.setCenterY(circle.getCenterY() - 50);
    }
	public static Circle getCircle() {
		return circle;
	}
	public static void setCircle(Circle circle) {
		circlePane.circle = circle;
	}
}