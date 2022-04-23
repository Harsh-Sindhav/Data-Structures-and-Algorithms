package arrays;

public class SwapAlternate {
	public static void swapAlternate(int arr[]) {
		for(int i=0;i<arr.length-1;i+=2) {
				arr[i]=arr[i] ^ arr[i+1];
				arr[i+1]=arr[i] ^ arr[i+1];
				arr[i]=arr[i] ^ arr[i+1];
			}
	} 

	public static void swapAlternate1(int arr[]) {		
		int ans[] = new int[arr.length];
		for(int i = 0;i<arr.length-1;i = i + 2) {
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int arr[] = {1,2,3,4,5,6,7};
    swapAlternate1(arr);
      for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
	}
	 }
}
