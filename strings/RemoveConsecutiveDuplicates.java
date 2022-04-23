package strings;

public class RemoveConsecutiveDuplicates {
	
   public static String duplicates(String s) {
	String t = "";
	t+=s.charAt(0);
	for(int i=1;i<s.length();i++) {
		if(s.charAt(i)!=s.charAt(i-1)) {
			t+=s.charAt(i);
		}
		
	}
	return t;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s = "aaabbccdd";
String t = duplicates(s);
	System.out.println(t);
	
	
	}

}
