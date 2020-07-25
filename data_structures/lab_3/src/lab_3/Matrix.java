package lab_3;

/**
 * This class converts an integer array to a linked list
 * To do this it will create one node per data element
 * Each node will have right and down attributes pointing
 * to the nodes below and to the right
*/

class Matrix {
	
	/**
	 * This function returns a linked matrix from a 2-D int array
	 * Input: A 2-D Integer array
	 * Precondition: The array has valid values for all coordinates
	 * Process: 
	 *  - Creates one linked list per column
	 *  - Lays down first column as matrix head
	 *  - Lays down subsequent columns and sets pointers 
	 *  for the Node to the right and below
	 * Postcondition: The input array is unchanged
	 * Output: A linked matrix 
	 * @return returns the a linked matrix with the same data as the 
	 * integer array
	*/
	Node arrayToMatrix(int matrix[][]) {
		
		int size = matrix.length;
		
		Node matrix_head = null; // Head of entire matrix
		Node row_head[] = new Node[size]; // Head of each row (left column)
		Node this_node = new Node(); // For grabbing current node
		Node next_node = new Node(); // For grabbing next node
		
		// First lay down all nodes by iterating over rows
		for(int r = 0; r < size; r++) {
			
			row_head[r] = null; // for each new row, set head to null
			
			// iterate over columns
			for(int c = 0; c < size; c++) {
				
				// Create node first before deciding what to do with it
				this_node = new Node(matrix[r][c]);
				
				// If it's the top left node, it is the matrix head
				if(matrix_head == null) { matrix_head = this_node; }
				// If it's the first element in a row, it is row head
				if(row_head[r] == null) { row_head[r] = this_node; }
				// Otherwise, it's the next node in the row
				else { next_node.right = this_node; }
				
				next_node = this_node;
			}
		}
		
		// Once all nodes have been laid down, down pointers can be set
		// by keeping track of two rows at a time and connecting them
		for(int r = 0; r < size - 1; r++) {
			
			// Use this and next head to link matrix together vertically
			this_node = row_head[r];
			next_node = row_head[r + 1];
			
			// Connect pointers down for each column
			for(int c = 0; c < size; c++) {
				
				// Connect rows
				this_node.down = next_node; 
				
				// Move over
				this_node = this_node.right; 
				next_node = next_node.right;
				
			}
		}
		return matrix_head; // return top left node
	}
}
