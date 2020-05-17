import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class prob25 {
	public static class Point {
		int x, y;
		public Point(String s) {
			x = Integer.parseInt(s.substring(0, 2));
			y = Integer.parseInt(s.substring(2));
		}
		public int dist(Point o) {
			int ans = 0;
			int xx = x, yy = y;
			while (xx < o.x && yy < o.y) {
				ans++; xx++; if (xx % 2 == 1) yy++;
			}
			while (xx > o.x && yy > o.y) {
				ans++; xx--; if (xx % 2 == 0) yy--;
			}
			while (xx < o.x && yy > o.y) {
				ans++; xx++; if (xx % 2 == 0) yy--;
			}
			while (xx > o.x && yy < o.y) {
				ans++; xx--; if (xx % 2 == 1) yy++;
			}
			while (xx > o.x) {
				ans++; xx--;
			}
			while (xx < o.x) {
				ans++; xx++;
			}
			while (yy > o.y) {
				ans++; yy--;
			}
			while (yy < o.y) {
				ans++; yy++;
			}
			return ans;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int n = file.nextInt(), q = file.nextInt();
		HashMap<String, Point> hm = new HashMap<>();
		while (n-->0) {
			String a = file.next(), b = file.next();
			hm.put(b, new Point(a));
		}
		while (q-->0) {
			String a = file.next(), b = file.next();
			System.out.printf("%s %s %d%n", a, b, hm.get(a).dist(hm.get(b)));
		}
		file.close();
	}
}
