import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;
public class prob03 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		System.out.println(new BigInteger(file.next().trim()).gcd(new BigInteger(file.next().trim())));
		file.close();
	}
}