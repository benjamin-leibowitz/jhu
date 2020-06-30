package lab_1_test;
/**
 * This tests the Interpreter
*/

//allows File IO
import java.io.File; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test {
	
	public static void main(String args[]) {
		
		Interpreter i = new Interpreter();
		
		String w = "CBABC";
		System.out.println("L4 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL5(w))));
		
		w = "AAAAAAAAAAADF";
		System.out.println("L4 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL5(w))));
	}
}