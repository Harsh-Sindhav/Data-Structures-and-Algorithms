package recursion;

public class ReplaceChar {
public static String replaceChar(String str,char a,char b) {
	if(str.length()==0)return str;
	String ans = "";
	if(str.charAt(0) != a) ans+=str.charAt(0);
	else if(str.charAt(0)==a) ans+=b;
	String smallAns = replaceChar(str.substring(1),a,b);
	return ans + smallAns;
}

public static String replaceChar2(String str,char a,char b) {

	if(str.length() <1) {
		return str;
	}
	
	String smallAns = replaceChar(str.substring(1), a, b);
	if(str.charAt(0) == a) {
		return b + smallAns;
	}else {
		return str.charAt(0) + smallAns;
	}
	
	
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
  String s = "harsh";
  char a = 'h';
  char b = 'b';
  String c = replaceChar2(s, a, b);
  System.out.println(c);
	}

}
