import java.io.File;
import java.util.Scanner;

public class prob19 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		String s = file.nextLine().replaceAll("[^A-Za-z]+", "");
		String hex = "", hex_output = "";
		for (int i = 0; i < s.length(); i++) {
			String t = Integer.toString(s.charAt(i), 16);
			hex += t; hex_output += t + " ";
		}
		System.out.println(hex_output);
		String compress = "";
		for (int i = hex.length() - 1; i >= 0; i -= 4) {
			compress = hex.charAt(i) + compress;
		}
		System.out.println(compress);
		String answer = "";
		for (int i = 0; i < compress.length(); i += 2) {
			answer += "" + (char) Integer.parseInt(compress.substring(i, i + 2), 16);
		}
		System.out.println(answer);
		file.close();
	}
}
