import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob13 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("input.txt"));
		String[] line = file.nextLine().split(" ");
		long yenTotal = Long.parseLong(line[0]);
		int n = Integer.parseInt(line[1]);
		String[] names = new String[n];
		long[] price = new long[n];
		for (int i = 0; i < n; i++) {
			line = file.nextLine().split(" ");
			String name = "";
			for (int j = 0; j < line.length - 1; j++) {
				if (j > 0) name += " ";
				name += line[j];
			}
			names[i] = name;
			price[i] = Long.parseLong(line[line.length - 1]);
		}
		int bestMask = 0;
		for (int mask = 0; mask < (1 << n); mask++) {
			long totalCost = 0;
			for (int i = 1, j = 0; i < (1 << n); i <<= 1, j++) {
				if ((mask & i) > 0) totalCost += price[j];
			}
			if (totalCost > yenTotal) continue;
			if (Integer.bitCount(mask) > Integer.bitCount(bestMask)) {
				bestMask = mask;
			}
		}
		long yenLeft = yenTotal;
		for (int i = 0, j = 1; i < n; i++, j <<= 1) {
			boolean afford = false;
			if ((bestMask & j) > 0) {
				afford = true;
				yenLeft -= price[i];
			}
			System.out.printf("I %s afford %s%n", afford ? "can" : "can't", names[i]);
		}
		if (bestMask == 0) {
			System.out.println("I need more Yen!");
		}
		System.out.println(yenLeft);
		file.close();
	}
}
