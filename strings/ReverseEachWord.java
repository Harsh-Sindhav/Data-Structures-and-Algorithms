package strings;


public class ReverseEachWord {
public static String reverseString(String s) {
	int currindex = 0;
	String ans = "";
	int i=0;
	for( ;i<s.length();i++) {
		if(s.charAt(i)==' ') {
			int end =i;
			String rev = "";
			for(int j=currindex;j<end;j++) {
				rev = s.charAt(j)+rev;
			}
			ans+=rev+" ";
		currindex = i+1;
		}
	}
	int end =i; 
	String rev = "";
	for(int j=currindex;j<end;j++) {
		rev = s.charAt(j)+rev;
	}
	ans+=rev;
currindex = i+1;

	return ans;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String s = "my name is harsh";
     System.out.println(reverseString(s));
	}
}
