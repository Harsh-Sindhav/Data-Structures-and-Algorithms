package queue;
import java.util.Stack;

public class QueueUsingStack<T> {

	public Stack<T> s1;
	public Stack<T> s2;
	
	public QueueUsingStack(){
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
    
	public void enqueue(T elem) {
		s1.push(elem);
			}

	 public T dequeue() throws QueueEmptyException{
		 
		 if(s1.isEmpty()) {
			 throw new QueueEmptyException();
		 }
		 
		 while(!s1.isEmpty()) {
			 s2.push(s1.pop());
		 }
		
		T x =  s2.pop();
		while(!s2.isEmpty()) {
			s1.push(s2.pop());	
		}
		 
		return x;
	 }
	 
	 public T rear() throws QueueEmptyException  {
		 
		 if(s1.isEmpty())  throw new QueueEmptyException();
		 
		 return s1.peek();
	 }
	 
	 public T front()  throws QueueEmptyException{
		 if(s1.isEmpty()) {
			 throw new QueueEmptyException();
		 }
		 
		 while(!s1.isEmpty()) {
			 s2.push(s1.pop());
		 }
		
		T x = s2.peek();
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());	
		}
			
		return x;
	 }
	
	

}
