package searching_sorting;

public class MergeTwoSortedArrays {
	public static int[] merge(int arr1[],int arr2[]){
		int ans[]=new int[arr1.length+arr2.length];
		int i=0, j=0, k=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] < arr2[j]) {
				ans[k]=arr1[i];
				k++;
				i++;
			}else {
				ans[k]=arr2[j];
				k++;
				j++;
			}
		}
		while(i<arr1.length) {
			ans[k]=arr1[i];
			k++;
			i++;;
		}
		while(j<arr2.length) {
			ans[k]=arr2[j];
			k++;
			j++;;
		}
		return ans;
	}
		public static void main(String[] args) {
	      int arr1[] = {1 ,3 ,4 ,7 ,11};
	      int arr2[] = {2 ,4 ,6 ,13};
	      int a[] = merge(arr1, arr2);
	      for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	     
		  
		}


}
