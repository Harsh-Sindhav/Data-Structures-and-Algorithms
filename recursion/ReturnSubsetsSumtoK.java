 package recursion;

public class ReturnSubsetsSumtoK {

	private static int[][] subsetSumk(int[] arr, int si, int k) {
		// TODO Auto-generated method stub
		if(si == arr.length) { 
			if(k==0)
			return new int[1][0];
		else return new int[0][0];
		}
		
		// SOP arr[0][0] gives index out of bound exception !
		
		int[][] smallOutput1 = subsetSumk(arr, si+1, k);
		int[][] smallOutput2 = subsetSumk(arr, si+1, k-arr[si]);	
		int[][] Output = new int[smallOutput1.length + smallOutput2.length][];
		int index = 0;
		for(int i =0 ; i < smallOutput1.length; i++) {	
			Output[index++] = smallOutput1[i];
		}	
		for(int i = 0; i < smallOutput2.length; i++) {	
		Output[index] = new int[smallOutput2[i].length + 1];
		Output[index][0] = arr[si];
		for(int j =0; j < smallOutput2[i].length; j++ ) {
		Output[index][j+1] = smallOutput2[i][j];
		}
		index++;
		}
	    return Output;
	}
	
	public static int[][] subsetSumK(int arr[],int k){
		return subsetSumk(arr,0,k);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {5,12,3,17,1,18,15,3,17};
		int k = 6;
		int[][] arr2 = subsetSumK(arr, k);
		for(int i =0 ; i< arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
