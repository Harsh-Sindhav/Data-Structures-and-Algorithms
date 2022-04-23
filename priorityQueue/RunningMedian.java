package priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
 
    static void findMedian(int arr[]) {
   int n = arr.length;
   PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(new Comparator<Integer>() {
	   public int compare(Integer first,Integer second) {
		   return second - first;
	   } 
   });
   
   PriorityQueue<Integer> higherhalf = new PriorityQueue<>();
   int median;
   for(int size=1;size<=n;size++) {
	   if(!lowerHalf.isEmpty() && lowerHalf.peek() > arr[size-1]) {
		   lowerHalf.add(arr[size-1]);
		   if(lowerHalf.size() > higherhalf.size()+1) {
			   higherhalf.add(lowerHalf.poll());
		   }else {
			   higherhalf.add(arr[size-1]);
			   if(higherhalf.size() > lowerHalf.size()+1) {
				   lowerHalf.add(higherhalf.poll());
			   }
		   }
	   }else {
		   higherhalf.add(arr[size-1]);
		   if(higherhalf.size() > lowerHalf.size()+1) {
			   lowerHalf.add(higherhalf.poll());
		   }
		   
		   if(size % 2 ==1) {
			   if(higherhalf.size() > lowerHalf.size()) {
				   median = higherhalf.peek();
			   }else {
				   median = lowerHalf.peek();
			   }
		   }else {
			   median = (lowerHalf.peek() + higherhalf.peek())/2;
		   }
		   System.out.print(median + " ");
		   
	   }
   }
   
   
   
   }


}





///*
//Time Complexity: O(N * N * log(N))
//Space Complexity: O(1)
//
//where N is the number of elements in the array.
//*/
//
//import java.util.Arrays;
//
//public class Solution 
//{
//
//public static void findMedian(int arr[]) 
//{
//	int n = arr.length;
//	int median;
//	
//    // Traverse through the array
//	for(int i = 0; i < n; i++) 
//	{
//        // Sort the array from 0-th to i-th index
//		Arrays.sort(arr, 0, (i + 1));
//		
//        // Check if i+1 is odd
//		if((i + 1) % 2 == 1) 
//        {
//			median = arr[i / 2];
//		} 
//        else 
//        {
//			median = (arr[i / 2] + arr[i / 2 + 1]) / 2;
//		}
//		
//        // Print the variable median
//		System.out.print(median + " ");
//	}
//}
//
//}
//
///*
//Time Complexity: O(N ^ 2)
//Space Complexity: O(N)
//
//where N is the number of elements in the array.
//*/
//
//import java.util.ArrayList;
//
//public class Solution 
//{
//
//public static void findMedian(int arr[]) 
//{
//	int n = arr.length;
//    int median;
//    ArrayList<Integer> stream = new ArrayList<>();
//
//    for(int i = 0; i < n; i++)
//    {
//    	// The stream is currently empty
//        if(stream.size() == 0) 
//        {
//            stream.add(arr[i]);
//        } 
//        else
//        {
//            // Traverse through the array stream
//            for(int j = 0; j < stream.size(); j++) 
//            {
//                // Insert when the stream[j] is greater than arr[i]
//                if(arr[i] <= stream.get(j)) 
//                {
//                    stream.add(j, arr[i]);
//                    break;
//                }
//
//                // We have reached the end of stream
//                if(j == (stream.size() - 1)) 
//                {
//                    stream.add(arr[i]);
//                    break;
//                }
//            }
//        }
//		
//        // Check if i+1 is odd
//        if((i + 1) % 2 == 1) 
//        {
//        	median = stream.get(i / 2);
//        } 
//        else 
//        {
//            median = (stream.get(i / 2) + stream.get(i / 2 + 1)) / 2;
//        }
//		
//        // Print the variable median
//        System.out.print(median + " ");
//    }
//}
//
//}
//
//
///*
//Time Complexity: O(N * log(N))
//Space Complexity: O(N)
//
//where N is the number of elements in the array.
//*/
//
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class Solution 
//{
//
//public static void findMedian(int arr[])  
//{
//	int n = arr.length;
//
//	PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(new Comparator<Integer>() 
//                                                           {
//		@Override
//		public int compare(Integer first, Integer second) 
//        {
//			return (second - first);
//		}
//	});
//	
//	PriorityQueue<Integer> higherHalf = new PriorityQueue<>();
//
//	int median;
//
//	// The variable size is the size of the current stream
//	for(int size = 1; size <= n; size++) 
//    {
//		if(!lowerHalf.isEmpty() && lowerHalf.peek() > arr[size-1]) 
//        {	
//            // Insert ARR[size-1] in lowerHalf
//			lowerHalf.add(arr[size - 1]);
//
//			if(lowerHalf.size() > higherHalf.size() + 1) 
//            {	
//                // Insert the top element of lowerHalf into higherHalf
//				higherHalf.add(lowerHalf.poll());	      
//			}
//		} 
//        else 
//        {
//			higherHalf.add(arr[size - 1]);
//
//			if(higherHalf.size() > lowerHalf.size() + 1) 
//            {	
//                // Insert the top element of higherHalf into lowerHalf
//				lowerHalf.add(higherHalf.poll());
//			}
//		}
//		
//        // Check if size is odd
//		if(size % 2 == 1) 
//        {
//			if(higherHalf.size() > lowerHalf.size()) 
//            {
//				median = higherHalf.peek();
//			} 
//            else 
//            {
//				median = lowerHalf.peek();
//			}
//		} 
//        else 
//        {
//			median = (lowerHalf.peek() + higherHalf.peek()) / 2;
//		}
//		
//        // Print the variable median
//		System.out.print(median + " ");
//	}
//}
//
//}