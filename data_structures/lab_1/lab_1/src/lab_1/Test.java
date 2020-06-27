package lab_1;
/**
 * This tests the Interpreter
*/

public class Test {
	
	public static void main(String args[]) {
		
		Interpreter i = new Interpreter();
		String w = "ABB";
		System.out.println("L2 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL3(w))));
		
		w = "AABBBB";
		System.out.println("L2 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL3(w))));
		
		w = "BBBAAA";
		System.out.println("L2 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL3(w))));
		
		w = "ABBB";
		System.out.println("L2 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL3(w))));
		
		w = "AABBBBB";
		System.out.println("L2 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL3(w))));
	}
}