package priorityQueue;

public class InplaceHeapSort {
	
	public static void downHeapify(int[] arr, int i, int n) { // i--> non leaf nodes, n --> n is the size of the heap i.e upto which index/size the maximum you need to go
		// TODO Auto-generated method stub
		int parentIndex = i;
		int leftChildIndex = 2*parentIndex+1;
		int rightChildIndex = 2*parentIndex+2;
		while(leftChildIndex < n) {
			int minIndex = parentIndex;
			if(arr[leftChildIndex] < arr[minIndex]) {
				minIndex = leftChildIndex;
			}
			
			if(rightChildIndex < parentIndex) {
				minIndex = rightChildIndex;
			}
			if(minIndex == parentIndex) {
				return;
			}
			int temp = arr[parentIndex];
			arr[parentIndex] = arr[minIndex];
			arr[minIndex] = temp;
			parentIndex = minIndex;
			leftChildIndex = 2*parentIndex + 1;
			rightChildIndex = 2*parentIndex + 2;	
		}	
	}
	
	public static void heapSort(int[] arr) {
		// TODO Auto-generated method stub
    	//build the heap
		int n = arr.length;
		for(int i = (n/2)-1;i>=0;i--) {
			downHeapify(arr,i,n); /* n is the size of the heap i.e upto which index/size the maximum you need to go  */ 	
		}
		// remove elements from starting one by one, put them at respective last pos
		for(int i = n-1;i>=0;i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			downHeapify(arr,0,i);
		}	
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			
     int arr[] = {4,7,3,2,8,9,6,1};
     heapSort(arr);
     for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
	 }	
	}
}
