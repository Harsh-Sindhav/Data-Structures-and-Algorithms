package searching_sorting;

public class BubbleSort {

	public static void main(String[] args) {
		
		int arr[] = {5,7,3,1,9,4};
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				// lenght - i - 0 why subtract i ?? bcoz i elements are sorted toh utni baar dubara loop chalane ki zarurat nahi !
				if(arr[j] > arr[j+1]) {
					
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
			}
		}
		for(int i : arr) {
			System.out.println(i);
		}
		
	}

}
