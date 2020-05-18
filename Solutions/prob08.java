import java.io.File;
import java.util.Scanner;
public class prob08 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			String[] line = file.nextLine().trim().split("\\s+");
			StringBuilder buffer = new StringBuilder();
			for (int i = 0; i < line.length; i++) {
				if (buffer.length() + line[i].length() + (buffer.length() == 0 ? 0 : 1) <= 80) {
					if (buffer.length() != 0) buffer.append(" ");
					buffer.append(line[i]);
				}
				else {
					System.out.println(buffer);
					buffer = new StringBuilder(line[i]);
				}
			}
			if (buffer.length() != 0) System.out.println(buffer);
		}
		file.close();
	}
}
