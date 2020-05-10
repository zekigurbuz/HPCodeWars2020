import java.util.*;
import java.io.*;

public class prob09 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			int m = file.nextInt(); int s = file.nextInt();
			if (m == 0 && s == 0) break;
			int x = 3000 - s - (m * 60);
			System.out.print("Time remaining " + (x / 60) + " minutes and " + (x % 60) + " seconds");
			if (x < 0) System.out.println(" (we're gonna need a bigger record)");
			else if (x < 1500) System.out.println(" (we'll need both sides)");
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob09().run();
	}
}