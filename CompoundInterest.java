import java.util.Scanner; 
import java.lang.Math;
public class CompoundInterest {
	public static void main(String[] args) {
		//Create the scanner object
		Scanner reader = new Scanner(System.in);
		//A variable reader		
		System.out.print("Enter interest rate: ");
		double IR = reader.nextDouble(); 
		System.out.print("Enter principal: ");
		double PR = reader.nextDouble();
		System.out.print("Enter number of periods: ");
		double NP = reader.nextDouble();
		System.out.print("Amount = ");
		System.out.println(Math.pow((1+IR), NP)*PR);
		
	}
    
	
}
