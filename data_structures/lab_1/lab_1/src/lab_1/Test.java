package lab_1;
/**
 * This tests the Interpreter
*/

//allows File IO
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

public class Test {
	
	public static void main(String args[]) throws FileNotFoundException {
		
		PrintStream outfile = new PrintStream(args[0]);
		System.setOut(outfile);
		
		// loop through file names
		for(int arg = 1; arg < args.length; arg++) {
			
			// Initialize interpreter
			Interpreter i = new Interpreter();
			
			// Try except in case file name is bogus
			try {
				// Read file
				FileReader fr = new FileReader(args[arg]);
		        BufferedReader filename = new BufferedReader(fr);
		        
		        // Print filename back to user
		        System.out.println("File: ".concat(args[arg]));
		        
		        // Get first line of text file
		        String w = filename.readLine(); 
		        
		        // while end of file has not yet been reached
		        while(w != null) { 
		        	System.out.println("String: ".concat(w)); // print string back 
		        	
		        	// Test all the languages
		        	String l1 = Boolean.toString(i.testL1(w));
		        	String l2 = Boolean.toString(i.testL2(w));
		        	String l3 = Boolean.toString(i.testL3(w));
		        	String l4 = Boolean.toString(i.testL4(w));
		        	String l5 = Boolean.toString(i.testL5(w));
		        	String l6 = Boolean.toString(i.testL6(w));
		        	
		        	// Print all the results
		        	System.out.println("L1 - ".concat(l1));
		        	System.out.println("L2 - ".concat(l2));
		        	System.out.println("L3 - ".concat(l3));
		        	System.out.println("L4 - ".concat(l4));
		        	System.out.println("L5 - ".concat(l5));
		        	System.out.println("L6 - ".concat(l6));
		        	
		        	w = filename.readLine(); // next line
		        }
		        // Close the file after finishing
		        filename.close();
				
			} catch(Exception e){ // if file does not exist
				System.out.println("This file does not exist: "
						.concat(args[arg]).concat(". Please try another file."));
				System.out.println(e);
			}
		}
	}
}