package recursion;

public class SumOfArray {
public static int sumOfArray(int arr[]) {
	if(arr.length == 1) return arr[0];
	int smallArr[] = new int[arr.length-1];
	for (int i = 1; i < arr.length; i++) {
		smallArr[i-1]=arr[i];
	}
	int smallAns = sumOfArray(smallArr);
	int sum = smallAns;
	return sum+=arr[0];
	
}

public static int sum(int input[]) {
    int si = 0;
    int ei = input.length - 1;
    
  return sum(input,si,ei);	
}

public static int sum(int input[],int si,int ei){
    
    if(input.length == 0)return 0; 
    
    if(si == ei){
        return input[si];
    }
    
    // OR
    
//    if(si > ei) {
//    	return 0;
//    }
    
    
    int smallAns = sum(input,si+1,ei);
    
    return input[si] + smallAns;
    
    
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1,5,3,4,6};
	     int sum =sumOfArray(arr);
	     System.out.println(sum);
	}

}
