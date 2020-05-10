import java.io.File;
import java.util.Scanner;

public class prob09 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int total = 2 * 25 * 60;
		while (true) {
			int minutes = file.nextInt(), seconds = file.nextInt();
			if (minutes == 0 && seconds == 0) break;
			int left = total - seconds - 60 * minutes;
			int minutes_left = left / 60;
			left -= minutes_left * 60;
			int seconds_left = left;
			left += minutes_left * 60;
			System.out.printf("Time remaining %d minutes and %d seconds%s%n", minutes_left, seconds_left, left < 0 ? " (we're gonna need a bigger record)" : left < 25 * 60 ? " (we'll need both sides)" : "");
		}
		file.close();
	}
}
