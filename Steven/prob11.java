import java.util.*;
import java.io.*;

public class prob11 {
	public static void main(String[] args) throws Exception {
		new prob11().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		long v = 0;
		long cur = 4;
		HashSet<Integer> hs = new HashSet<>();
		while(v < 1000000000) {
			hs.add((int) v);
			v = cur + 2*v + 1;
			cur *= 4;
		}
		while(file.hasNext()) {
			int a = file.nextInt();
			System.out.println(a + " " + (hs.contains(a) ? "yes" : "no"));
		}
	}
}
