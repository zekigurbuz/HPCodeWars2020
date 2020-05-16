import java.util.*;
import java.io.*;

public class prob14 {
	List<Integer> works;
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int a = file.nextInt(); int b = file.nextInt();
		works = new ArrayList<>();
		for (int i = a; i < b; i++) {
			check(i);
		}
		if (works.isEmpty()) {
			System.out.println("No Numbers found with Equal Sum in the given range!!");
		}
		else {
			String o = "";
			for (int x: works) {
				o += x + " ";
			}
			System.out.println(o.trim());
		}
		file.close();
	}
	public void check(int a) {
		String x = a + "";
		int e = 0;
		int o = 0;
		for (int i = 0; i < x.length(); i++) {
			if (i % 2 == 0) e += Integer.parseInt(x.substring(i, i+1));
			else o += Integer.parseInt(x.substring(i, i+1));
		}
		if (e == o) works.add(a);
	}

	public static void main(String[] args) throws Exception {
		new prob14().run();
	}
}