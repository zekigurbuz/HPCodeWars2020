import java.io.File;
import java.util.Scanner;

public class prob14 {
	public static boolean works(int x) {
		int s1 = 0, s2 = 0;
		boolean flag = false;
		while (x > 0) {
			if (flag) s1 += x % 10;
			else s2 += x % 10;
			flag ^= true;
			x /= 10;
		}
		return s1 == s2;
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int n1 = file.nextInt(), n2 = file.nextInt();
		int count = 0;
		for (int i = n1; i < n2; i++) {
			if (works(i)) {
				++count;
				if (count > 1) System.out.print(" ");
				System.out.print(i);
			}
		}
		if (count == 0) {
			System.out.println("No Numbers found with Equal Sum in the given range!!");
		}
		else {
			System.out.println();
		}
		file.close();
	}
}
