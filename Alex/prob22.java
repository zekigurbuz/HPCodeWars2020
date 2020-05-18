import java.util.*;
import java.io.*;

public class prob22 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		String[] e = new String[] {"E", "F", null, "G", null, "A", null, "B", "C", null, "D", null, "E"};
		String[] a = new String[] {"A", null, "B", "C", null, "D", null, "E", "F", null, "G", null, "A"};
		while (file.hasNext()) {
			String x = file.nextLine();
			if (x.length() == 1) {
				int i = 0;
				int j = 0;
				for (int k = 12; k >= 0; k--) {
					if (e[k] != null && e[k].equals(x)) {
						i = k;
					}
					if (a[k] != null && a[k].equals(x)) {
						j = k;
					}
				}
				if (i == 0 && j == 0) System.out.println(i + " E " + j + " A 12 E 12 A");
				else if (i == 0) System.out.println(i + " E 12 E " + j + " A");
				else if (j == 0) System.out.println(i + " E " + j + " A 12 A");
				else System.out.println(i + " E " + j + " A");
			}
			else {
				String[] u = x.split(" ");
				int w = Integer.parseInt(u[0]) + 1;
				if (u[1].equals("E")) {
					while (e[w % 13] == null) w++;
					System.out.println(e[w%13]);
				}
				else {
					while (a[w % 13] == null) w++;
					System.out.println(a[w%13]);
				}
			}
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob22().run();
	}
}