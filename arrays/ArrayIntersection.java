package arrays;
import java.util.*;

public class ArrayIntersection {

public static int min(int a,int b) {
	if(a<b)return a;
	else 
		return b;
	}
public static void intersection(int arr1[],int arr2[]) {
	
	Arrays.sort(arr1);
	Arrays.sort(arr2);
	int min = min(arr1.length,arr2.length);
	int i=0,j=0;
	while(i<min) {
		if(arr1[i] == arr2[j]) {
			System.out.print(arr1[i] + " ");
		}else if(arr1[i] > arr2[j]) {
			j++;
		}else {
			i++;
		}
	}
}

public static void intersectionCN(int arr[],int arr2[]) {
	
	for (int i = 0; i < arr2.length; i++) {
		for (int j = 0; j < arr.length; j++) {
			
				
		  if(arr2[i] == arr[j]) {
			  System.out.print(arr2[i]+ " ");
			  arr[j] = Integer.MIN_VALUE;
		  }
						
		}
	}
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		int arr1[]= {2, 6, 1, 2};
		int arr2[]= {1, 2, 3, 4, 2};
		intersectionCN(arr1, arr2);
		
		
	}

}
