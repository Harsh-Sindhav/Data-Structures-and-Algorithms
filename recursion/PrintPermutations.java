package recursion;

import java.util.ArrayList;

public class PrintPermutations {

	public static ArrayList<String> ans = new ArrayList<>();
	
	public static ArrayList<String> findPermutations(String s){
		
		char[] arr = s.toCharArray();
		
		FindPermutationsHelper(arr,0,arr.length-1);
		return ans;
		
	}
	
	
	private static void FindPermutationsHelper(char[] a,int si,int ei) {
		
		//we're following top down approach here
		if(si >= ei) {
			String permutation = "";
		
		for(int k=0;k<a.length;k++) {
			permutation += (a[k]);
		}
		
//		System.out.print(permutation + " ");
		ans.add(permutation);
		return;
		}
		
		for(int k = si; k <= ei; k++ ) {
			swap(a,si,k);
			FindPermutationsHelper(a, si + 1, ei);
			
		}
	}
	
	private static void swap(char[] a,int i, int j) {
		char te = a[i];
		a[i] = a[j];
		a[j] = te;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "adj";
		findPermutations(s);
//	    for(String i : ans) {
//	    	System.out.println(i);
//	    }
		
		System.out.print(ans);
		
		
	}

}
