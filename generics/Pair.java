package generics;



public class Pair<T,V> {
	  
	private T first;
	private V second;
	
	public Pair(T first, V second){
		this.first = first;
		this.second = second;
	}
 	
   public T getFirst() {
	   return first;
   }
	
	public void setFirst(T first) {
		this.first = first;
	}

	 public V getSecond() {
		   return second;
	   }
		
		public void setSecond(V second) {
			this.second = second;
		}	
		
		
//public class Pair<T> {
//  
//	private T first;
//	private T second;
//	
//	public Pair(T first, T second){
//		this.first = first;
//		this.second = second;
//	}
// 	
//   public T getFirst() {
//	   return first;
//   }
//	
//	public void setFirst(T first) {
//		this.first = first;
//	}
//
//	 public T getSecond() {
//		   return second;
//	   }
//		
//		public void setSecond(T first) {
//			this.second = second;
//		}	
	
	
}
