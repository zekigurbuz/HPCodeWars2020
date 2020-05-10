import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class prob23 {
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		s = sb.reverse().toString();
		return s;
	}
	public static HashMap<Character, Character> flipper;
	public static String flip(String s) {
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			ans += flipper.getOrDefault(s.charAt(i), s.charAt(i));
		}
		return ans;
	}
	public static void main(String[] args) throws Exception {
		flipper = new HashMap<>();
		flipper.put('o', 'o');
		flipper.put('s', 's');
		flipper.put('x', 'x');
		flipper.put('z', 'z');
		flipper.put('a', 'e');
		flipper.put('e', 'a');
		flipper.put('b', 'q');
		flipper.put('q', 'b');
		flipper.put('d', 'p');
		flipper.put('p', 'd');
		flipper.put('h', 'y');
		flipper.put('y', 'h');
		flipper.put('m', 'w');
		flipper.put('w', 'm');
		flipper.put('n', 'u');
		flipper.put('u', 'n');
		flipper.put(' ', ' ');
		Scanner file = new Scanner(new File("prob23-3-in.txt"));
		int n = Integer.parseInt(file.nextLine());
		while (n-->0) {
			String s = file.nextLine().replaceAll("[^A-Za-z ]+", "").toLowerCase();
			String t = reverse(s);
			t = flip(t);
			System.out.printf("%s %s %s%n", s, s.replaceAll(" +", "").equals(t.replaceAll(" +", "")) ? "(is)" : "(not)", t);
		}
		file.close();
	}
}