import java.io.File;
import java.util.Scanner;

public class prob22 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		char[] aString = "ABCDEFGA".toCharArray();
		int[] indsA = {0, 2, 3, 5, 7, 8, 10, 12};
		char[] eString = "EFGABCDE".toCharArray();
		int[] indsE = {0, 1, 3, 5, 7, 8, 10, 12};
		while (file.hasNext()) {
			String[] line = file.nextLine().trim().split(" ");
			if (line.length == 1) {
				String output = "";
				for (int i = 0; i < 8; i++) {
					if (eString[i] == line[0].charAt(0)) {
						output += indsE[i] + " E "; 
					}
				}
				for (int i = 0; i < 8; i++) {
					if (aString[i] == line[0].charAt(0)) {
						output += indsA[i] + " A "; 
					}
				}
				System.out.println(output);
			}
			else {
				int next = (Integer.parseInt(line[0]) + 1) % 13;
				boolean found = false;
				if (line[1].charAt(0) == 'A') {
					do {
						for (int i = 0; i < 8; i++) {
							if (indsA[i] == next) {
								found = true;
								next = i;
								break;
							}	
						}
						if (!found) {
							next = (next + 1) % 13;
						}
					} while (!found);
				}
				else {
					do {
						for (int i = 0; i < 8; i++) {
							if (indsE[i] == next) {
								found = true;
								next = i;
								break;
							}
						}
						if (!found) {
							next = (next + 1) % 13;
						}
					} while (!found);
				}
				if (line[1].charAt(0) == 'A') {
					System.out.println(aString[next]);
				}
				else {
					System.out.println(eString[next]);
				}
			}
		}
		file.close();
	}
}
