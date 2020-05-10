import java.io.File;
import java.util.Scanner;

public class prob02 {
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		s = sb.reverse().toString();
		return s;
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		String number = file.nextLine();
		number = reverse(number);
		System.out.println(number);
		file.close();
	}
}
