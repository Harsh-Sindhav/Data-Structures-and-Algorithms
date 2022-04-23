package priorityQueue;

public class CheckMaxHeap {

	static boolean checkMaxHeap(int arr[]) {
		int n = arr.length;
		for(int i=0;2*i+1<n;i++) {
			int left = 2 * i  + 1;
			int right = left+1;
		  if(arr[i] < arr[left]) {
			  return false;
		  }
		  if(right < n && arr[i] < arr[right]) {  
			  return false;
		  }
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
	}
}
