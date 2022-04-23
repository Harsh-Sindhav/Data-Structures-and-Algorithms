package finalHashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class longestConsecutiveIncreasingSubsequence {

	public static ArrayList<Integer> longestConsecutiveSubsequence(int[] arr){
		
		HashMap<Integer, Boolean> visitedElem = new HashMap<>();
		HashMap<Integer, Integer> elemToIndexMapping = new HashMap<Integer, Integer>();
		
		for(int i =0;i<arr.length;i++) {
			int num = arr[i];
			elemToIndexMapping.put(num, i);
			if(!visitedElem.containsKey(num)) {
				visitedElem.put(num, false);
			}
		}  
		
		ArrayList<Integer> longestSequence = new ArrayList<Integer>();
		int globalMaxSequenceLength = 1;
		int globlaMinStartIndex = 0;
		
		for(int i=0;i<arr.length;i++) {
			int num = arr[i];
			int currMinStartIndex = i;
			int count = 0;
			int tempNum = num;

			//forward
		       while(visitedElem.containsKey(tempNum) && !visitedElem.get(tempNum)){
		    	   visitedElem.put(tempNum, true);
		    	   count++;
		    	   tempNum++;   
		       }

		   //backward
		       tempNum = num-1;
		       while(visitedElem.containsKey(tempNum) && !visitedElem.get(tempNum)) {
		    	   visitedElem.put(tempNum, true);
		    	   count++;
		    	   currMinStartIndex = elemToIndexMapping.get(tempNum);
		    	   tempNum--;
		       }
		       
		       if(count > globalMaxSequenceLength) {
		    	   globalMaxSequenceLength = count;
		    	   globlaMinStartIndex = currMinStartIndex;
		       }else if(count == globalMaxSequenceLength) {
		    	   if(currMinStartIndex < globlaMinStartIndex) {
		    		   globlaMinStartIndex = currMinStartIndex;
		    	   }
		       }  
		}

        int globalStartNum = arr[globlaMinStartIndex];
        longestSequence.add(globalStartNum);
        if(globalMaxSequenceLength > 1) {
        	longestSequence.add(globalStartNum + globalMaxSequenceLength - 1);
        }
		return longestSequence;
	
	}
	
	
	public static void main(String[] args) {
		
	}
}
