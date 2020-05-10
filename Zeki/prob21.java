import java.io.File;
import java.util.Scanner;

public class prob21 {
	public static int time_conv(String s) {
		return 60 * Integer.parseInt(s.substring(0, 2)) + Integer.parseInt(s.substring(2));
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			file.next();
			String empName = file.nextLine().trim();
			file.next();
			double payRate = Double.parseDouble(file.nextLine().trim());
			file.next();
			int in1 = time_conv(file.nextLine().trim());
			file.next();
			int out1 = time_conv(file.nextLine().trim());
			file.next();
			int in2 = time_conv(file.nextLine().trim());
			file.next();
			int out2 = time_conv(file.nextLine().trim());
			int sumTime = out2 + out1 - in2 - in1;
			double money = payRate * sumTime / 60;
			System.out.printf("%s earned $%.2f%n", empName, money);
		}
		file.close();
	}
}
