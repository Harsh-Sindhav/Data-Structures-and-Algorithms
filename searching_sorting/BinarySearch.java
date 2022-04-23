package searching_sorting;

public class BinarySearch {
	public static int binarySearch(int arr[],int x) {
		// for sorted arrays only!!!
		 int start =0;
			int end = arr.length-1;
			
			
			while(start<=end) {
			int mid = (end+start)/2;  // or mid=start+(end-start)/2 is used in cp coz if we use s+e/2 in cp then it may crosses the limit and may give tle if the test cases is too large
			if(x==arr[mid]){
				return mid;}
			else if(x < arr[mid]) {
				end = mid-1;}
			else {
	           start = mid + 1;			
			}
	    }
		   return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[] = {1 ,3 ,7 ,9 ,11 ,12 ,45} ;
      int n = binarySearch(arr, 7);
      System.out.println(n);
	}

}
