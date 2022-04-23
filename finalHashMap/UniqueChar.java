package finalHashMap;

import java.util.HashMap;

public class UniqueChar {

	public static String uniqueChar(String s) {
	
		if(s.length() == 0) {
			return "";
		}
		String ans = "";
		HashMap<Character, Boolean> hm = new HashMap<>();
		for(int i =0 ; i < s.length();i++) {
			char currChar = s.charAt(i);
			if(!hm.containsKey(currChar)) {
				hm.put(currChar, true);
				ans+=currChar;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
	}
	
}
