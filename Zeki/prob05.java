import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class prob05 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("prob05-3-in.txt"));
		BigInteger X = new BigInteger(file.nextLine());
		boolean isPrime = X.isProbablePrime(100);
		System.out.printf("%s is %s%n", X.toString(), isPrime ? "PRIME" : "NOT Prime");
		file.close();
	}
}