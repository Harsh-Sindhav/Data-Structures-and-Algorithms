package timeComplexity;

public class EquilibriumIndex {
public static int eIndex(int arr[]) {
	int eindex;
	for (int i = 0; i < arr.length; i++) {
		eindex = i;
		
		int ls = 0;
		int rs = 0;
//		int ls = Integer.MIN_VALUE;
//		int rs = Integer.MIN_VALUE;
		for (int j = 0; j <eindex;j++) {
			ls+=arr[j];
		}
		for (int j = eindex+1; j <arr.length ;j++) {
			rs+=arr[j];
		}
		if(ls == rs ) {return eindex;
		}
	}
	return -1;
}

public static int eIndex2(int arr[]) {
	int eindex,totalSum=0,leftSum=0;
	for (int i = 0; i < arr.length; i++) {
		totalSum+=arr[i];
	}
	int rightSum=totalSum;
	for (int i = 0; i < arr.length; i++) {
		rightSum-=arr[i];
		if(leftSum==rightSum) {
			return i;
		}else {
			leftSum+=arr[i];  
		}	
	}
	return -1;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int a[] = {6,1,2,3,4,5,7,3,4,2};
   int x = eIndex(a);
   System.out.println(x);
	}

}
