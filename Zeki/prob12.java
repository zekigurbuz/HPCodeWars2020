import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class prob12 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			double[] vals = Arrays.stream(file.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
			double inches = vals[0] * 3 * 12;
			if (vals.length >= 2) inches += vals[1] * 12;
			if (vals.length >= 3) inches += vals[2];
			double centimeters = inches * 2.54;
			System.out.printf("%.2f%n", centimeters);
		}
		file.close();
	}
}
