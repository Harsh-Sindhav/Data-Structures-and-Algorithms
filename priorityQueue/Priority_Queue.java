package priorityQueue;

import java.util.ArrayList;


public class Priority_Queue<T> {
   
	private ArrayList<Element<T>> heap;
   // pvt bcoz we dont want to give access to user to make change in our heap that we have made
	
	public Priority_Queue() {
		heap = new ArrayList<>();
	}
	public void insert(T value,int priority) {
		
		Element<T> e = new Element<>(value,priority);
		heap.add(e);
		//add will insert the element at last pos now we have to follow the process of upheapify so we compare this(as it is a child of some node obviously) with its parent   
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex > 0 ) {
		if(heap.get(childIndex).priority < heap.get(parentIndex).priority) {
			Element<T> temp = heap.get(childIndex);
			heap.set(childIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			childIndex = parentIndex;
			parentIndex = (childIndex-1)/2; // parent index may/will reach zero and index < 0 is not possible so thats why while loop shoul be > 0
		}else {
			return;
		}
		}
		
	}
	
	public T getMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		return heap.get(0).value; 
	}
	
	public T removeMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		Element<T> removed = heap.get(0);
		T ans = removed.value;
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1); // removing the last element also remove fn wants index value and the element 
		int parentIndex = 0;
		int leftChildIndex = 2*parentIndex + 1;
		int rightChildIndex = 2*parentIndex + 2;
	  // downheapify !
		while(leftChildIndex < heap.size()) // means reaches the bottom most part of tree i.e leftChildIndex ke right aur left child are null  )
		{
		int minIndex = parentIndex;
		if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
			minIndex = leftChildIndex;
		}
		if((rightChildIndex < heap.size() /**<-- checks wheteher rightchildIndex within the range i.e rightChildIndex is null or not  otherwise will give error if we not add this conditon */) &&( heap.get(rightChildIndex).priority < heap.get(minIndex).priority) ) {
			minIndex = rightChildIndex;
		}
		if(minIndex == parentIndex) {
			break;
		} 
		Element<T> temp = heap.get(minIndex);
		heap.set(minIndex, heap.get(parentIndex));
		heap.set(parentIndex, temp);
		parentIndex = minIndex;
		leftChildIndex = 2*parentIndex+1; // if this is the last left child i.e. reaches the bottom of tree then after doing this initialisation the loop will end bcoz we stored nodes in the form of arraylist 
		rightChildIndex = 2*parentIndex+2;
		}
		return ans;
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}
		return false;
	}
	
	
}
