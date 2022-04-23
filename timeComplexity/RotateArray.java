package timeComplexity;

public class RotateArray {
	public static void swapElem(int[]arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
public static void ReverseArray(int arr[],int i,int j) {
	while(i<j) {
		swapElem(arr,i,j);
		i++;
		j--;
	}
}
public static void rotateArray(int arr[],int d) {
	if(arr.length == 0)return;
	if(d>=arr.length && arr.length != 0) {
		d%=arr.length;
	}
//	ReverseArray(arr, 0, arr.length-1);
//	ReverseArray(arr, 0, d-1);
//	ReverseArray(arr, d, arr.length-1);  // O(n) 

	 ReverseArray(arr, 0, arr.length-1);
	 ReverseArray(arr, 0, arr.length-d-1);
	 ReverseArray(arr, arr.length-d, arr.length-1);
	
	
}

public static void rotateArr2(int[] arr,int d) {
	int[] a = new int[d];
	for(int i=0;i<d;i++) {
		a[i] = arr[i];
	}
	for(int i=d;i<arr.length;i++) {
		arr[i-d] = arr[i];
	}
	for(int i=0;i<d;i++) {
		arr[arr.length-d+i] = a[i]; 
	}
	
}

      public static void rotateArray1(int arr[],int d) {
    	
    	  
    	  for(int i=0;i<d;i++) {
//    		  int temp = arr[arr.length-1];
    		  int temp = arr[0];
//    		  for(int j=arr.length-1;j>0;j--)
    		  for(int j=1;j<arr.length;j++){
//    			  arr[j] = arr[j-1];
    			  arr[j-1] = arr[j];
    		  }
//    		  arr[0] = temp;
    		  arr[arr.length-1] =temp;
    	  }
    	  
    	  
      }
      
      


	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[] = {1 ,2 ,3 ,4 ,5 ,6 ,7};
int d = 2;
//rotateArr2(arr, d);
// rotateArray1(arr, d);
rotateArray(arr, d);
 for (int i = 0; i < arr.length; i++) {
	 System.out.print(arr[i] + " ");
}
	
	}

}
