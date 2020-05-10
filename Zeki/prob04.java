import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class prob04 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("prob04-1-in.txt"));
		BigInteger X = new BigInteger(file.nextLine()), Y = new BigInteger(file.nextLine());
		BigInteger GCD = X.gcd(Y);
		BigInteger LCM = X.multiply(Y).divide(GCD);
		System.out.println(LCM);
		file.close();
	}
}