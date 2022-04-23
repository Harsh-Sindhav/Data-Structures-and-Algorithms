package recursion;

public class RemoveX {
public static String removeX(String s) {
	if(s.length()==0) {
		return s;
	}
// iss ques me chahe pehle recursive call krdo ya baad me baat ek hi hain
//	String smallAns = removeX(s.substring(1));
	String ans = "";
	if(s.charAt(0) != 'x') ans += s.charAt(0); 
	String smallAns = removeX(s.substring(1));
	return ans+smallAns;
}


public static String removeX1(String s) {
  
if(s.length() == 0) return "";

if(s.charAt(0)=='x') return removeX1(s.substring(1));

return s.charAt(0) + removeX1(s.substring(1));

}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s = "hxarsh";
//      String ans = removeX(s);
      String ans = removeX1(s);
      System.out.println(ans);
	}

}
