import java.util.*;
import java.io.*;

public class prob18 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			String[] a = file.nextLine().split(":");
			double dh = Double.parseDouble(a[0]) * 30 + Double.parseDouble(a[1]) * 0.5;
			double dm = Double.parseDouble(a[1]) * 6;
			double q = Math.abs(dh-dm);
			while (q >= 180) q = 360 - q;
			while (q < 0) q += 360;
			while (q >= 180) q = 360 - q;
			while (q < 0) q += 360;
			
			System.out.printf("The angle between the Hour hand and the Minute hand is %.2f degrees.%n", q);
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob18().run();
	}
}