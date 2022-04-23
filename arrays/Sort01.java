package arrays;

public class Sort01 {
	 public static void sortZeroesAndOne(int[] arr) {
	    	//Your code goes here
	        int i = 0; 
	        int j = arr.length-1;
	        while(i<j){
	            if(arr[i] == 0 && arr[j] == 1){
	                i++;
	                j--;
	                continue;
	            }
	            if(arr[i] == 0){
	                i++;
	            }
	            if(arr[j] == 1){
	                j--;
	            }
	            if(arr[i] == 1 && arr[j] == 0 ){
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	                i++;
	                j--;
	            }            
	        }
	    }
	 
	 
	 public static void sort01(int[] arr) {
		 
		 int nextZero = 0;
	        for(int i = 0;i<arr.length;i++){
	            if(arr[i]==0){
	                int temp = arr[nextZero];
	                arr[nextZero] = arr[i];
	                arr[i] = temp;
	                nextZero++;
	            }
	        }
			 
		 
	 }
	 
	
	 public static void sort01CN(int[] arr) {
	 
		 int zeroPos = 0;
		 int current = 0;
		 while(current < arr.length) {
	
			 if(arr[current] == 0) {
			 
				 int temp = arr[current];
				 arr[current] = arr[zeroPos];
				 arr[zeroPos] = temp;
				 zeroPos++;
			 }
	 current++;	 
		 }
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {0,1,0,1,0,1,0,1,0,1,0};
		sort01CN(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
	}

}
