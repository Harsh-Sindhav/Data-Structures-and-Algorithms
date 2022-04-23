package finalHashMap;

import java.util.ArrayList;

public class Map<k,v> {
	ArrayList<MapNode<k, v>> buckets;
	int count;  // how many elem are present in my hashmap and by def it'll be zero
	int numBuckets; // bucket means if arrlist of size 20 then no of buckets = 20!!!  xD
	public Map() {	
		// we can't have an empty arrlist coz  hashfunc give any random integer for a key and we've to store at that particular index pos the key value pair so we can't have an empty arrlist that we'll create an arrlist of some size initially with null stored at each index !!!!
		buckets = new ArrayList<MapNode<k,v>>();
        //  numBuckets =20; //we'll create arr of size 20
		// for better understanding of load factor in mapuse class we're setting or creating the arr of size 5 instead of 20...
		numBuckets = 5;
	    for(int i =0; i< numBuckets;i++) {
	    	buckets.add(null); // initiallly storing null and created an arrlist of size 20
	    }
	}
	
	private int getBucketIndex (k key) {
		int hc = key.hashCode();
		int index = hc%numBuckets;
		return index;
	}
	
	public int size() {
		return count;
	}
	
	public v removeKey(k key) {
	// if we've to remove the key that key should be there and once we're removing the key we should return the value corresponding to that as well!!
		int bucketIndex = getBucketIndex(key);
		MapNode<k, v> head = buckets.get(bucketIndex);
		MapNode<k, v> prev = null;  // initially the prev is null

		while(head != null) {  	
		    	// BIG MISTAKE 
                //if(head.key == key) { 
		         // important must read!!!
		    	// head.key == key is not correct coz if we've def as key we get our index for our key and got  our head if ll is present at that index and iterate over the ll and check if there is that particular key(lets say "def") is present or not and we're using here == operator and checking if def == def then it'll return false coz string is an obj and if we do like this(==) it can compare the address and since obj are there and we dont need to comapre the address and we need to comapre the actual values so we'll use .equals coz it will check the values that are there and not the address 
		    	// == check address and .equals check values !!!1
		    	if(head.key.equals(key)) { 
		    		if(prev != null) {
      	 	    prev.next = head.next;
		    	} else {
		    		// handling the case when the head is the key so if there is only above statement is present and not the else statement that we've written then will lead to error why coz if at head we found the key and not else statement is there then prev is null and null.next will lead us to errors !!   
		    		buckets.set(bucketIndex, head.next);
		    		}
		    		count--;
		    		return head.value;
		    	}
		    	prev = head;
		    	head = head.next;
		    }
		return null;
	}
	
	
	public v getValue(k key) {
		int bucketindex = getBucketIndex(key);
	    MapNode<k, v> head = buckets.get(bucketindex); //got the head of the ll    
	    // checking if the key is already present there in the ll that is we're iterating over the whole array xD!!
	    while(head != null) {  	
	    	// BIG MISTAKE 
             //	if(head.key == key) { 
	         // important must read!!!
	    	// head.key == key is not correct coz if we've def as key we get our index for our key and got  our head if ll is present at that index and iterate over the ll and check if there is that particular key(lets say "def") is present or not and we're using here == operator and checking if def == def then it'll return false coz string is an obj and if we do like this(==) it can compare the address and since obj are there and we dont need to comapre the address and we need to comapre the actual values so we'll use .equals coz it will check the values that are there and not the address 
	    	// == check address and .equals check values !!!
	    	if(head.key.equals(key)) { 
	    	 	    	 return head.value;
	    	}
	    	head = head.next;
	    }
	    return null;  	
	}

	
	private void reHash(){
	   	ArrayList<MapNode<k, v>> temp = buckets;
	    buckets = new ArrayList<MapNode<k,v>>();
	    for(int i=0;i<2*numBuckets;i++) {
	    	buckets.add(null);
	    }
	    
	//since each elem has been inserted again now so our count will become zero again now coz no of elem become zero coz they're effectively inserting again into thee newBucket
	    count =0;
	    numBuckets = numBuckets*2;
	    for(int i=0;i<temp.size();i++) {
	    	MapNode<k, v> head = temp.get(i);
	    	while(head != null) {
	    		k key = head.key;
	    		v value = head.value;
	            insert(key, value);  // elem inserted as per new rehashing as size changes that is  numbuckets changes 
	    		head=head.next;	  //  we're not doing count++ here coz its already happening in insert fn
	    	}
	    }	
	}
	
	public double loadFactor() 
	{	
		return (1.0*count)/numBuckets;	
	}
	
	
	public void insert(k key,v value) {
		int bucketindex = getBucketIndex(key);
	    MapNode<k, v> head = buckets.get(bucketindex); //got the head of the ll    
	    // checking if the key is already present there in the ll that is we're iterating over the whole array xD!!
	    while(head != null) {
	    	// BIG MISTAKE 
           //if(head.key == key) { 
	         // important must read!!!
	    	// head.key == key is not correct coz if we've "def" as key we get our index for our key and got  our head if ll is present at that index and iterate over the ll and check if there is that particular key(lets say "def") is present or not and we're using here == operator and checking if def == def then it'll return false coz string is an obj and if we do like this(==) it can compare the address and since obj are there and we dont need to comapre the address and we need to comapre the actual values so we'll use .equals coz it will check the values that are there and not the address 
	    	// == check address and .equals check values !!!1
	    	if(head.key.equals(key)) { 
	    	 //UPDATE THE VALUE AND JUST RETURN FROM THERE as elem is already there !
	    		head.value = value;
	    	    return;
	    	}
	    	head = head.next;
	    }
	    
	    // elem is not there. insert at 0th pos of LL
	    // we'll do this if npde is not already present in the bucket...
//	    as we may have lost our head to null or our head points to some other node other than the original head
	    head = buckets.get(bucketindex); // gets our head back if we may have or may not lost it 
	    MapNode<k, v> newNode = new MapNode<>(key, value);
	    newNode.next = head;   
	    buckets.set(bucketindex, newNode);
	    
	     count++; // increasing the count coz new elem is adding !!  
		
	     double loadfactor = (1.0*count)/numBuckets;
	     if(loadfactor > 0.7) {
	    	 reHash();
	     }
	       
	}
	
}
