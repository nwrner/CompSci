import java.util.Scanner; 
import java.lang.Math;
public class Average3 {
	public static void main(String[] args) {
		//Create the scanner object
		Scanner reader = new Scanner(System.in);
		//A variable reader		
		System.out.print("Enter first integer: ");
		double a = reader.nextDouble(); 
		System.out.print("Enter second integer: ");
		double b = reader.nextDouble();
		System.out.print("Enter third integer: ");
		double c = reader.nextDouble();
		System.out.println("Average is " + (a+b+c)/3);
		
	}
    
	
}
