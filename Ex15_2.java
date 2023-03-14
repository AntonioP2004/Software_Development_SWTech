package Exercises15_1_2;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Ex15_2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Rectangle rectangle = new Rectangle(50, 75);
		rectangle.setFill(Color.RED);
		rectangle.setStroke(Color.BLACK);
		
		Polygon polygon = new Polygon();
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();
		
		double centerX = 400 / 2, centerY = 400 / 2;
		double radius = Math.min(400, 400) * 0.4;

		int s = 5;
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s));
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(polygon);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();

		polygon.setOnMousePressed(e -> pt.pause());
		polygon.setOnMouseReleased(e -> pt.play());
		
		FadeTransition ft = new FadeTransition(Duration.millis(3000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();

		rectangle.setOnMousePressed(e -> ft.pause());
		rectangle.setOnMouseReleased(e -> ft.play());
		
		pane.getChildren().clear();
		pane.getChildren().add(polygon);
		pane.getChildren().add(rectangle);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("ShowPolygon");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}