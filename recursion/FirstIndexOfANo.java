package recursion;

public class FirstIndexOfANo {
public static int findIndex(int arr[],int x,int startIndex) {
//	
	if(startIndex > arr.length-1) return -1;
	if(arr[startIndex]==x)return startIndex;
   int smallAns = findIndex(arr, x, startIndex+1);
   return smallAns;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[] = {1,2,2,3,3,4,5};
       int x = 4;
       int ans = findIndex(arr, x, 0);
       System.out.println(ans);
	}

}
