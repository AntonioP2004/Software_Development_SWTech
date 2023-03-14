package Exercises16_1_21;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex16_21 extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane borderpane = new BorderPane();
		Scene scene = new Scene(borderpane, 200, 50);
		
		MediaPlayer media = new MediaPlayer(new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3"));
		
		String j = "-1";
		TextField tfMessage = new TextField(j);
		tfMessage.setAlignment(Pos.CENTER);
		tfMessage.setEditable(true);
		tfMessage.setStyle("-fx-text-fill: red");
		tfMessage.setFont(Font.font("Times", 20)); 
		tfMessage.setAlignment(Pos.BASELINE_CENTER);
		borderpane.setCenter(tfMessage);
		
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
			try {
				String timer = tfMessage.getText();
				if (!(timer.equals("0"))) {
					String i = j;
					int q = Integer.parseInt(tfMessage.getText());
					q--;
					i = String.valueOf(q);
					tfMessage.setText(i);
				} else {
					media.play();
				}
			} catch (NumberFormatException ex){
				ex.printStackTrace();
		    }
		}) );
					
		int o = Integer.parseInt(tfMessage.getText());
		
		scene.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode().equals(KeyCode.ENTER)) {
				animation.setCycleCount(o);
				 animation.play();
			}
		});
		
		primaryStage.setTitle("CountDown");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}