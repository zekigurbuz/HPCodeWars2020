import java.util.*;
import java.io.*;

public class prob19 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		String[] a = file.nextLine().split(" ");
		List<String> b = new ArrayList<String>();
		String out = "";
		for (String x: a) {
			for (int i = 0; i < x.length(); i++) {
				out += Integer.toHexString(x.charAt(i) + 0) + " ";
				b.add(Integer.toHexString(x.charAt(i) + 0));
			}
		}
		System.out.println(out.trim());
		Collections.reverse(b);
		String c = "";
		int i = 0;
		for (String x: b) {
			if (i % 4 == 0) c += x.charAt(1);
			i++;
			if (i % 4 == 0) c += x.charAt(0);
			i++;
		}
		StringBuilder sb = new StringBuilder(c);
		sb.reverse();
		System.out.println(sb);
		for (int q = 0; q < sb.toString().length(); q += 2) {
			System.out.print(((char)Integer.parseInt(sb.substring(q, q+2), 16)));
		}
		
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob19().run();
	}
}