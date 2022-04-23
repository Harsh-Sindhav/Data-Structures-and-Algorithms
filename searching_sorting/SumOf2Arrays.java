package searching_sorting;

public class SumOf2Arrays {
public static void ArraySum(int arr1[],int arr2[],int output[] ) {
	
	int i = arr1.length-1;
	int j = arr2.length-1;
	int carry = 0;
	
	// size of o/p array should be one size greater than the one with largest size
	int k = Math.max(arr1.length, arr2.length);
    while(i>=0 && j>=0) {
    	int sum = arr1[i] + arr2[j] + carry;
    	output[k] = sum % 10;
    	carry = sum/10;
    	i--;
    	j--;
    	k--;    	
    }
    while(i>=0) {
    	int sum = arr1[i] + carry;
    	output[k] = sum % 10;
    	carry = sum / 10;
    	i--;
    	k--;
    }
    
    while(j>=0) {
    	int sum = arr2[j] + carry;
    	output[k] = sum % 10;
    	carry = sum / 10;
    	j--;
    	k--;
    }    
    output[0] = carry;
	
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[] = {9,9,4};
       int arr2[]= {2,4};
      int output[] = new int[Math.max(arr.length, arr2.length) + 1];
      ArraySum(arr, arr2, output);
	
      for(int i : output) {
    	  System.out.println(i);
      }
	
	
	}

}
