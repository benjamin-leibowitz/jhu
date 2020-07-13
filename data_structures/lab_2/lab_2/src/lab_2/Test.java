package lab_2;

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
import java.util.Arrays;

public class Test {

	public static void main(String args[]) throws FileNotFoundException {

		String filename = args[0];
		
		// Try except in case file name is bogus
		try {
			// Read file
			FileReader fr = new FileReader(filename);
	        BufferedReader file = new BufferedReader(fr);

	        // Print filename back to user
	        System.out.println("File: ".concat(filename));

	        // Get first line of text file
	        String w = file.readLine();

	        // while end of file has not yet been reached
	        while(w != null) {
	        	
	        	// Convert line of text to string array
	        	String[] row_str = w.split(" ");
	        	
	        	// String array -> Int array
	        	int[][] matrix = new int[row_str.length][row_str.length]; 
	        	
	        	for (int i = 0; i < matrix.length; i++){
	        		
	        		for(int j = 0; j < matrix.length; j++) {
	        			
	        			matrix[i][j] = Integer.parseInt(row_str[i]); 
	        			
	        		}
	        		
	        		// If parsing matrix, go to next line
	        		if(i != matrix.length - 1) {
	
		    	        w = file.readLine();
		    	        
			        	row_str = w.split(" "); // String -> String array
	        		}
	        		
	        	}
	        	
	        	// Print back matrix
	        	System.out.println(Arrays.deepToString(matrix));
	        	
	        	w = file.readLine(); // next line
	        }
	        // Close the file after finishing
	        file.close();

		} catch(Exception e){ // if file does not exist
			System.out.println("This file does not exist: "
					.concat(filename).concat(". Please try another file."));
			System.out.println(e);
		}
	}
}