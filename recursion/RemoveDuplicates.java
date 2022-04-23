package recursion;

public class RemoveDuplicates {
public static String removeDuplicates(String s) {
	if(s.length() <= 1) return s;
	String ans ="";
	if(s.charAt(1)!=s.charAt(0))   ans+= s.charAt(0);
	String smallAns = removeDuplicates(s.substring(1));
	return ans + smallAns;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   String s ="aaaabbbbxxxxxyyyv";
   String a = removeDuplicates(s);
   System.out.println(a);
	}

}
