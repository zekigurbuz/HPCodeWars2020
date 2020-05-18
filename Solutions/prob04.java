import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;
public class prob04 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		BigInteger X = new BigInteger(file.nextLine().trim()), Y = new BigInteger(file.nextLine().trim());
		System.out.println(X.multiply(Y).divide(X.gcd(Y)));
		file.close();
	}
}