package searching_sorting;

public class PushZeroesToEnd {
	
public static void pushZeroesToEnd(int arr[]) {
		int nonZeroPos = 0;
		for(int i=0;i < arr.length;i++) {
		if(arr[i] != 0) {
		int temp = arr[i];
		arr[i]=arr[nonZeroPos];
		arr[nonZeroPos]=temp;
			nonZeroPos++;
		
				}
		}
}
		
public static void pushZeroesToEnd1(int arr[]) {

     int temp[] = new int[arr.length];
     int i =0,k=0;
     while(i<arr.length) {
    	 if(arr[i]!=0) {
    		 temp[k] = arr[i];
    		 i++;
    		 k++;
    	 }else if(arr[i] ==0 ) {
    		i++; 
    	 }
    }
   
     for(int j =0;j<arr.length;j++) {
    	 arr[j] = temp[j];
     }



}




public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[] = {5 ,3 ,0 ,1 ,3 ,0 ,0};
//       int arr1[] = new int[arr.length];
       pushZeroesToEnd1(arr);
       for (int j = 0; j < arr.length; j++) {
    	   System.out.println(arr[j]);
	}
       
	}

}
