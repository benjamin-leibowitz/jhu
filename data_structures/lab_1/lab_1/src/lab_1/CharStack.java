package lab_1;
/**
 * This creates a CharStack object
 * Stack ADT
 * Methods - see definitions at function definitions
 * 	push
 * 	isEmpty
 *  pop
 *  peek
*/

public class CharStack {
	
	public char stack[]; // infrastructure to store stack
	public int top; // top of the stack
	public static int MAX_LENGTH = 78;
	
	/**
	 * Creates a default Stack object
	*/
	CharStack() {
		
		stack = new char[MAX_LENGTH]; // strings supposed to be <= 78 characters
		top = -1; 	
		
	}
	
	/**
	 * This function pushes an item to the stack
	 * Input: A Stack object
	 * @param element the element to be pushed
	 * Precondition: Stack < 78 characters
	 * Process: Moves top and adds character to stack
	 * Postcondition: Item pushed to stack
	 * Output: None
	*/
	public void push(char element) {
		
		// check if stack would overflow
		if(top >= MAX_LENGTH) System.out.println("Strings should be under 78 characters");
		
		
		else {
			top++; // move top over
			stack[top] = element; // push element
		}
		
	}
	
	/**
	 * This function checks whether the stack is empty
	 * Input: a Stack() object
	 * Precondition: Stack is a valid Stack() object
	 * Process: Tests whether stack is empty
	 * Postcondition: Stack() is unchanged
	 * Output: true if stack is empty, false otherwise
	*/
	public boolean isEmpty() {
		
		if(top == -1) return true; // if top is -1, it's empty
		else return false; 
		
	}
	
	/**
	 * This function pops an item from the stack
	 * Input: A Stack object
	 * Precondition: The Stack has an element to pop
	 * Process: Moves top and adds character to stack
	 * Postcondition: Item popped from stack
	 * Output: The top of the stack
	 * @return returns the popped element, or nothing if stack empty
	*/
	public char pop() {
		
		if(this.isEmpty()) { // check if Stack is empty
			
			return Character.MIN_VALUE; // if so, return null character
			
		} else {
			
			char popped = stack[top]; // get value to pop
			stack[top] = Character.MIN_VALUE; // empty top element
			top--; // move top
			return popped;
			
		}
	}
	
	/**
	 * This function returns the top of the stack
	 * Input: A Stack object
	 * Precondition: The Stack has an element to peek
	 * Process: 
	 * Postcondition: Stack is unchanged
	 * Output: The top of the stack
	 * @return returns the top element, or nothing if stack empty
	*/
	public char peek() {
		
		// check if Stack is empty - if so, return null character
		if(this.isEmpty()) return Character.MIN_VALUE;
		else return stack[top]; // otherwise return top of stack
		
	}
	
	/**
	 * Prints the stack - for debugging purposes only!
	*/
	public void print() {
		
		System.out.println(stack);
		
	}
}