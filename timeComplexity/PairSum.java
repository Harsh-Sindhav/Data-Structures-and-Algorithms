package timeComplexity;

import java.util.Arrays;
import java.util.HashMap;

public class PairSum {
	// nlogn + n and only true for unique elements only
	public static int pairSum(int arr[],int n) {
		Arrays.sort(arr);
		int i =0 , j = arr.length-1 , count = 0;
		while(i < j) {
			if(arr[i] + arr[j] == n) {
				count++;
				i++;
				j--;
			}else if(arr[i] + arr[j] < n) {
				i++;
			}else {
				j--;
			}
		}

		return count;
	}
	
	static int printPairs(int arr[], int n,int sum){
         int ans = 0;
     // Store counts of all elements in map m
          HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();

           // Traverse through all elements
          for(int i = 0; i < n; i++){

     // Search if a pair can be formed with
     // arr[i].
            int rem = sum - arr[i];
       if (mp.containsKey(rem)){
        int count = mp.get(rem);
     ans+=count;  
// for(int j = 0; j < count; j++)
//     System.out.print("(" + rem +
//                     ", " + arr[i] +
//                      ")" + "\n");
}
if (mp.containsKey(arr[i]))
{
 mp.put(arr[i], mp.get(arr[i]) + 1);
}
else
{
 mp.put(arr[i], 1);
}
}
return ans;
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[] = {1,3,3,4,5,8,9,9,9,15};
      int n = 12;
      int x = pairSum(arr, n);
      System.out.println(x);
	}

}
