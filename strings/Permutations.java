package strings;

import java.util.Arrays;
import java.util.Scanner;

public class Permutations {
	
	public static boolean isPermutation(String a, String b) {
	 
		if(a.length() != b.length()) return false;
		
	 char[] a1 = a.toCharArray();
	 Arrays.sort(a1);
	 char[] b1 = b.toCharArray();
	 Arrays.sort(b1);
	 for (int i = 0; i < b1.length; i++) {
		if(a1[i] != b1[i]) return false;
	}
		
	return true;	
	}
	
	
public static boolean isPermutationBetter(String a, String b) {
	if(a.length()!=b.length()) return false;
	int freq [] = new int[256];
	for (int i = 0; i < a.length(); i++) {
		char ch = a.charAt(i);
	    freq[ch]++;
	}
	for (int i = 0; i < b.length(); i++) {
		char ch = b.charAt(i);
	    freq[ch]--;
	}
	
	for (int i = 0; i < 256; i++) {
		if(freq[i]!=0) {
			return false;
		}
	} 
	
	return true; 
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
    String a = s.nextLine();
    String b = s.nextLine();
    // race rate hearts earth listen silent

    
    boolean check = isPermutation(a, b);
    System.out.println(check);
    s.close();
	}

}
