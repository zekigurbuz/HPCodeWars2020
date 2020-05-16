import java.util.*;
import java.io.*;

public class prob11 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			int a = file.nextInt();
			String x = Integer.toBinaryString(a);
			if (x.length() % 2 == 0) {
				System.out.println(a + " no");
			}
			else {
				boolean b = false;
				for (int i = 0; i < x.length(); i++) {
					if ((x.charAt(i) == '1' && i == x.length()/2) || (x.charAt(i) == '0' && i != x.length()/2)) {
						System.out.println(a + " no");
						b = true;
						break;
					}
				}
				if (!b) System.out.println(a + " yes");
			}
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob11().run();
	}
}