import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;
public class prob05 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		BigInteger X = new BigInteger(file.nextLine().trim());
		System.out.printf("%s is %s%n", X.toString(), X.isProbablePrime(100) ? "PRIME" : "NOT Prime");
		file.close();
	}
}