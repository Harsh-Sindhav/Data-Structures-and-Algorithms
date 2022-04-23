package timeComplexity;

import java.util.Arrays;

public class UniqueElement {
	//o(nlogn)
public static int uniqueElement(int arr[]) {
	Arrays.sort(arr);
	if(arr[0] != arr[1]) return arr[0];
	if(arr[arr.length-1] != arr[arr.length-2])return arr[arr.length-1];
	
	for (int i = 1; i < arr.length-1; i++) { 
    if(arr[i] != arr[i-1] && arr[i] != arr[i+1])return arr[i];
}  
	return -1;
}

// o(n)
public static int Unique(int arr[]) {
int res = 0;
for (int i = 0; i < arr.length; i++) {
	res = res ^ arr[i];
}
return res;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[] = {2 ,4 ,4 ,7 ,2 ,7};
int x = uniqueElement(arr);
System.out.println(x);
	}

}
