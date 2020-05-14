import java.util.*;
import java.io.*;

public class prob12 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			String[] a = file.nextLine().split(" ");
			double sum = 0.0;
			sum += Double.parseDouble(a[0]) * 3 * 0.3048 * 100;
			if (a.length > 1) sum += Double.parseDouble(a[1]) * 0.3048 * 100;
			if (a.length > 2) sum += Double.parseDouble(a[2]) * 2.54;
			System.out.printf("%.2f%n", sum);
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob12().run();
	}
}