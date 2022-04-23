package finalHashMap;

import java.util.HashMap;

public class MaxFreqNo {

	public static int maxFreqNo(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
	   for(int i:arr) {
		   if(map.containsKey(i)) {
			   map.put(i, map.get(i)+1);
		   }  else {
			   map.put(i, 1);
		 }  
	   }
	int max = 0, ans = Integer.MIN_VALUE;
	for(int i: arr) {
		if(map.get(i) > max) {
			max = map.get(i);
			ans = i;
		}
	}

	return ans;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
