import java.util.*;
import java.io.*;

public class prob21 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			String name = file.nextLine().split(" ")[1];
			double rate = Double.parseDouble(file.nextLine().split(" ")[1]);
			file.next();
			String beg1 = file.nextLine().trim();
			file.next();
			String end1 = file.nextLine().trim();
			file.next();
			String beg2 = file.nextLine().trim();
			file.next();
			String end2 = file.nextLine().trim();
			int t = (60 * Integer.parseInt(end2.substring(0, 2)) + Integer.parseInt(end2.substring(2))) - (60 * Integer.parseInt(beg2.substring(0, 2)) + Integer.parseInt(beg2.substring(2))) + (60 * Integer.parseInt(end1.substring(0, 2)) + Integer.parseInt(end1.substring(2))) - (60 * Integer.parseInt(beg1.substring(0, 2)) + Integer.parseInt(beg1.substring(2)));
			System.out.printf("%s earned $%.2f%n", name, rate / 60 * t);
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob21().run();
	}
}