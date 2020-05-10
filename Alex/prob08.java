import java.util.*;
import java.io.*;

public class prob08 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			String[] x = file.nextLine().split(" ");
			String out = "";
			for (int i = 0; i < x.length; i++) {
				if (!((out + x[i]).length() > 80)) {
					out += x[i] + " ";
				}
				else {
					System.out.println(out.trim());
					out = x[i] + " ";
				}
			}
			if (!(out.equals(""))) System.out.println(out.trim());
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob08().run();
	}
}
