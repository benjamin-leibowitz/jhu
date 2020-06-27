package lab_1;
/**
 * This tests the Interpreter
*/

public class Test {
	
	public static void main(String args[]) {
		
		Interpreter i = new Interpreter();
		String w = "AABB";
		System.out.println("L1 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL1(w))));
		
		w = "ABB";
		System.out.println("L1 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL1(w))));
		
		w = "";
		System.out.println("L1 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL1(w))));
		
		w = "ABAABBABAAABBB";
		System.out.println("L1 - ".concat(w).concat(" - ").concat(Boolean.toString(i.testL1(w))));
	}
}