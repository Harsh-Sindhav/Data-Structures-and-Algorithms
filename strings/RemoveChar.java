package strings;

public class RemoveChar {
public static String removeX(String s,char x) {
	String ans ="";
	for(int i=0;i<s.length();i++) {
		if(s.charAt(i)!=x) {
			ans+=s.charAt(i);
		}
	}
	return ans;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 String s ="aaabbsssasaaa";
char x= 'a';
 String z= removeX(s, x);
	System.out.println(z);
	}

}
