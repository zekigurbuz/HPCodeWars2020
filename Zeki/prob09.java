import java.io.File;
import java.util.Scanner;
import java.math.BigInteger;
public class prob09 {
	public static BigInteger b(String s) {
		return new BigInteger(s.trim());
	}
	public static boolean z(BigInteger b) {
		return b.equals(BigInteger.ZERO);
	}
	public static boolean lt(BigInteger a, BigInteger b) {
		return a.compareTo(b) < 0;
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		BigInteger total = b("3000");
		while (true) {
			BigInteger m = b(file.next()), s = b(file.next());
			if (z(m) && z(s)) break;
			BigInteger lf = total.subtract(s);
			lf = lf.subtract(m.multiply(b("60")));
			BigInteger ml = lf.divide(b("60"));
			lf = lf.subtract(ml.multiply(b("60")));
			BigInteger sl = b(lf.toString());
			lf = lf.add(ml.multiply(b("60")));
			System.out.printf("Time remaining %s minutes and %s seconds%s%n", ml.toString(), sl.toString(), lt(lf, BigInteger.ZERO) ? " (we're gonna need a bigger record)" : lt(lf, b("1500")) ? " (we'll need both sides)" : "");
		}
		file.close();
	}
}
