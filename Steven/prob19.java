import java.util.*;
import java.io.*;

public class prob19 {
	public static void main(String[] args) throws Exception {
		new prob19().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		char[] c = file.nextLine().replace(" ","").toCharArray();
		String ans1 = "";
		String ans2 = "";
		int prev = -1;
		for(int i = 0; i < c.length; i++) {
			System.out.printf("%x ", (int) c[i]);
			if(i % 2 != c.length % 2) {
				int v = c[i]%16;
				ans1 +=	 Integer.toString(v,16);
				if(prev == -1) prev = v;
				else {
					ans2 += (char) (prev*16+v);
					prev = -1;
				}
			}
		}
		System.out.println();
		System.out.println(ans1);
		System.out.println(ans2);
	}
}
