package lab_3;

/**
 * This class calculates the determinant of a matrix using recursion
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Determinant {

	int determinant = 0;

	/**
	 * This function returns the determinant of a matrix
	 * Input: A 2-D Integer array
	 * Precondition: The array has valid values for all coordinates
	 * in the array
	 * Process: Calculates the determinant using a recursive formula
	 * Postcondition: The input array is unchanged
	 * Output: The determinant
	 * @return returns the determinant of the matrix as an integer
	*/
	int det(Matrix m) {

		// Initialize determinant and minor matrix
		int[][] minor = new int[matrix.length - 1][matrix.length - 1];

		// First base case, 1x1 matrix
		if(matrix.length == 1) { determinant = matrix[0][0]; }

		// Second base case, 2x2 matrix
		else if(matrix.length == 2) {
			determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		}

		// Use recursion to get minor matrix from intermediate matrix
		else {

			// Loop through columns of matrix
			for(int matrix_col = 0; matrix_col < matrix.length; matrix_col++) {

				int minor_row = 0;

				// Loop through all rows except first of matrix
				for(int matrix_row = 1; matrix_row < matrix.length; matrix_row++) {

					int minor_col = 0;

					for(int col = 0; col < matrix.length; col++) {

						// If matrix column is not equal to iterated column, assign to minor
						if(col != matrix_col) {
							minor[minor_row][minor_col] = matrix[matrix_row][col];
							minor_col++;
						} else { continue; }

					}
					minor_row++;
				}
				// Calculate determinant of minor for each element in first row
				determinant += Math.pow(-1, matrix_col) * matrix[0][matrix_col] * det(minor);
			}
		}
		return determinant;
	}

	public static void main(String args[]) throws FileNotFoundException {

		Determinant d = new Determinant();
		Matrix m = new Matrix();
		Node matrix_head = new Node();

//		// Reroute system output to file
//		PrintStream outfile = new PrintStream(args[0]);
//		System.setOut(outfile);

		// Loop through input files
		for(int arg = 1; arg < args.length; arg++) {

			String filename = args[arg];

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

		        	d = new Determinant(); // initialize new determinant

		        	// Convert line of text to string array
		        	String[] row_str = w.split(" ");

		        	// String array -> Int array
		        	int[][] matrix = new int[row_str.length][row_str.length];

		        	for (int i = 0; i < matrix.length; i++){

		        		for(int j = 0; j < matrix.length; j++) {

		        			matrix[i][j] = Integer.parseInt(row_str[j]);

		        		}

		        		// If parsing matrix, go to next line
		        		if(i != matrix.length - 1) {

			    	        w = file.readLine();

				        	row_str = w.split(" "); // String -> String array
		        		}

		        	}

		        	// Initialize matrix
		        	m = new Matrix();
		        	// Convert array to matrix and store top left node
		        	matrix_head = m.arrayToMatrix(matrix);	
		        	// Print matrix back to user
		        	Node.print(matrix_head);
		        	// Calculate determinant and print back to user
		        	System.out.println("Determinant: ".concat(
		        			Integer.toString(d.det(m)).concat("\n")));

		        	w = file.readLine(); // next line
		        }
		        // Close the file after finishing
		        file.close();

			} catch(Exception e){ // if file does not exist
				System.out.println(e.getMessage());
//				System.out.println("This file does not exist: "
//						.concat(filename).concat(". Please try another file."));
//				System.out.println(e);
			}
		}
	}
}