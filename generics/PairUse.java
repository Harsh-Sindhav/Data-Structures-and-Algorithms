package generics;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class PairUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//      Pair p = new Pair(1,2);
//      p.setFirst(10);
//    		  System.out.println(p.getFirst());
//    		  System.out.println(p.getSecond());
	  	
		
		Pair<String,String> p = new Pair<String,String>("ab","cd");
		p.setFirst("def");
		String s = p.getFirst();
		
		Pair<Integer,String> p1 = new Pair<Integer,String>(1,"temp");
		 
//		Pair<Character,Character> p2 = new Pair<Character,Character>('a','b');
		//or
		Pair<Character,Character> p2 = new Pair<>('a','b');
		
		
		int a = 10;
		int b = 12;
		int c = 23;
		
		Pair<Integer,Integer> internalPair = new Pair<>(a,b);
		
		Pair<Pair<Integer,Integer>,Integer> p3 = new Pair<>(internalPair,c);
		System.out.println(p3.getSecond());
		System.out.println(p3.getFirst().getFirst());
		System.out.println(p3.getFirst().getSecond());
	}

}
