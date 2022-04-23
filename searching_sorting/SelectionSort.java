package searching_sorting;

public class SelectionSort {
      
	 public static void selectionsort(int arr[]) {
	    for (int i = 0; i < arr.length-1; i++) {
		 	int min = arr[i];    // lets assume min value is at index 0
			int min_index = i;
	       for (int j = i+1; j < arr.length; j++) {
			if(arr[j] < min) {
				min = arr[j];
				min_index = j;
		 }
		}
           if(min_index != i ) {   
        	   arr[min_index]=arr[i];
        	   arr[i]= min;
           }
		}
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {69,44,12,0,5,16};
        selectionsort(arr);
        for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
