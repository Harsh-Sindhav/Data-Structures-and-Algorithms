 package inheritance;

public class Vehicle {
   // we've moved common properties of bike and car to vehicll class
//	String color;
	
	private String color;
	
	// inheritaance and constructor 
		
	
	
	
//	int maxSpeed;
//	public int maxSpeed;
	protected int maxSpeed;

//	public Vehicle() {
//		System.out.println("vehicle's constructor");
//	}

	
	 // error we may make while inheriting i.e here we're learning the relation inheritance and cconstuctors
	
     public Vehicle(int maxSpeed) { // leads to error in car class bcoz car const try to access def const which is no longer available as soon as we  create our own constructor
	System.out.println("vehicle's constructor");
    this.maxSpeed = maxSpeed;	  
    }
	
     
     
     public String getColor() {
		
		return color;
		
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	public void print() {
		
		System.out.println("Vehicle" + "color" + color + " maxSpeed" + maxSpeed);
		   
	}
}
