package Exercises21_7_9_11;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex21_11 extends Application {
  @SuppressWarnings("unchecked")
public Map<String, Integer>[] mapForBoy = new HashMap[10];
@SuppressWarnings("unchecked")
public Map<String, Integer>[] mapForGirl = new HashMap[10];
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  
  @SuppressWarnings({ "unlikely-arg-type" })
@Override
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);

    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    int year;
    for (year = 2001; year <= 2010; year++) {
    	cboYear.getItems().add(year);
	  	try {
	  		URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + (year) + ".txt");
				Scanner input = new Scanner(url.openStream());
				int i = 1;
				mapForBoy[year - 2001] = new HashMap<>();
				mapForGirl[year - 2001] = new HashMap<>();

				while (input.hasNext()) { 
					i = input.nextInt();
					String boyName = input.next();
		  			input.nextInt();
		  			String girlName = input.next();
		  			input.nextInt();
		  			
		  			mapForBoy[year - 2001].put(boyName, i);
		  			mapForGirl[year - 2001].put(girlName, i);
		  		}
	  	} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
    String gender = cboGender.getValue().toString();
    
    Label nameLabel = new Label(" ");
    borderPane.setBottom(nameLabel);
	BorderPane.setAlignment(nameLabel, Pos.CENTER);
	
	final int y = year;
			
    btFindRanking.setOnAction(e -> {
    	if (gender == "Male") {
    		nameLabel.setText("the name " + tfName.getText() + " is ranked number " + mapForBoy[y - 2010].get(tfName.getText()) + " for the year " + (y - 10));
    		borderPane.setBottom(nameLabel);
    	}
    	if (gender == "Female") {
    		nameLabel.setText("the name " + tfName.getText() + " is ranked number " + mapForGirl[y - 2010].get(tfName.getText()) + " for the year " + (y - 10));
    		borderPane.setBottom(nameLabel);
    	}
    });
  }

  public static void main(String[] args) {
    launch(args);
  }
}