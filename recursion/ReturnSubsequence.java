package recursion;

public class ReturnSubsequence {
public static String[] returnSubseq(String s) {
	if(s.length()==0) {
		String[] ans = {""};
		return ans;
	}
	String[] smallAns = returnSubseq(s.substring(1));
	String ans[] = new String[2*smallAns.length];
     int k = 0;
	for (int i = 0; i < smallAns.length; i++) {
		// ans[i] = smallAns[i];
		ans[k] = smallAns[i];
		k++;
	}
	for (int i = 0; i < smallAns.length; i++) {
		// ans[i + smallAns.length] = smallAns[i]; 
		ans[k] = s.charAt(0) +  smallAns[i];
		k++;
	}
	return ans;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s = "xyz";
      String x[] = returnSubseq(s);
      for (int i = 0; i < x.length; i++) {
		System.out.println(x[i]);
	}
	}

}
