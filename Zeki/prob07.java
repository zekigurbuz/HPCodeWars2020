import java.io.File;
import java.util.Scanner;

public class prob07 {
	public static String addBlack(String s) {
		if (s.equals("BLACK")) return s;
		else return "DARK " + s;
	}
	public static String addWhite(String s) {
		if (s.equals("WHITE")) return s;
		else return "LIGHT " + s;
	}
	public static String addPrimary(String s1, String s2) {
		if (s1.equals("RED")) {
			if (s2.equals("BLUE")) {
				return "PURPLE";
			}
			else {
				return "ORANGE";
			}
		}
		else if (s1.equals("YELLOW")) {
			if (s2.equals("RED")) {
				return "ORANGE";
			}
			else {
				return "GREEN";
			}
		}
		else {
			if (s2.equals("RED")) {
				return "PURPLE";
			}
			else {
				return "GREEN";
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			String color1 = file.next(), color2 = file.next();
			if (color1.equals("BLACK")) {
				System.out.println(addBlack(color2));
			}
			else if (color1.equals("WHITE")) {
				System.out.println(addWhite(color2));
			}
			else if (color2.equals("BLACK")) {
				System.out.println(addBlack(color1));
			}
			else if (color2.equals("WHITE")) {
				System.out.println(addWhite(color1));
			}
			else if (color1.equals(color2)) {
				System.out.println(color1);
			}
			else {
				String answer = addPrimary(color1, color2);
				System.out.println(answer);
			}
		}
		file.close();
	}
}
