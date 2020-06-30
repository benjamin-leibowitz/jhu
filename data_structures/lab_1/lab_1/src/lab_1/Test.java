package lab_1;
/**
 * This tests the Interpreter
*/

public class Test {
	
	public static void main(String args[]) {
		
		Interpreter i = new Interpreter();
		String w = "ABBABBABB";
		System.out.println("L4 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL4(w))));
		
		w = "AABBBAABBBAABB";
		System.out.println("L4 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL4(w))));
		
		w = "AB";
		System.out.println("L4 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL4(w))));
		
		w = "AABABB";
		System.out.println("L4 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL4(w))));
	}
}