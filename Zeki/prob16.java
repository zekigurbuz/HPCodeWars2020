import java.io.File;
import java.util.Scanner;

public class prob16 {
	public static double round(double x) {
		return Math.round(x * 10) / 10.0;
	}
	public static String conv(String op) {
		if (op.equals("POWER")) {
			return "^";
		}
		else if (op.equals("MULTIPLY")) {
			return "*";
		}
		else if (op.equals("DIVIDE")) {
			return "/";
		}
		else if (op.equals("ADD")) {
			return "+";
		}
		else {
			return "-";
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("prob16-1-in.txt"));
		while (file.hasNext()) {
			double a = file.nextDouble(), b = file.nextDouble();
			String op = file.next();
			double exp = file.nextDouble();
			double ans = 0.0;
			if (op.equals("POWER")) {
				ans = Math.pow(a, b);
			}
			else if (op.equals("MULTIPLY")) {
				ans = a * b;
			}
			else if (op.equals("DIVIDE")) {
				ans = a / b;
			}
			else if (op.equals("ADD")) {
				ans = a + b;
			}
			else {
				ans = a - b;
			}
			ans = round(ans);
			exp = round(exp);
			if (Math.abs(ans - exp) < 1e-6) {
				System.out.printf("%.1f is correct for %.1f %s %.1f%n", exp, a, conv(op), b);
			}
			else {
				System.out.printf("%.1f %s %.1f = %.1f, not %.1f%n", a, conv(op), b, ans, exp);
			}
		}
		file.close();
	}
}