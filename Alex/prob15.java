import java.util.*;
import java.io.*;

public class prob15 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			int a = file.nextInt();
			int b = file.nextInt();
			if (a == 0 && b == 0) break;
			file.nextLine();
			String[] aa = file.nextLine().split(" ");
			String[] bb = file.nextLine().split(" ");
			Set<String> x = new HashSet<>();
			Set<String> y = new HashSet<>();
			for (int i = 0; i < aa.length; i++) {
				x.add(aa[i].toLowerCase());
			}
			for (int i = 0; i < bb.length; i++) {
				y.add(bb[i].toLowerCase());
			}
			Set<String> d = new HashSet<>();
			for (String s: x) {
				if (y.contains(s)) d.add(s);
			}
			String o = "";
			for (String s: aa) o += s + " ";
			System.out.println(o.trim());
			o = "";
			for (String s: bb) o += s + " ";
			System.out.println(o.trim());
			o = d.size() + " ";
			for (String s: d) o += s + " ";
			System.out.println(o.trim());
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob15().run();
	}
}