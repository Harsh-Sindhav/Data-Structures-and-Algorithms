package Tries;

public class TrieUse {
public static void main(String[] args) {
	Trie t = new Trie();
	t.add("this");
	t.add("news");
	System.out.println(t.search("this"));
	System.out.println(t.search("news"));
	System.out.println(t.search("new"));
    t.remove("news");
	System.out.println(t.search("news"));
//    System.out.println(t.countWords());

  }
}
