package finalHashMap;

import java.util.HashMap;

public class LongestSubsetZeroSum {

	public static int longestSubsetZeroCount(int[] arr) {
	
		HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
		int n = arr.length;
		
		for(int i=1;i<n;i++) {
			arr[i] += arr[i-1];
		}
		
		int len = 0;
		
		for(int i=0;i<n;i++) {
			if(arr[i] == 0) {
				// for eg if arr is sth like this 2 -2 2 -2 2 -2 then after the above addition iteration step then updated arr become 2 0 0 0 0 0 and ans would be 6 that is longestcontSubseq len is 6 !!! xD
				if(len < i+1) {
					len = i + 1; // +1 coz index starting 
				}
			}else if(map.containsKey(arr[i])){
				if(len < i - map.get(arr[i])) {
					len = i - map.get(arr[i]);
				}
			}else {
				map.put(arr[i], i);
			}
		}
	
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
