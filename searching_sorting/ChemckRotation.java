package searching_sorting;

public class ChemckRotation {

	public static int Check(int arr[]) {
		
		for(int i =0;i<arr.length;i++) {
			if(arr[i]>arr[i+1])
				return (i+1);
		}
		return 0;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
