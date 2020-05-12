import java.util.*;
import java.io.*;

public class prob08 {
	public static void main(String[] args) throws Exception {
		new prob08().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(file.hasNext()) {
			Scanner line = new Scanner(file.nextLine());
			String cur = line.next();
			while(line.hasNext()) {
				String nx = line.next();
				if(cur.length() + nx.length() + 1 > 80) {
					System.out.println(cur);
					cur = nx;
				} else cur += " " + nx;
			}
			System.out.println(cur);
		}
	}
}
