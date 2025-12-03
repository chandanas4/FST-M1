package Activities;

public class Activity1 {
	
	public static void main(String[] args) {
		Car i20 = new Car();
       i20.make = 2020;
        i20.colour = "Blue";
        i20.transmission = "Automatic";
    
        //Using Car class method
        i20.displayCharacteristics();
        i20.accelerate();
        i20.brake();
	}

}
