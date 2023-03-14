package Exercises17_1_3_7_14X15;

import java.io.*;

public class Ex17_7 {
    public static void main(String[] args) throws ClassNotFoundException, IOException, NotSerializableException {
		Loan loan1 = new Loan();
	    Loan loan2 = new Loan(1.8, 10, 10000);
	    try ( ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat", true)); ) {
	    		   output.writeObject(loan1);
	    		   output.writeObject(loan2);
	    } catch (IOException ex) {
	        System.out.println("File could not be opened");
	    }
        
      try ( ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat")); ) {
    	  for (int i = 1; i <= 2; i++) {
    		  if (i == 1) {
    			  loan1 = (Loan) (input.readObject());
    			  System.out.println(loan1);
    		  } else if (i == 2) {
    			  loan2 = (Loan) (input.readObject());
    			  System.out.println(loan2);
    		  }
    	  }
        } catch (EOFException ex) {
        	System.out.println("End of File");
        }
    }
}