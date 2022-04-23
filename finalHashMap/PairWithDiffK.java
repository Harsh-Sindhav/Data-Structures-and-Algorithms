package finalHashMap;

import java.util.HashMap;

public class PairWithDiffK {

	public static int pairWithDiffK(int[] arr,int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int paircount = 0;
		for(int num:arr){
			
			int p1 = num + k;
			boolean flag = false;
			if(num==p1){
				//considering the case when k = 0 that is when may or may not be duplicates are present !
				flag = true;
			}
			if(map.containsKey(p1)){
				paircount += map.get(p1);
			}
			int p2 = num-k;
		if(map.containsKey(p2) && !flag){
			// we're not doing this when flag is true coz when k = 0 and may or may not duplicates are present then we've already added/calculated the pairCount in the above if condition !  
			paircount += map.get(p2);
		}
		
		if(map.containsKey(num)) {
			map.put(num, map.get(num)+1);
		}else {
			map.put(num, 1);
		}
		}	
		
		return paircount;
	}
	
	
	
//	int count  =  0;
//	HashMap<Integer,Integer> map = new HashMap<>();
//        for(int n: arr){
//            map.put(n,map.getOrDefault(n,0)+1);
//        }
//        
//        for(int n : arr){
//            int num1 = n - k; 
//            int num2 = n + k;
//            if(n == n - k){
//                int l = map.get(n);
//                count += (l*(l-1))/2;
//                map.put(n,0);
//                continue;
//            }
//            
//            if(map.containsKey(num1)){
//                 int l = map.get(n-k);
//                 int m = map.get(n);
//                count += l*m;
//                
//            }
//            
//            if(map.containsKey(num2)){
//                 int l = map.get(n+k);
//                 int m = map.get(n);
//                count += l*m;
//                
//            }
//             map.put(n,0);
//            
//        }
//        
//    
//    
//       return count;
	
	public static void main(String[] args) {

		int[] arr = {4,4,4,4};           //{5,1,2,4};
		int k = 3;
		int ans = pairWithDiffK(arr, k);
		System.out.println(ans);
	}
}