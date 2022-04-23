package linkedList;

import java.util.LinkedList;

public class CollectionsLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(1, 100);
		list.addFirst(80);
		list.set(0, 60);
		list.remove();
		 
	    System.out.println(list.get(1));
	    System.out.println(list.size());
	for(int i =0 ; i < list.size();i++) {
		System.out.println(list.get(i));
	}
	    
	}

}
