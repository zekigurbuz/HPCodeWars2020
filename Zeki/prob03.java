import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class prob03 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		BigInteger X = new BigInteger(file.next()), Y = new BigInteger(file.next());
		System.out.println(X.gcd(Y));
		file.close();
	}
}
