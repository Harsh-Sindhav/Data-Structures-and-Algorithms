package arrays;

public class ArrangeNosInAnArray {

	public static void arrange(int[] arr, int n) {
   	 int left = 0;
   	 int right = n-1;
   	 int counter =1;
   	 while (left<=right) {
			if(counter%2==1) {
				arr[left]=counter;
				counter+=1;
				left+=1;
			}else {
				arr[right]=counter;
				counter+=1;
				right-=1;
			}
		}
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[] = new int[5];
      arrange(arr, 5);
      for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
	}
	}

}
