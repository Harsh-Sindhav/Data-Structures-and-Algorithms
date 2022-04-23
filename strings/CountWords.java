package strings;

public class CountWords {
public static int countWords(String str) {
	if(str.length()==0)return 0;
	int spaces = 0;
	for (int i = 0; i < str.length(); i++) {
		if(str.charAt(i)==' ')spaces++;
	}
	return spaces+1;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  String s ="hi harsh how are you";
  int x = countWords(s);
	System.out.println(x);
	}

}
