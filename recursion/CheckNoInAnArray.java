package recursion;

public class CheckNoInAnArray {
public static boolean checkNo(int arr[],int x) {
	if(arr.length  == 0 )return false;	
	if(arr[0]==x)return true; 
	int smallArr[] = new int[arr.length-1];
	for(int i=1;i<arr.length;i++) {
		smallArr[i-1]=arr[i];
	}
	boolean smallAns =  checkNo(smallArr, x);
	return smallAns;
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,5,3,4,6};
		int x = 3;
	     boolean check = checkNo(arr, x);
	     System.out.println(check);
	}

}
