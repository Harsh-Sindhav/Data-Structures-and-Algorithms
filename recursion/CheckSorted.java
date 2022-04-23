package recursion;

public class CheckSorted {
public static boolean checkSorted(int arr[]) {
	if(arr.length<=1) return true;
	int smallArr[] = new int[arr.length-1];
	for(int i=1;i<arr.length;i++) {
		smallArr[i-1]=arr[i];
	}
	boolean smallAns = checkSorted(smallArr);
	if(!smallAns) {
		return false;
	}
	if(arr[0]<=arr[1]) {
		return true;
	}else {return false;}
		
}
public static boolean checkSorted2(int arr[]) {
	if(arr.length<=1) return true;
	if(arr[0]>arr[1])return false;
	int smallArr[] = new int[arr.length-1];
	for(int i=1;i<arr.length;i++) {
		smallArr[i-1]=arr[i];
	}
	boolean smallAns = checkSorted(smallArr);
	return smallAns;
	
}
private static boolean checkSortedBetter(int arr[], int startIndex) {
	if(startIndex >= arr.length -1) {
		return true;
	}
	if(arr[startIndex]>arr[startIndex+1]) {
		return false;
	}
	boolean smallAns = checkSortedBetter(arr, startIndex+1);
	return smallAns;
}
public static boolean checkSortedBetter(int arr[]) {
	
	return checkSortedBetter(arr, 0);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int arr[] = {1,5,3,4,6};
     int arr2[] = {1,2,3,4,5,6};
     boolean check =checkSortedBetter(arr);
     System.out.println(check);
     boolean check2 =checkSortedBetter(arr2);
     System.out.println(check2);
	}

}
