package recursion;

public class BinarySearch {
	public static int binarySearch(int arr[], int x) {
		return binarySearch(arr,0,arr.length-1,x);
	}

	private static int binarySearch(int[] arr, int si, int ei, int x) {
		// TODO Auto-generated method stub
		
		if(si > ei) return -1;
		int mid = (si+ei)/2;
		
		if(arr[mid] == x) return mid;
		else if(arr[mid] > x) {
			return binarySearch(arr, si, mid - 1, x);
		}else {
			return binarySearch(arr, mid+1, ei, x);
		}
	}
	
	
}
