package classesAnsObjects;

public class Fraction {

	private int numerator;
	private int denominator;
	
    public Fraction(int numerator,int denominator) {
    	if(denominator==0) {
    		
    		// throw error 
    		
    		denominator = 1;
    		
    		
    	}
		this.numerator = numerator;
		
		
		this.denominator = denominator;
		
		simplify();
	}
	
	private void simplify() {
		
		int gcd = 1;
		int smaller = Math.min(numerator, denominator);
		
		for(int i=2; i <= smaller;i++) {
		if(numerator%i == 0 && denominator%i == 0) {
			gcd = i;
			}
		}
		numerator = numerator/gcd;
		denominator = denominator/gcd;
		
	}
	
	
	public void setNumerator(int n) {
		
		this.numerator = n;		
		simplify(); // why? bcoz we're storing the fraction in simplest form !
	}
	

	public int getNumerator() {
		
		return numerator;
	}
	
	
    public void setDenominator(int d) {
		if(d==0) return;
		this.denominator = d;		
		simplify();
	}

	public int getDenominator() {
		
		return denominator;
	
	}
    
	public void increment() {
		
		numerator = numerator + denominator;
		simplify();
		
	}
	
	public void print() {
		System.out.println(numerator + "/" + denominator);
	}
	
	public static Fraction add(Fraction f1, Fraction f2) {
		// using this keyword will give error and doesnt work in static fn bcoz keywords belong to an obj and static keyword is not connected to obj
//		int newNum = this.numerator * f2.denominator + this.denominator * f2.numerator;
		int newNum = (f1.numerator*f2.denominator) + (f1.denominator*f2.numerator);
	    int newDeno = f1.denominator + f2.denominator;
	    Fraction f3 = new Fraction(newNum, newDeno);
	     return f3; // no need to simplify the f3 explicitly bcoz you've called the constructor and the constructor have the implicit simplify fn correspondingly 
	}
	
	
	
	
	
	
//	public void add(Fraction f1, Fraction f2) add fn with 2 arg ? I dont think so,  arg req for add fn is only one. why? bcoz fraction f1 will call this add having arg fraction f2 in it !!
// So, correct way of add fn is
	public void add(Fraction f2) {
		// first fraction is the fraction on which fn is called
		// second fraction is passed as args
		
		this.numerator = this.numerator * f2.denominator + this.denominator * f2.numerator;
		this.denominator = this.denominator * f2.denominator; 
		simplify();
	}
	
	
	
}
