package Exercises21_7_9_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex21_9 {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		  Map<String, String> stateCapital = new HashMap<String, String>();
		  stateCapital.put("alabama", "Montgomery");
		  stateCapital.put("alaska", "Juneau");
		  stateCapital.put("arizona", "Phoenix");
		  stateCapital.put("arkansas", "Little Rock");
		  stateCapital.put("california", "Sacramento");
		  stateCapital.put("colorado", "Denver");
		  stateCapital.put("connecticut", "Hartford");
		  stateCapital.put("delaware", "Dover");
		  stateCapital.put("florida", "Tallahassee");
		  stateCapital.put("georgia", "Atlanta");
		  stateCapital.put("hawaii", "Honolulu");
		  stateCapital.put("idaho", "Boise");
		  stateCapital.put("illinois", "Springfield");
		  stateCapital.put("indiana", "Indianapolis");
		  stateCapital.put("iowa", "Des Moines");
		  stateCapital.put("kansas", "Topeka");
		  stateCapital.put("kentucky", "Frankfort");
		  stateCapital.put("louisiana", "Baton Rouge");
		  stateCapital.put("maine", "Augusta");
		  stateCapital.put("maryland", "Annapolis");
		  stateCapital.put("massachusettes", "Boston");
		  stateCapital.put("michigan", "Lansing");
		  stateCapital.put("minnesota", "Saint Paul");
		  stateCapital.put("mississippi", "Jackson");
		  stateCapital.put("missouri", "Jefferson City");
		  stateCapital.put("montana", "Helena");
		  stateCapital.put("nebraska", "Lincoln");
		  stateCapital.put("nevada", "Carson City");
		  stateCapital.put("new hampshire", "Concord");
		  stateCapital.put("new jersey", "Trenton");
		  stateCapital.put("new york", "Albany");
		  stateCapital.put("new mexico", "Santa Fe");
		  stateCapital.put("north carolina", "Raleigh");
		  stateCapital.put("north dakota", "Bismarck");
		  stateCapital.put("ohio", "Columbus");
		  stateCapital.put("oklahoma", "Oklahoma City");
		  stateCapital.put("oregon", "Salem");
		  stateCapital.put("pennsylvania", "Harrisburg");
		  stateCapital.put("rhode island", "Providence");
		  stateCapital.put("south carolina", "Columbia");
		  stateCapital.put("south dakota", "Pierre");
		  stateCapital.put("tennessee", "Nashville");
		  stateCapital.put("texas", "Austin");
		  stateCapital.put("utah", "Salt Lake City");
		  stateCapital.put("vermont", "Montpelier");
		  stateCapital.put("virginia", "Richmond");
		  stateCapital.put("washington", "Olympia");
		  stateCapital.put("west Virginia", "Charleston");
		  stateCapital.put("wisconsin", "Madison");
		  stateCapital.put("wyoming", "Cheyenne");
	
	    Scanner input = new Scanner(System.in);
	
	    for (int i = 0; i < stateCapital.size(); i++) {
	     
	      System.out.print("Please enter a State: ");
	      String state = input.nextLine().trim().toLowerCase();
	      
	      if (stateCapital.containsKey(state))
	    	  System.out.println(stateCapital.get(state));
	      else 
	    	  System.out.println("input is eightr not a state or a typo");
	    }
	  }
}