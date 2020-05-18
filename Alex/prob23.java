import java.util.*;
import java.io.*;

public class prob23 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		HashMap<Character, Character> map = new HashMap<>();
		map.put('o','o');
		map.put('s','s');
		map.put('x','x');
		map.put('z','z');
		map.put('a','e');
		map.put('e','a');
		map.put('b','q');
		map.put('q','b');
		map.put('d','p');
		map.put('p','d');
		map.put('h','y');
		map.put('y','h');
		map.put('m','w');
		map.put('w','m');
		map.put('n','u');
		map.put('u','n');
		int times = file.nextInt(); file.nextLine();
		for (int i = 0; i < times; i++) {
			String a = file.nextLine().toLowerCase().replaceAll("[^a-z ]", "");
			String b = new StringBuilder(a).reverse().toString();
			for (int j = 0; j < b.length(); j++) {
				if (map.get(b.charAt(j)) != null) {
					b = b.substring(0, j) + map.get(b.charAt(j)) + b.substring(j+1);
				}
			}
			if (b.replaceAll(" ", "").equals(a.replaceAll(" ", ""))) {
				System.out.println(a.trim() + " (is) " + b.trim());
			}
			else {
				System.out.println(a.trim() + " (not) " + b.trim());
			}
			
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob23().run();
	}
}