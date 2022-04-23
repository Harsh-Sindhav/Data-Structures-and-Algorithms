package recursion;

public class LastIndexOfNo {
	public static int findIndex(int arr[],int x,int LastIndex) {
	//	
		if(LastIndex < 0) return -1;
		if(arr[LastIndex]==x)return LastIndex;
	   int smallAns = findIndex(arr, x, LastIndex-1);
	   return smallAns;
	}
	
	// if given only si then the way to find the last index is going deep !!
	
	public static int findindex(int arr[],int x) {
      int si =0;
		return lastindexhelper(arr,x,si);
	
	}	
		private static int lastindexhelper(int[] arr, int x, int si) {
		// TODO Auto-generated method stub
		
			if(arr.length ==0) return -1;
			if(si == arr.length) return -1;
			
			int smallAns = lastindexhelper(arr, x, si+1);
			if(smallAns != -1) {
				return smallAns;
			}
			
			if(arr[si] == x) return si;
			else return -1;
	}

		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	       int arr[] = {1,2,2,3,3,4,5};
	       int x = 3;
	       int ans = findIndex(arr, x, arr.length-1);
	       System.out.println(ans);
		}

}
