package stack;

public class StackUsingArray{
  
	private int data[];
	private int topIndex;
	public StackUsingArray(){
		// TODO Auto-generated constructor stub
	   data = new int[2];
	    topIndex = -1;
	}
	public StackUsingArray(int size) {
		data = new int[size];
		topIndex = -1;
	}
	private void doubleCapacity() {
		System.out.println("Double Capacity");
		int temp[] = data;
		data = new int[2*temp.length];
		for (int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}
	}
   
	public void push(int element) {
     if(topIndex == data.length-1) {
//    	 throw new StackFullException();
       doubleCapacity();
     }
		
		//      topIndex++;
      data[++topIndex] = element;
	}
	
     public int size(){
		return (topIndex + 1);
	}
     
     
	public int top() throws StackEmptyException {
		if(topIndex == -1){
			throw new StackEmptyException();
		}
		return data[topIndex];
	}
	
	public int pop() throws StackEmptyException{
		if(topIndex == -1) {
			throw new StackEmptyException();
		}
		int temp = data[topIndex];
		topIndex--;
		return temp;
	}
	
	public boolean isEmpty() {
		return topIndex == -1;
	}
}
