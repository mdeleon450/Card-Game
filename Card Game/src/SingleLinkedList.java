// Author: Maik De Leon Lopez
// Single Linked List implementation
public class SingleLinkedList {
	
	private Node head;	// Head of the linked list
	private int size;	// How many nodes are there in the list
	
	// Constructor
	public SingleLinkedList() {
		this.head = new Node(null);	// This creates the head
		this.size = 0;				// Initially there are no nodes in the list
	}
	
	// Method to add at the beginning of the linked list
	public void addFirst(Object item) {
		/*
		Node first = new Node(item);	// Creates the new node
		first.next = head.next;			// Copy the link from the head
		head.next = first;				// Update the head.next pointer
		*/
		head.next = new Node(item , head.next);
		size++;							// Increase the size
	}
	
	// Method to insert value after a node
	public void addAfter(Object item, Node target) {
		target.next = new Node(item, target.next);
		size++;
	}
	
	// For Users to be Able to use addAfter
	// Overload the addAfter()
	public void addAfter(Object item, int index) {
		if(index > size || index < 0) {
			System.out.println("Cannot add at invalid index!");
			return;
		}
		addAfter(item,getNode(index));
	}
	
	// Method to insert at the end of the list
	public void addLast(Object item) {
		Node target = getNode(size);		// Get the reference of last node
		this.addAfter(item, target);  		// Use the addAfter() method to insert
	}
	
	// Helper Method that returns the Reference of Target Node in index
	private Node getNode(int index) {
		if(index > size || index < 0) {
			return null;
		}
		// Otherwise, we iterate over the list and return the reference
		Node iter = head;	// Iterator node
		for(int i = 0 ; i<index; i++) {
			iter = iter.next;	// Keep going to next node
		}
		// At the end of the loop, you are pointing to the node at index
		return iter;
	}
	
	// Method to remove data from the beginning of the list
	public Node removeFirst() {
		// Check if there is an object to remove
		if(size == 0) {
			// There is no data
			return null;
		}
		Node temp = head.next;		// Store in a temp reference to return
		head.next = head.next.next;	// Point the head to the second node or null
		size--;
		return temp;
	}
	
	/* Method to remove data after a target node
	public Node removeAfter(Node target) {
		
		Node temp = target.next;
		target.next = target.next.next;
		return temp;
	}*/
	
	public Node removeAfter(int target) {
		Node temp = getNode(target);
		if(temp != null) {
			removeAfter(temp);
			return temp;
		}
		return null;
	}
	
	public Node removeAfter(Node target) {
		Node temp = target.next; // This is the node being deleted
		if(temp != null) {
			target.next = temp.next;
			size--;
		}
		else {
			System.out.println("Invalid Index!");
			return null;
		}
		return temp;
	}
	
	// toString method to print the contents of the linked list
	public String toString() {
		String value = "Front:";
		Node temp = head;	// This is the iterator to go over the nodes
		while(temp.next != null) {	// While there is still some node
			value += " | "+temp.next.data;	// Get the node data
			temp = temp.next;				// Move to next node
		}
		return value;
	}
	
	public int getSize() {
		return this.size;
	}
}