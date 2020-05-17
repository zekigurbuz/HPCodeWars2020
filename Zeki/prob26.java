import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class prob26 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			String t1 = file.next() + " " + file.next(), t2 = file.next() + " " + file.next(), q = file.next();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date a = f.parse(t1), b = f.parse(t2);
			long difference = b.getTime() - a.getTime();
			System.out.print("there are ");
			if (q.contains("D")) {
				long diff = difference / (24L * 1000 * 60 * 60);
				difference %=  24L * 1000 * 60 * 60;
				System.out.print(diff + " days ");
			}
			if (q.contains("H")) {
				long diff = difference / (1000L * 60 * 60);
				difference %= 1000L * 60 * 60;
				System.out.print(diff + " hours ");
			}
			if (q.contains("M")) {
				long diff = difference / (1000L * 60);
				difference %= 1000L * 60;
				System.out.print(diff + " minutes ");
			}
			if (q.contains("S")) {
				long diff = difference / (1000L);
				difference %= 1000L;
				System.out.print(diff + " seconds ");
			}
			System.out.println("remaining until " + t2);
		}
		file.close();
	}
}
