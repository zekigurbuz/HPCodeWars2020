import java.io.File;
import java.util.Scanner;

public class prob08 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("prob08-3-in.txt"));
		while (file.hasNext()) {
			String[] line = file.nextLine().split(" ");
			String buffer = "";
			for (int i = 0; i < line.length; i++) {
				if (buffer.length() + line[i].length() + (buffer.isEmpty() ? 0 : 1) <= 80) {
					buffer += (buffer.isEmpty() ? "" : " ") + line[i];
				}
				else {
					System.out.println(buffer);
					buffer = line[i];
				}
			}
			if (!buffer.isEmpty()) {
				System.out.println(buffer);
			}
		}
		file.close();
	}
}