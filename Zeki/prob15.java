import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class prob15 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (true) {
			String[] l1 = file.nextLine().split(" ");
			int n = Integer.parseInt(l1[0]), m = Integer.parseInt(l1[1]);
			if (n == 0 && m == 0) break;
			String s1 = file.nextLine(), s2 = file.nextLine();
			System.out.println(s1);
			System.out.println(s2);
			HashSet<String> h1 = new HashSet<>(), dups = new HashSet<>(), h2 = new HashSet<>();
			for (String s : s1.split(" ")) h1.add(s.toLowerCase());
			for (String s : s2.split(" "))
				if (h1.contains(s.toLowerCase()) && !h2.contains(s.toLowerCase())) {
					dups.add(s);
					h2.add(s.toLowerCase());
				}
			System.out.print(dups.size());
			for (String s : dups) {
				System.out.print(" " + s);
			}
			System.out.println();
		}
		file.close();
	}
}
