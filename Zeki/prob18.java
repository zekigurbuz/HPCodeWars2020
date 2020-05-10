import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class prob18 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			double[] hm = Arrays.stream(file.nextLine().split(":")).mapToDouble(Double::parseDouble).toArray();
			double h = hm[0], m = hm[1];
			double hD = h * 30 + m * 0.5, mD = m * 6;
			double bet = Math.abs(hD-mD);
			while (bet >= 180) bet = 360 - bet;
			while (bet < 0) bet += 360;
			while (bet >= 180) bet = 360 - bet;
			while (bet < 0) bet += 360;
			System.out.printf("The angle between the Hour hand and Minute hand is %.2f degrees.%n", bet);
		}
		file.close();
	}
}
