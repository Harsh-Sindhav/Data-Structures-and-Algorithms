package Tries;

import java.util.ArrayList;

import strings.ReverseWordWise;

class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	
	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
	    childCount = 0;	
	}
}

public class Trie {

   private TrieNode root;
//   private int numWords;
    
   public Trie(){
	   root = new TrieNode('\0'); //Null character Java The default value of a char primitive type is '\u0000' (null character) as stated in the Java Language Specification. The shortcut for 'u0000' is '\0', So the null can be represented either by 'u0000' or '\0'.
//       numWords=0;
   }
   
   public boolean search(String word) {
	   return search(root,word);
   }
   
   private boolean search(TrieNode root, String word) {

	   if(word.length()==0 ) {
		   return root.isTerminating;
	   }
	   
	   int childIndex = word.charAt(0)-'a';
	   TrieNode child  = root.children[childIndex];
//	   System.out.println(child); // will print null cozz neeche dekh if child == null  wali if condition me 
	   if(child == null) { // coz child is a trienode and trienode is a non primitive data type and by def value stored there is null if nothing is present
		return false;
	   }
	   
	   return search(child,word.substring(1));
	   
}
   
   public void remove(String word) {
	   remove(root,word);
//	   if(search(word)) {
//		   numWords--;
//	   }
   }

private void remove(TrieNode root, String word) {

	if(word.length()==0) {
		root.isTerminating = false;
//      numWords--;  // i  guess
		return;
	}
    int childIndex = word.charAt(0)-'a';
    TrieNode child = root.children[childIndex];
    if(child == null) { // vo word trie me hain hi nahi
    	return;
    }
 	remove(child,word.substring(1));
 	// after the above remove fn what we're doing is that we're checking for two conditions that is we can remove child only if it is non terminating and its num of child are zer0  
// iss if statement se hume niche wale if statement jitna lamba chauda kaam nahi krna padega ! :D
 	if(!child.isTerminating && child.childCount ==0) {
 		root.children[childIndex] = null;
			child = null;
			root.childCount--;
//         numWords--;
 	}

// 	if(!child.isTerminating) {
// 		int numChild = 0;
// 		for(int i=0;i<26;i++) {
// 			if(child.children[i] != null) {
// 				numChild++;
// 			}
// 	    }
// 		if(numChild == 0) {
// 			// we can delete child
// 			root.children[childIndex] = null;
// 			child = null; 			
// 		}
// 	}
 	 	
}

private void add(TrieNode root,String word) {
	   // you important must read comment
	      //we're assuming ki saare small case letters hain
	   // word.charAt(0) means ki let's say ki ek word hain "note" then s.charAt(0) - 'a'(ascii value) gives the index  sabse pehle hum serach krenge root me ki n present hain ya nahi etc etc!!xD
	  
	   if(word.length() == 0) {
		   root.isTerminating = true;
//		   numWords++;    // i guess
		   return;
	   }
	  
	   int childIndex = word.charAt(0)-'a';
	   TrieNode child  = root.children[childIndex];
//	   System.out.println(child); // will print null cozz neeche dekh if child == null  wali if condition me 
	   if(child == null) { // coz child is a trienode and trienode is a non primitive data type and by def value stored there is null if nothing is present
		child = new TrieNode(word.charAt(0));
		root.children[childIndex] = child;
		root.childCount++;
	   }
	   add(child , word.substring(1));
   }
   
     public void add(String word) {
    	 add(root,word);       
    	
    	 }

//      public int countWords() {
//    	return root.childCount;  
//      }  

  
     // pattern matching
     
  public boolean patternMatching(ArrayList<String> vect,String pattern) {
	for(int i=0;i<vect.size();i++) {
		String word = vect.get(i);
		for(int j=0;j<word.length();j++) {
			add(word.substring(j));
		}
	}
	return search(pattern);
  }
  
  // print 
  
  private void print(TrieNode root, String word) {
	  if(root == null) {
		  return;
	  }
	  if(root.isTerminating) {
		  System.out.println(word);
	  }
	  for(TrieNode child : root.children) {
		  if(child == null) {
			  continue;
		  }
		  String fwd = word+child.data;
		  print(child,fwd);
	  }
  }
     
   public void print() {
	   print(this.root,"");
   }  
     
   // pallindrome pair 
   
   
   /* ---- The Approach We Have Taken To Implement This Problem ---- The approach we have taken to solve this problem is to store 
    * the reverse of each of the words in the Trie.We then iterate over the words and search that does the Trie contains the same
    *  word or not. It may happen that some parts of the word or a substring exist in the Trie. We check for the remaining part of
    *   the string to be a palindrome or not. Vise versa of the above will also be true, that means, it may happen that the word in
    *    the Trie may extend further over different number of branches, hence we check all the branches one by one to see if any of
    *     the branches make a palindrome. */
   
   // very imporatant every time read the below text  
   
   /* ---- Another Possible Solution Could Be ---- There's another way of solving this problem. It goes like this. First add the reverse
    *  of every word in the trie. Then for every word, search it in the trie. If you find it, then that means the word was a palindrome itself
    *   and you can return true. If you don't find it, you need the length of the part that you did find. For example, you're searching for "abcdd" 
    *   in the trie, you didn't find a match for "abcdd" but you found the word "abc" in the trie. Finding "abc" in the trie means that the actual word 
    *   was "cba" since we inserted the reverse of every word in the list. Now, you have the word "abcdd", you found the word "abc" in the trie. If you 
    *   can find whether the part of "abcdd" that comes after "abc", i.e. "dd" is a palindrome, you can conclude that concatenating "abcdd" and "cba" 
    *   will also give a palindrome. So you can return true. If the part isn't a palindrome, you move to check for the next word. If you traverse through all
    *    words without finding a pair of words that combine to form a palindrome or a word that's a palindrome by itself, then you can return false. */
   
