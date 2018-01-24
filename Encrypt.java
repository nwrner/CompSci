import java.util.Scanner; 
import java.lang.Math;
import java.math.BigInteger;
public class Encrypt {
	public static void main(String[] args) { 
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter message to encrypt: ");
		BigInteger input = reader.nextBigInteger();
		String out = String.valueOf(input);
		BigInteger a = new BigInteger(out); 	
		BigInteger n = new BigInteger("299448533341");
		int e = 121763;	
		BigInteger x = a.pow(e);   
		x = x.mod(n);
		System.out.println("Encrypted message is " + x);
	}
}


