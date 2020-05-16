import java.util.*;
import java.io.*;

public class prob25 {
	public static void main(String[] args) throws Exception {
		new prob25().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int n = file.nextInt(), m = file.nextInt();
		HashMap<String,Integer> x = new HashMap<>();
		HashMap<String,Integer> y = new HashMap<>();
		while(n-->0) {
			String s = file.next();
			String t = file.next();
			int xx = Integer.parseInt(s.substring(0,2));
			int yy = Integer.parseInt(s.substring(2));
			x.put(t,xx);
			y.put(t,yy);
		}
		while(m-->0) {
			String s = file.next(), t = file.next();
			int xx = x.get(s), yy = y.get(s), xxx = x.get(t), yyy = y.get(t);
			int ans = 0;
			while(xx < xxx && yy > yyy) {
				if(xx%2 == 1) yy--;
				xx++;
				ans++;
			}
			while(xx > xxx && yy < yyy) {
				if(xx%2 == 0) yy++;
				xx--;
				ans++;
			}
			while(xx > xxx && yy > yyy) {
				if(xx%2 == 1) yy--;
				xx--;
				ans++;
			}
			while(xx < xxx && yy < yyy) {
				if(xx%2 == 0) yy++;
				xx++;
				ans++;
			}
			System.out.println(s + " " + t + " " + (ans+Math.abs(xx-xxx)+Math.abs(yy-yyy)));
		}
	}
}
