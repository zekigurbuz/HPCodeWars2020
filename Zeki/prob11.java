import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob11 {
	public static boolean isCyclops(int x) {
		char[] c = Integer.toBinaryString(x).toCharArray();
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
		Scanner file = new Scanner(new File("prob11-1-in.txt"));
		while (file.hasNext()) {
			int number = file.nextInt();
			String works = isCyclops(number) ? "yes" : "no";
			System.out.printf("%d %s%n", number, works);
		}
		file.close();
	}
}