package recursion;

public class PrintSubsetsofArray {

	public static void printSubset(int arr[],int si,int output[]) {
		if(si == arr.length) {
			for(int i : output) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		int[] newOutput = new int[output.length + 1];
		int i =0;
		for( ;i< output.length;i++) {
			newOutput[i] = output[i];	
		}
		newOutput[i] = arr[si];
		printSubset(arr, si + 1, output);
		printSubset(arr, si + 1, newOutput);
	}
	
	public static void printSubset(int arr[]) {
		int output[] = new int[0];
		printSubset(arr, 0, output);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}
