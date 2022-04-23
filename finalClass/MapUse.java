package finalClass;

import finalHashMap.Map;

public class MapUse {

	
	
	public static void main(String[] args) {
	
   
	Map<String, Integer> map = new Map<>();
	for(int i=0;i<20;i++)
	{
		map.insert("abc"+i, i+1);
	// at the insertion of 4th elem in map rehashing is happening coz it'll become 4/5 = 0.8 so it'll eventually become 4/10 so our load factor will become 0.4 
		System.out.println(map.loadFactor());
	}	
	
	map.removeKey("abc3");
	map.removeKey("abc7");
	for(int i=0;i<20;i++) {
		System.out.println("abc" + i + ":" + map.getValue("abc" + i) );
	}
	
	System.out.println(map.size());
	
	
	
	}
	
	
}
