package lab_1;

import java.util.ArrayList;

/**
 * This creates an Interpreter object
 * Distinguishes whether input strings are of predefined language
 * Methods - see definitions at function definitions
 * L1
 * L2
 * L3
 * L4
 * L5
 * L6
*/
public class Interpreter {
	
	private CharStack cs; // CharStack will be used for LIFO characteristics
	private CharStack a; // CharStack will be used for LIFO characteristics
	private CharStack b; // CharStack will be used for LIFO characteristics
	public static int MAX_LENGTH = 78; // String can't be over 78 characters
	
	/**
	 * Tests whether string w contains equal numbers of A's and B's 
	 * (in any order) and no other characters
	 * Input: 
	 * @param w is the string to be tested
	 * Preconditions: string is more than 0 characters but no more than 78
	 * Process: tests whether string meets criteria of L1
	 * Postcondition: None
	 * Output:
	 * @return isL1 is a boolean indicating whether w follows L1 criteria
	 */
	public boolean testL1(String w) {
		
		cs  = new CharStack();
		
		// List of permissible characters (A or B)
		ArrayList<Character> permissible = new ArrayList<>(2);
		permissible.add('A');
		permissible.add('B');
		
		// First test to see if it's an empty string (epsilon case)
		if(w.isEmpty()) return false;
		
		w += Character.MIN_VALUE; // Stop character b/c not permitted to test length
		
		// Loop through string, while end hasn't been reached
		int s = 0; // string index
		while(w.charAt(s) != Character.MIN_VALUE) {
			
			char element = w.charAt(s); // String w character s
			
			// Test length only to prevent stack overflow
			if(s > MAX_LENGTH) { 
				System.out.println("Warning: input string too long to test, returning false");
				return false;
			}
			
			// Test to see if character is permissible
			if(!permissible.contains(element)) return false;
			
			// If empty stack, automatically push
			if(cs.isEmpty()) cs.push(element);
			
			// If character is the same as the top, push
			else if (cs.peek() == element) cs.push(element);
			
			// If character is not the same, pop
			else cs.pop();
			
			s++;
		}
		// If no elements left in the stack, it is L1, otherwise not
		if(cs.isEmpty()) return true;
		else return false;
	}
	
	/**
	 * Tests whether string w is of the form A^n B^n, for some n > 0
	 * Input: 
	 * @param w is the string to be tested
	 * Preconditions: string is no more than 78 characters
	 * Process: tests whether string meets criteria of L2
	 * Postcondition: None
	 * Output:
	 * @return isL2 is a boolean indicating whether w follows L2 criteria
	 */
	public boolean testL2(String w) {
		
		a = new CharStack();
		b = new CharStack();
		
		// List of permissible characters (A or B)
		ArrayList<Character> permissible = new ArrayList<>(2);
		permissible.add('A');
		permissible.add('B');
		
		// First test to see if it's an empty string (epsilon case)
		if(w.isEmpty()) return false; 
		
		// Loop through string, while end hasn't been reached
		w += Character.MIN_VALUE; // Stop character b/c not permitted to test length
		int s = 0; // string index	
		boolean a_completed = false; // Once one B has been reached, no more As
		
		while(w.charAt(s) != Character.MIN_VALUE) {
			
			char element = w.charAt(s); // String w character s
			
			// Test length only to prevent stack overflow
			if(s > MAX_LENGTH) { 
				System.out.println("Warning: input string too long to test, returning false");
				return false;
			}
			
			// Test to see if character is permissible
			if(!permissible.contains(element)) return false;
			
			// If a B comes first, not L2
			if(element == 'B' && a.isEmpty()) return false;
			
			// If A encountered, push unless B has been reached
			if(element == 'A' && a_completed == false) a.push(element);
			
			// If A encountered and B has been reached, then not L2
			if(element == 'A' && a_completed == true) return false; 
			
			// If B reached subsequent times, push
			if(element == 'B' && a_completed == true) b.push(element);
			
			// If B reached for the first time, push and prevent more As
			if(element == 'B' && a_completed == false) { 
				b.push(element);
				a_completed = true;
			}
			
			s++;	
		}
		
		// Should be able to pop equal B as A
		while(!a.isEmpty() && !b.isEmpty()) {
			a.pop(); // pop a
			b.pop(); // pop b 
		}
		
		// If a and b both empty, it follows L2 
		if(a.isEmpty() && b.isEmpty()) return true;
		else return false; 
	}
	
	/**
	 * Tests whether string w is of the form A^n B^2n , for some n > 0
	 * Input: 
	 * @param w is the string to be tested
	 * Preconditions: string is no more than 78 characters
	 * Process: tests whether string meets criteria of L3
	 * Postcondition: None
	 * Output:
	 * @return isL3 is a boolean indicating whether w follows L2 criteria
	 */
	public boolean testL3(String w) {
		
		a = new CharStack();
		b = new CharStack();
		
		// List of permissible characters (A or B)
		ArrayList<Character> permissible = new ArrayList<>(2);
		permissible.add('A');
		permissible.add('B');
		
		// First test to see if it's an empty string (epsilon case)
		if(w.isEmpty()) return false; 
		
		// Loop through string, while end hasn't been reached
		w += Character.MIN_VALUE; // Stop character b/c not permitted to test length
		int s = 0; // string index	
		boolean a_completed = false; // Once one B has been reached, no more As
		
		while(w.charAt(s) != Character.MIN_VALUE) {
			
			char element = w.charAt(s); // String w character s
			
			// Test length only to prevent stack overflow
			if(s > MAX_LENGTH) { 
				System.out.println("Warning: input string too long to test, returning false");
				return false;
			}
			
			// Test to see if character is permissible
			if(!permissible.contains(element)) return false;
			
			// If a B comes first, not L3
			if(element == 'B' && a.isEmpty()) return false;
			
			// If A encountered, push unless B has been reached
			if(element == 'A' && a_completed == false) a.push(element);
			
			// If A encountered and B has been reached, then not L3
			if(element == 'A' && a_completed == true) return false; 
			
			// If B reached subsequent times, push
			if(element == 'B' && a_completed == true) b.push(element);
			
			// If B reached for the first time, push and prevent more As
			if(element == 'B' && a_completed == false) { 
				b.push(element);
				a_completed = true;
			}
			
			s++;	
		}
		
		// Should be able to pop twice as many B as A
		while(!a.isEmpty() && !b.isEmpty()) {
			a.pop(); // pop a
			b.pop(); // pop b 
			if(b.isEmpty()) return false; // If B has odd number of elements, not L3
			else b.pop();
		}
		
		// If a and b both empty, it follows L3
		if(a.isEmpty() && b.isEmpty()) return true;
		else return false; 
	}
}