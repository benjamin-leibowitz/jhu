package lab_3;

class Node {
	
	/**
	 * This class represents a node within the Matrix class
	 * Attributes:
	 * - value: this value is the integer data to be held
	 * within the Node
	 * - right: this is a pointer to the node to its
	 * immediate right, or null if in the right column
	 * - down: this is a pointer to the node directly
	 * below this node, or null if on the bottom row
	*/
	
	public int value;
	public Node right; // pointer to right
	public Node down; // pointer below
	
	// For laying down temporary nodes
	Node(){
		
		right = null;
		down = null;
		
	}
	
	// initialize data, right and down initially null
	Node(int val){
		
		value = val;
		right = null;
		down = null;
		
	}
	
	// For displaying an entire matrix
	static void print(Node matrix_head) 
    { 
        Node right, down = matrix_head; 
  
        while(down != null) 
        { 
        	right = down; 
  
            while(right != null) 
            { 
                System.out.print(right.value + " "); 
                right = right.right; 
            } 
            System.out.println(); 
            down = down.down; 
        } 
    } 
}
