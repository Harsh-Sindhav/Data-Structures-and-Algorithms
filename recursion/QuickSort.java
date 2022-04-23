package recursion;

public class QuickSort {
public static void quickSort(int arr[],int si,int ei) {
	if(si>=ei)return;
	int piv_pos = partition(arr,si,ei);
	quickSort(arr, si, piv_pos-1);	
	quickSort(arr,piv_pos+1,ei);	
	
	}
public static int partition(int arr[],int si,int ei){
	// we choose an element as pivot and for now we have choosen si as pivot element and what we do is ki iss pivot element ko uski sahi position pr pohocha dete hain
 // by correct pos i mean is ki jab sort ho jayega array toh uski sahi pos jaha hogi waha
	
	int pivot = arr[si];
	int count = 0;
	for (int i = si+1; i <= ei; i++) {
		if(arr[i] <= pivot) {
			count++;
		} 
	}
	
	    int pivotIndex=si+count;
		int temp = arr[pivotIndex]; 
		arr[pivotIndex]=arr[si];
		arr[si]=temp;
		int i=si;
		int j=ei;
		while(i<pivotIndex && j>pivotIndex ) {
			if(arr[i] <= pivot) {i++;}
			else if(arr[j] >pivot) {j--;}
			else {
				int temp2 = arr[i];
				arr[i]= arr[j];
				arr[j] = temp2;
				i++;
				j--;
			}	
		}
		return pivotIndex;
	}

	public static void main(String[] args) {
  int arr[] = {9,8,7,6,4,3,3,7,8,5};
  quickSort(arr, 0, arr.length-1);
  for (int i = 0; i < arr.length; i++) {
	System.out.println(arr[i]);
}
	}

}
