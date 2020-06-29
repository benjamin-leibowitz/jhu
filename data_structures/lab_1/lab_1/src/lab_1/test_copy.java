package lab_1;
/**
 * This tests the Interpreter
*/

public class test_copy {
	
	public static void main(String args[]) {
		
		Interpreter i = new Interpreter();
		
		CharStack c = new CharStack();
		c.push('A');
		CharStack a = c;
		a.pop();
		a.print();
		c.print();
	}
}