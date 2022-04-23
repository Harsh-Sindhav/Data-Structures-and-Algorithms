package recursion;
public class MergeSort {
	
	public static void mergeSort(int arr[],int si,int ei) {
	    if(si>=ei)return;
		int mid = (si+ei)/2;  
		mergeSort(arr,si,mid);
		mergeSort(arr, mid+1, ei);
		merge(arr,si,ei);
	}
	
	public static void merge(int arr[],int si,int ei) {
		int size = ei-si+1;
        int mid =(si+ei)/2;   // eg: agar si 8 hain aur ei 10 hain so, ei - si = 2 but elements toh 3 hain so size hoga ei - si + 1
        int out[] =new int[size];
        int i=si;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=ei) {
        	if(arr[i]<arr[j]) {
        		out[k]=arr[i];i++;k++;
        	}else {
        		out[k]=arr[j]; j++;k++;
        	}
        }
        while(i<=mid) {
        	out[k]=arr[i];k++;i++;
        }
        while(j<=ei) {
        	out[k]=arr[j];k++;j++;
        }
       //very important
        for(int index = 0;index< out.length;index++) {
        	arr[si+index] = out[index];
        }
	}
	
	public static void main(String[] args) {
		int arr[] = {7,6,5,4,3,2,1};
		mergeSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}
