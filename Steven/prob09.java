import java.util.*;
import java.io.*;
import java.math.*;
public class prob09 {
	public static void main(String[] args) throws Exception {
		new prob09().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(true) {
			BigInteger tot = new BigInteger(""+50*60).subtract(new BigInteger(""+file.nextInt()).multiply(new BigInteger("60"))).subtract(new BigInteger(""+file.nextInt()));
			if(tot.equals(new BigInteger("3000"))) break;
			boolean neg = tot.compareTo(BigInteger.ZERO) < 0;
			BigInteger sec = tot.mod(new BigInteger("60"));
			if(neg && !sec.equals(BigInteger.ZERO)) sec = sec.subtract(new BigInteger("60"));
			System.out.printf("Time remaining %d minutes and %d seconds", tot.divide(new BigInteger("60")), sec);
			if(neg) System.out.println(" (we're gonna need a bigger record)");
			else if(tot.compareTo(new BigInteger(""+25*60)) < 0) System.out.println(" (we'll need both sides)");
			else System.out.println();
		}
	}
}
