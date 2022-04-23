package searching_sorting;

import java.util.Arrays;

public class SecondLargestElement {
	// in case of unique element 
public static int secondLargestElement(int arr[]){
	
	Arrays.sort(arr);
	
	return arr[arr.length-2];
	
	
}


public static int secondLargestElement2(int arr[]) {
	
	if(arr.length<2) {
		return -1;
	}
	
	int l = Integer.MIN_VALUE;
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]>l) {
			l = arr[i];
		}
	}
	int sl = Integer.MIN_VALUE;
	for (int i = 0; i < arr.length; i++) {
		if(arr[i] != l) {
			if(arr[i]>sl) {
				sl = arr[i];
			}
		}
	}
	
	if(sl == Integer.MIN_VALUE) {
		return -1;
	}
	
	return sl;

}


public static int secondLargestElementBetter(int arr[]) {

	if(arr.length<2) {
		return -1;
	}
	
	
int l = Integer.MIN_VALUE;
int sl = Integer.MIN_VALUE;


for (int i = 0; i < arr.length; i++) {
	
	if(arr[i] > l) {
		sl = l;
		l = arr[i];
	}else if(arr[i] > sl && arr[i] != l) {
		sl = arr[i];
	}
	

}

if(sl == Integer.MIN_VALUE) {
	return -1;
}

return sl;



      }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int arr[]= {2 ,13 ,4 ,1 ,3 ,6 ,28};
	int x = secondLargestElementBetter(arr);
	System.out.println(x);
	}

}
