package priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class pairComparator implements Comparator<Pair>{
	public int compare(Pair p1,Pair p2) {
		if(p1.value <= p2.value)return 1;
		else return -1;
	}
}


class Pair{
int value;
int arrayNumber;
Pair(int v,int n){
value = v;
arrayNumber = n;
}
}

public class MergeKSortedArrays {
	
	static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input){
	if(input.size() == 0) return null;
		
	pairComparator compare = new pairComparator();
	PriorityQueue<Pair> maxHeap = new PriorityQueue<>(input.size(),compare);
	for(int i=0;i<input.size();i++) {
		int index = input.get(i).size()-1;
		Pair current = new Pair(input.get(i).get(index),i);
		maxHeap.add(current);
		input.get(i).remove(index);
	}
	
	ArrayList<Integer> op = new ArrayList<Integer>();
	while(!maxHeap.isEmpty()) {
		Pair max = maxHeap.remove();
		op.add(max.value);
		int i = max.arrayNumber;
		if(input.get(i).size() > 0) {
			int index = input.get(i).size()-1;
			int value = input.get(i).get(index);
			input.get(i).remove(index);
			Pair current = new Pair(value,i);
			maxHeap.add(current);
		}
	}
	
  Collections.reverse(op);
   return op;	
	}



public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> a = new ArrayList<Integer>();
    a.add(1);
    a.add(5);
    a.add(9);
    ArrayList<Integer> b = new ArrayList<Integer>();
    b.add(45);
    b.add(90);
 arr.add(b);
 arr.add(a);
 
    ArrayList<Integer> ans = mergeKSortedArrays(arr);
    System.out.println(ans);
   
 
}

}