   public boolean isPallindromePair(ArrayList<String> words){
	   
	for(String word : words) {
		this.add(reverseWord(word)); // storing in trie
	}
	return isPallindromePair(this.root,words);   
   }

  private static String reverseWord(String word) {
	String reverse = "";
	for(int i=word.length()-1;i>=0;i--) {
		reverse += word.charAt(i);
	}
	return reverse;
}

private boolean isPallindromePair(TrieNode root,ArrayList<String> words) {
	
	if(words == null || words.size()==0) {
		return false;
	}
	
	for(String word : words) {
		if(doesPairExistFor(root,word,0)) {
			return true;
		}
	}
	
	return false;
	
}
 
private boolean doesPairExistFor(TrieNode root, String word,int si) {
	// as here recursion is going on and word=="" is base case here for recursion to stop and the condition for [if(words == null || words.size()==0) -> returns false see above ] is already checked in the above isPallindromePair fn
	if(word == "") {
		return true;
	}
	
	if(si == word.length()) {
		if(root.isTerminating) {
			/*  When there exists an exact match of the word we are 
			 *  searching for in the Trie, irrespective of the trie 
			 *  extends further in the same path.
			 *  */
			return true;
		}
		
		/* 
		 *  When trie extends further, there doesnt exist an exact 
		 *  match of the string we are looking for. 
		 *  However, it may happen that any of the the branch 
		 *  extending from root may form a palindrome. 
		 *  
		 *  */
		
		
		// if arraylist contains words like this -> abc ,  dfdcba
	
		return checkRemainingBranchesInTrie(root,""); // as recursion is going on here so here corresponding child is root ....
	}
	
	int charIndex = word.charAt(si)-'a';
	TrieNode correspondingChild = root.children[charIndex];
	
	if(correspondingChild == null) {
		
		// when arr contains string like this -> aadbdaa 
		
		/*  This means that, down the line in the characters that we are looking 
		 *  for against the word in the trie, the character doesn't exist in the trie.
		 *  This character can be anywhere in the range [0 - (word length-1)] 
		 *  */
		
		// abce, cba
		
		if(root.isTerminating) {
		return checkWordForPallindrome(word.substring(si));	// we're checking whether "e" in string abce (word coz substring ) is pallindrome or not.. you can take some other eg also .. 
		}
		return false;
	}
	return doesPairExistFor(correspondingChild,word,(si+1));
	 }

private boolean checkRemainingBranchesInTrie(TrieNode root, String word) {
 
	/**   This function recursively explores all the branches from the root 
	 * * while keeping a track of the characters in the 'word' and checks 
	 * * each word whenever the terminating condition is true. * * If the word is a palindrome, we return true and stops exploring the 
	 * * other branches. If it is otherwise, we keep on checking the remaining * branches. * * Once all the branches are explored, and we don't find any branch or 
	 * * word that makes itself a pallindrome we return false at last. * */
	
	if(root.isTerminating) {
		if(checkWordForPallindrome(word)){
			return true;
		}
	}
	
	for(TrieNode childNode : root.children) {
		if(childNode == null) {
			continue;
		}
    String fwd = word + childNode.data;
    if(checkRemainingBranchesInTrie(childNode, fwd)) {
    	return true;
    }
	}

	return false;
    }


private boolean checkWordForPallindrome(String word) {
      int si = 0;
      int ei = word.length() - 1;
      while(si < ei) {
    	  if(word.charAt(si) != word.charAt(ei)) {
    		  return false;
    	  }
    	  si += 1;
    	  ei -=1;
      }
	return true;
         }


////////////// Auto Complete 


   public TrieNode findRoot(TrieNode root,String word) {
	   
	   if(word.length() ==0) {
		return root;   
	   }
	   
	   int childIndex = word.charAt(0)-'a';
	   TrieNode child = root.children[childIndex];
	   if(child == null){
		   return null;
	   }
	   
	   return findRoot(child, word.substring(1));
   } 
   
   public void autoComplete(ArrayList<String> input,String word) {// word means -> pattern like ki bas "no" de diya aur isko autocomplete karo
	   for(String w : input) {
		   add(w);
	   }
 	   TrieNode node = findRoot(root, word);
   	   
	   if(node == null || node.childCount==0) {
		   return;
	   } 
	   
	   String output = "";
	   
	   allRootToLeafPaths(node,output,word);   
   }
   
   private void allRootToLeafPaths(TrieNode node,String output,String word) {
	   if(node.childCount == 0) {
		   if(output.length()>0) {
			   System.out.println(word + output);
		   }
		   return;
	   }
	
	   if(node.isTerminating == true) {
		   System.out.println(word + output);
	   }
	   
	for(int i=0;i<node.children.length;i++) {
		if(node.children[i] != null) {
			String ans = output + node.children[i].data;
			allRootToLeafPaths(node.children[i], ans, word);
		}
	}   
	
   }

}
