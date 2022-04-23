package backtracking;

public class SubsetSumToK {

 public static int subsetCount(int arr[],int n,int index,int target) {
	 
	if(index == n) {
		if(target ==0) {
			return 1;
		}else {
			
			return 0;
		}		
	} 
	 
	 int count =0;
	 
	 if(target - arr[index] >= 0) {
		 count += subsetCount(arr, n, index+1, target-arr[index]);
	 }
	 count+= subsetCount(arr, n, index+1, target);
	 return count;
	 
 }


public static void main(String[] args) {
	
	int arr[] = {2,4,4,3,1};
	int ans = subsetCount(arr, arr.length, 0, 6);
	System.out.println(ans);
	
	
	
}
}
