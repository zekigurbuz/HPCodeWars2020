import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class prob11 {
	public static boolean isCyclops(BigInteger x) {
		char[] c = x.toString(2).toCharArray();
		if (c.length % 2 == 0) return false;
		for (int i = 0; i < c.length; i++) {
			if (i == c.length / 2) {
				if (c[i] != '0') return false;
			}
			else {
				if (c[i] != '1') return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			BigInteger number = new BigInteger(file.next().trim());
			String works = isCyclops(number) ? "yes" : "no";
			System.out.printf("%d %s%n", number, works);
		}
		file.close();
	}
}