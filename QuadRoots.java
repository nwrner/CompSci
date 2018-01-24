import java.util.Scanner; 
import java.lang.Math;
public class QuadRoots {
	public static void main(String[] args) {
		//Create the scanner object
		Scanner reader = new Scanner(System.in);
		//A variable reader		
		System.out.print("a? ");
		double a = reader.nextDouble(); 
		//B variable reader
		System.out.print("b? ");
		double b = reader.nextDouble();
		//C variable reader
		System.out.print("c? ");
		double c = reader.nextDouble();
		//Formula assignment
		System.out.print("roots are ");
		System.out.print(-b+(Math.sqrt(Math.pow(b,2)-4*a*c)));
		System.out.print(" ");		
		System.out.println(-b-(Math.sqrt(Math.pow(b,2)-4*a*c)));
		//Error message at A=33 B=11 C=4
	}
    
	
}
