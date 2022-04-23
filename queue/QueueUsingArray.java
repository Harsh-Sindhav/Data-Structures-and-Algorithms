package queue;

public class QueueUsingArray {
	private int data[];
	private int size;
	private int front;
	private int rear;
    public 	QueueUsingArray() {
        data = new int[5];
    	front = -1;
    	rear = -1;
    }
    
    public boolean isEmpty() {
    	return size==0;
    }
    
	public QueueUsingArray(int capacity) {
		data = new int[capacity];
	    front = -1;
		rear = -1;
	}
	
	private void doubleCapacity() {
		int temp[] = data;
		data = new int[2*temp.length];
		int index = 0;
		for (int i = front; i < temp.length; i++) {
			data[index++] = temp[i];
		}
		for (int i = 0; i < front - 1; i++) {
			data[index++] = temp[i];
		}
		front = 0;
		rear = temp.length-1;
	}
	
	public int size()  throws QueueEmptyException{
		if(size == 0) {
			throw new QueueEmptyException();
		}
		
		return size;
	}
	
	public int front() throws QueueEmptyException {
		
		if(front == -1) {
			
			throw new QueueEmptyException();
		}
		
		return data[front];
	}
	
     public void enqueue(int elem){
    	 if(size == data.length) {
    		doubleCapacity();
    	 }
    	 
    	 if(size == 0) {
    		 //front++; //coz front = -1
    		 front =0;
    	 }
   /* 	 // big mistake
//    	 rear++;
//    	 data[rear] = elem;
//    		size++; 	 
    */	 
//    	 rear++;
//    	 if(rear == data.length) {
//    		 rear = 0;
//    	 }  or simply we can do write rear = (rear+1) % data.len  
    	 
    	 rear = (rear + 1) % data.length; 
    	 data[rear] = elem;
    	 size++;
    	 
    	 
     }
     
     public int dequeue() throws QueueEmptyException {
    	if(size == 0) {
    		throw new QueueEmptyException();
    	}
    	  	
        int temp = data[front];
        /* // bug/big mistake
//        front++;
//        size--;
//        if(size==0) {
//        	front = -1;
//        	rear = -1;
//        }
        */ 
       
//    	front++;
//    	if(front == data.length) {
//    		front = 0;
//    	}  or simply we can do write front = (front+1) % data.len  
        
    	 front = (front + 1) % data.length;
    	size--;
    	if(size == 0) {
    		front = -1;
    		rear = -1;
    	}
    	
    	return temp;
     }
	
     
    
}
