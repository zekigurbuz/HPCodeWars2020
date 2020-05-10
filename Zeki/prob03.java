import java.io.File;
import java.util.Scanner;

public class prob03 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("prob03-1-in.txt"));
		long X = file.nextLong(), Y = file.nextLong(), largest_div = 1L;
		for (long divisor = 2L; divisor * divisor <= Math.min(X, Y); ++divisor) {
			if (X % divisor == 0L && Y % divisor == 0L) {
				largest_div = Math.max(largest_div, Math.max(Math.min(X, Y) / divisor, divisor));
			}
			else if (X % divisor == 0L || Y % divisor == 0L) {
				long divisor2 = X % divisor == 0L ? X / divisor : Y / divisor;
				if (X % divisor2 == 0L && Y % divisor2 == 0L) {
					largest_div = Math.max(largest_div, Math.max(Math.min(X, Y) / divisor2, divisor2));
				}
			}
		}
		System.out.println(largest_div);
		file.close();
	}
}