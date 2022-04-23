package strings;

public class Pallindrome {
	
	public static boolean checkPallindrome(String s) {
		
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			r = s.charAt(i) + r ;
		}
		
		boolean checkPallindrome = false;
		
			if(s.compareTo(r) == 0) {
			return	checkPallindrome = true;
			   
		}
			
			// this is also true 	 
//			if(s.equals(r)) {
//				return	checkPallindrome = true;
//				   
//			}
			
		
			
//			this is also true 
			// bad solution coz running loop and same i.e. comparision has been done by compareTo Statement !
//		for(int i = 0; i < s.length(); i++) {
//			
//			if(s.charAt(i) != r.charAt(i)) {
//				
//				return checkPallindrome = false;
//				
//			}
//			
//		}
		
		
		return checkPallindrome;
	}
	
	
	
public static boolean checkPallindromeBetter(String s) {
	int i =0;
	int j = s.length()-1;
	while(i<j) {
		if(s.charAt(i)!=s.charAt(j)) {return false;}
		else if(s.charAt(i)==s.charAt(j)) {i++; j--;}
	}
	return true;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 String s= "naman";
 boolean check =checkPallindrome(s);
 System.out.println(check);
	}

}
