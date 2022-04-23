package finalHashMap;

import java.util.HashMap;
import java.util.Set;

public class InbuiltHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     HashMap<String,Integer> map = new HashMap<>();
     
     //insert
     map.put("abc", 1);
     map.put("def", 3);
     
     //update value of key
     
     map.put("abc", 4);
     
     //size
     
     System.out.println(map.size());
     
     //presence
     if(map.containsKey("abc")) {
     System.out.println("map has abc");
     }
     
     if(map.containsKey("abc1")) {
     //not print coz map doesn't have abc1
    	 System.out.println("map has abc1");
         }
     
     // get value
    
/*
   //not a correct way of getting value coz will lead to  null pointer exception if the key is not there in hashmap so apply check(that is the if condition) before you want to get sth    
//     int v = map.get("abc");
//     System.out.println(v);
//     
//     int v1 = map.get("abc1");// this line  will lead to null ptr exception coz map doesn't have abc1 key !!
//      System.out.println(v1); 
    
   *   
     */
     int v = 0;
     if(map.containsKey("abc")) {
      v = map.get("abc");
     System.out.println(v);
     }
     int v1 = 0;
     if(map.containsKey("abc1")) {
      v1 = map.get("abc1");
     System.out.println(v1);
     }
     
     //remove
     
//     map.remove("abc");
//     if(map.containsKey("abc")) {
//     System.out.println(map.get("abc"));
//     }
//     
//     map.remove("abc1"); // nothing will happen
    
     //iterate
     
     Set<String> keys = map.keySet();
     for(String s : keys) {
    	 System.out.println(s);
     }
     
       
     
	}

}
