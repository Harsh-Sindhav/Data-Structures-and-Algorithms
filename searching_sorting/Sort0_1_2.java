package searching_sorting;

//import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Sort0_1_2 {
	
	public static void swap(int a , int b) {
		
		int temp = a;
		a = b;
		b = temp;
	
	}
	
	
	
	public static void sort012better(int arr[]) {
		
	int current = 0, zeroPos = 0, twoPos = arr.length-1;

		while(current <= twoPos) {
			
	    if(arr[current] == 0) {
	    	
//	    swap(arr[current], arr[zeroPos]);
	    	int temp = arr[current];
			arr[current] = arr[zeroPos];
			arr[zeroPos] = temp;    
	    	zeroPos = zeroPos + 1;
	    	current = current + 1;
	    	
	    }else if(arr[current] == 2) {
//	    	current = current + 1;
	    	int temp = arr[current];
			arr[current] = arr[twoPos];
			arr[twoPos] = temp;    
	    	twoPos = twoPos -1;
	    }else {
//	    	swap(arr[current], arr[twoPos]);
	    	current = current + 1;
	    	
	    }
	    
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[] = {0, 1 ,2, 0 ,2 ,0 ,1};
       sort012better(arr);
for (int i = 0; i < arr.length; i++) {
	System.out.println(arr[i]);
}
	}

}
