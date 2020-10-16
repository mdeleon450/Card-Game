// Author:
// Node for single linked list
public class Node {
	// Data
	Object data;
	// Link
	Node next;
	
	// Constructors
	// Default
	public Node(Object data) {
		this.data = data;	// Assign the given data
		this.next = null;	// By default there is no next node
	}
	
	// Overloaded Constructor
	// Creates a node and points it to another node
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
}
