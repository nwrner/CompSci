import java.util.Scanner; 
import java.lang.Math;
import java.math.BigInteger;
public class Decrypt {
	public static void main(String[] args) { 
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter message to decrypt: ");
		BigInteger input = reader.nextBigInteger();

		String out = String.valueOf(input);
		BigInteger a = new BigInteger(out); 	
		BigInteger n = new BigInteger("299448533341");
		BigInteger d = new BigInteger("286337592959");
		
		BigInteger x = a.modPow(d,n);
		System.out.println("Decrypted message is " + x);
	}
}


