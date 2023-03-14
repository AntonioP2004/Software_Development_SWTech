package Exercises14_15_28;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
    
public class Ex14_28 extends Application {
	     @Override // Override the start method in the Application class
	    public void start(Stage primaryStage) {
	      // Create a clock and a label
	      ClockPane clock = new ClockPane();
	      clock.setHourHandVisible( true );
	      clock.setMinuteHandVisible( true );
	      clock.setSecondHandVisible( false );
	      
	      String timeString = clock.hour + ":" + clock.minute
	        + ":" + clock.second;
	      Label lblCurrentTime = new Label(timeString);
	  
	      // Place clock and label in border pane
	      BorderPane pane = new BorderPane();
	      pane.setCenter(clock);
	      pane.setBottom(lblCurrentTime);
	      BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
	  
	      // Create a scene and place it in the stage
	      Scene scene = new Scene(pane, 250, 250);
	      primaryStage.setTitle("DisplayClock"); // Set the stage title
	      primaryStage.setScene(scene); // Place the scene in the stage
	      primaryStage.show(); // Display the stage
	    }
	  }
    
    class ClockPane extends Pane {
    	private boolean hourHandVisible = true;
    	private boolean minuteHandVisible = true;
    	private boolean secondHandVisible = true;
    	
    	int hour = 1;
    	int minute = 1;
    	int second = 1;
    	
    	public boolean getHourHandVisible() {
        	return this.hourHandVisible;
        }
        public boolean getMinuteHandVisible() {
        	return this.minuteHandVisible;
        }
        public boolean getSecondHandVisible() {
        	return this.secondHandVisible;
        }
        
        public void setHourHandVisible(boolean hourHandVisible) { 
        	this.hourHandVisible = hourHandVisible; 
        	paintClock();
        	}
        public void setMinuteHandVisible(boolean minuteHandVisible) { 
        	this.minuteHandVisible = minuteHandVisible; 
        	paintClock();
        	}
        public void setSecondHandVisible(boolean secondHandVisible) { 
        	this.secondHandVisible = secondHandVisible; 
        	paintClock();
        	}
    	
     // Clock pane's width and height
     private double w = 250, h = 250;
     
     /** Construct a default clock with the current time*/
     public ClockPane() {
       setCurrentTime();
     }
   
     /** Return clock pane's width */ 
     public double getW() {
       return w;
     }
     
     /** Set clock pane's width */ 
     public void setW(double w) {
       this.w = w;
       paintClock();
    }
     
     /** Return clock pane's height */ 
     public double getH() {
       return h;
     }
     
     /** Set clock pane's height */ 
     public void setH(double h) {
       this.h = h;
       paintClock();
     }
     
     /* Set the current time for the clock */
     public void setCurrentTime() {
       // Set current hour, minute and second
       hour = (int) (Math.random() * 11);
       second = (int) (Math.random() * 59);
       int min = (int) (Math.random() * 2);
       if (min == 1) {
    	   minute = 0;
       } else if (min == 0) {
    	   minute = 30;  
       }
       
       paintClock(); // Repaint the clock
     }
     
   /** Paint the clock */
    protected void paintClock() {
      // Initialize clock parameters
      double clockRadius = Math.min(w, h) * 0.8 * 0.5;
      double centerX = w / 2;
      double centerY = h / 2;
  
      // Draw circle
      Circle circle = new Circle(centerX, centerY, clockRadius);
      circle.setFill(Color.WHITE);
      circle.setStroke(Color.BLACK);
      Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
      Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
      Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
      Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
      
      // Draw second hand
      double sLength = clockRadius * 0.8;
      double secondX = centerX + sLength * 
        Math.sin(second * (2 * Math.PI / 60));
      double secondY = centerY - sLength * 
        Math.cos(second * (2 * Math.PI / 60));
      Line sLine = new Line(centerX, centerY, secondX, secondY); 
      sLine.setStroke(Color.RED);
	  
      // Draw minute hand
      double mLength = clockRadius * 0.65;
      double xMinute = centerX + mLength * 
        Math.sin(minute * (2 * Math.PI / 60));
      double minuteY = centerY - mLength * 
        Math.cos(minute * (2 * Math.PI / 60));
      Line mLine = new Line(centerX, centerY, xMinute, minuteY); 
      mLine.setStroke(Color.BLUE);
	
      // Draw hour hand
      double hLength = clockRadius * 0.5;
      double hourX = centerX + hLength * 
        Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
      double hourY = centerY - hLength *
        Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
      Line hLine = new Line(centerX, centerY, hourX, hourY); 
      hLine.setStroke(Color.GREEN);
	      
	  getChildren().addAll(circle, t1, t2, t3, t4);
	  
      if (secondHandVisible == true) { getChildren().add(sLine); }
      if (minuteHandVisible == true) { getChildren().add(mLine); }
	  if (hourHandVisible == true) { getChildren().add(hLine); } 
    }
  }