import java.util.*;
import java.io.*;

public class prob06 {
	public static void main(String[] args) throws Exception {
		new prob06().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] t = {"R", "BR", "G", "BG", "B", "ZB", "P", "ZP", "Z", "BK", "W", "BW", "B"};
		while(file.hasNext()) {
			int a = file.nextInt();
			String ans = "";
			for(int i = 0; i < vals.length; i++)
				while(vals[i] <= a) {
					a -= vals[i];
					ans += t[i];
				}
			System.out.println(ans);
		}
	}
}
