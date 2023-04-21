import javax.swing.JRadioButton;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class Test extends Application{

	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		
	    TabPane tabPane = new TabPane();
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
	    tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
	    
	    JRadioButton top = new JRadioButton();
	    JRadioButton bottom = new JRadioButton();
	    JRadioButton left = new JRadioButton();
	    JRadioButton right = new JRadioButton();
	
	    grid.add(top, 0 ,0);
	    
	    Scene scene = new Scene(tabPane, 300, 250);  
	    primaryStage.setTitle("DisplayFigure"); // Set the window title
	    primaryStage.setScene(scene); // Place the scene in the window
	    primaryStage.show(); // Display the window
	}
	
	public static void main(String[] args) {
		System.out.println("Hello!");
		launch(args);
	}

}
