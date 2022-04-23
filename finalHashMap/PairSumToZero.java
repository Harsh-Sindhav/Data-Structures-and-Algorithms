package finalHashMap;

import java.util.HashMap;

public class PairSumToZero {
	public static void pairSumToZero(int[] arr) {
		int finalcount = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				int freq = map.get(arr[i]);
				map.put(arr[i], freq+1);
			}else {
			int	freq = 1;
				map.put(arr[i], freq);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int key =arr[i];
			if(map.containsKey(-key) && map.get(key)!= 0) { 
				int times;
				if(key == (-key)) {
					//this if statement is for handling duplicates and true in case of zero
					int occurence = map.get(key);
					times =(occurence*(occurence-1))/2;
					finalcount = finalcount+times;
					for (int j = 0; j < times; j++) {
						System.out.println(key + " "+ (-key));
					}
					map.put(key, 0);
//					continue;
				}
				times = map.get(key)*map.get(-key);
				finalcount = finalcount + times;
				for (int j = 0; j < times; j++) {
					System.out.println(key +" "+ (-key));
				}
				map.put(arr[i], 0);
				map.put(-arr[i], 0);	
			}
			}
		System.out.println(finalcount);

		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int arr[] = {-2,2,6,-2,2,-6,3,0,0,0,0};
    int arr2[] = {2, 1 ,-2, 2 ,3};

    pairSumToZero(arr);
    
    
    
    }

	

}
