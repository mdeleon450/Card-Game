//Author: Maik De Leon Lopez
//Using a Linked List to Implement Queue

public class linkedQueue {
	
	//Data
	private SingleLinkedList Q;
	private int size;
	
	//Default Constructor
	public linkedQueue() {
		this.Q = new SingleLinkedList();
		this.size = this.Q.getSize();
	}
	
	//The addLast method for linked lists can acts as offer
	public void offer(Object obj) {
		this.Q.addLast(obj);
		this.size ++;	//Increment Size
	}
	
	//The removeFirst method can be used as poll
	public Object poll() {
		if(this.isEmpty()) {	//Check if the list is empty
			System.out.println("The Queue is Empty, Cannot Delete!");
			return null; //If so can't remove
		}
		size --;	//Otherwise remove the data using removeFirst
		return Q.removeFirst().data;
	}
	
	//Method used to determine if the queue is empty
	public boolean isEmpty() {
		return (size == 0);
	}
	
	//Method that returns front of queue without removal
	public Object peek() {
		if(this.isEmpty()) {	//If the queue is empty then return nothing
			System.out.println("Queue Empty");
			return null;
		}
		Node temp = this.Q.removeFirst();	//We remove the front of the queue and save it
		this.Q.addFirst(temp.data);			//And add it back to the front 
		return temp.data;
	}
	
	//Method that returns the size of the Queue
	public int getSize() {
		return this.size;
	}
	
	//Method used to print the queue, uses the method for printing linked lists
	public String toString() {
		return this.Q.toString();
	}
}
