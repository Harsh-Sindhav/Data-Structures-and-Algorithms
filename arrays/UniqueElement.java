package arrays;

import java.util.Arrays;

       public class UniqueElement {
        public static int Unique(int arr[]) {
	int res = 0;
	for (int i = 0; i < arr.length; i++) {
		res = res ^ arr[i];
	}
	return res;
   }
    public static int Unique2(int arr[]) {
    	if(arr.length <= 1){
    	    return arr[0];
    	     }
	for (int i = 0; i < arr.length; i++) {
		int j;
		for ( j=0; j < arr.length; j++) {
			if(i != j) {
				if(arr[i]==arr[j]) {
					break;
				}
			}
		}
		if(j == arr.length)
		return arr[i];
	}
	return Integer.MAX_VALUE;
      }

     public static int unique3(int arr[]) {
	if(arr.length <= 1){
    return arr[0];
     }
      Arrays.sort(arr);
    int i = 0;
    while(i < arr.length){

     if(arr[i+1] != arr[i]) {
   return  arr[i];
    
  }
   i+=2;
    }
         return Integer.MAX_VALUE;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int arr[] = {2, 3, 1, 6, 3, 6, 2};
   int c =   Unique2(arr);
     System.out.println(c);
    
     
	}

}
