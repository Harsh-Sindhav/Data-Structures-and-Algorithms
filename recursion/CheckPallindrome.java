package recursion;
import java.util.*;
//import javax.swing.text.StyleContext.SmallAttributeSet;

public class CheckPallindrome {
	
	public static boolean isPallindrome(String str) {
		if(str.length()<=1) {
			return true;
		}
		if(str.charAt(0)==str.charAt(str.length()-1)) {
			return isPalindrome(str.substring(1, str.length()-1));
		}else {
			return false;
		}
	}
	
	
	public static boolean isPallindrome(String str,int si,int ei) {
		if(si>=ei) return true;
		
		if(str.charAt(si) == str.charAt(ei)) {
			return isPallindrome(str, si+1, ei-1);
		}else {
			return false;
		}
		
	}
	
	
	 public static boolean checkPalindrome(String str, int s, int e) {
		 if(s>=e)return true;
		 if(str.charAt(s)!=str.charAt(e)) return false;
		 if(s<e) {
		boolean smallAns = checkPalindrome(str, s+1, e-1);
	     return smallAns;
		 }
		 return true;
	 }    
	    public static boolean isPalindrome(String str) 
	    { 
	        int n = str.length();   
	    // If string is empty,then it is palindrome 
	        if (n == 0) 
	            return true;   
	        return checkPalindrome(str, 0, n - 1); 
	    }   
	    // Driver Code 
	    public static void main(String args[]) 
	    { 
	        //Take input from the user
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the String :");
	        String str = sc.nextLine();   //Input the string
	        //Check whether palindrome or not
	        if (isPalindrome(str)) 
	            System.out.println(str+" is palindrome"); 
	        else
	            System.out.println(str+ " is not a palindrome"); 
	    }   
}
