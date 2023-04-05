package Exercises30_3_13;

import javafx.animation.PathTransition; 
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex30_3 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
		
		ImageView imageView = new ImageView("http://i.infopls.com/images/americanflag3.gif");
 		pane.getChildren().add(imageView);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					PathTransition pt = new PathTransition(Duration.millis(10000),
							new Line(100, 200, 100, 0), imageView); pt.setCycleCount(5);
			     
					pt.play();
			               
					Thread.sleep(200);
				}
				catch (InterruptedException ex) {
				}
			}
		}).start();
		
		
		Scene scene = new Scene(pane, 250, 200); 
		primaryStage.setTitle("FlagRisingAnimation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}