package strings;

public class ReverseAString {

	public static String reverseStr(String str) {
		String r = "";
		for(int i = str.length()-1;i >=0;i--) {
			r+=str.charAt(i);
		}
		return r;
	}
	
	public static String reverseStr1(String str) {
	    String r = "";
		for(int i=0;i<str.length();i++) {
//		 r+=s.charAt(i);
		  r = str.charAt(i) + r;
	  }
	
	return r;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  String s = "harsh";
//  String r = reverseStr(s);
  String r = reverseStr1(s);

  System.out.println(r);
	}

}
