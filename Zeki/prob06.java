import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class prob06 {
	public static TreeMap<Integer,String> value_map;
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int[] v = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] s = "R BR G BG B ZB P ZP Z BK W BW B".split(" ");
		while (file.hasNext()) {
			int c = file.nextInt();
			for (int i = 0; i < v.length; i++) {
				while (v[i] <= c) {
					c -= v[i];
					System.out.print(s[i]);
				}
			}
			System.out.println();
		}
		file.close();
	}
}
