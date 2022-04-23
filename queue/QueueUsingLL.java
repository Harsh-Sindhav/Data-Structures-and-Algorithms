package queue;

import linkedList.Node;

public class QueueUsingLL<T> {

	Node<T> front;
	Node<T> rear;
	int size;
	
	public QueueUsingLL(){
		front = null;
		rear = null;
		size = 0;
	}
	
	public int size() {
	return size;	
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enqueue(T elem) {
		Node<T> newNode = new Node<>(elem);
		size++;
		if(rear == null) {
			front = newNode;
			rear = newNode;
		}else {
			rear.next = newNode;
			rear = newNode; // rear = rear.next
		}
	}
	
	public T front() throws QueueEmptyException {	
		if(front == null) {
			throw new QueueEmptyException();
		}
		return front.data;
	}
	
	public T dequeue() throws QueueEmptyException {
	if(front == null) {
		throw new QueueEmptyException();
	}
		T temp = front.data;
		front = front.next;
		if(front == null) {
			rear = null;  // coz rear is still pointing to elem thats why we're doing this
		}
		size--;
		return temp;
		
	}
	
}
