import java.util.*;
import java.io.*;

public class prob23 {
	public static void main(String[] args) throws Exception {
		new prob23().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		HashMap<Character,Character> hm = new HashMap<>();
		hm.put('o','o');
		hm.put('s','s');
		hm.put('x','x');
		hm.put('z','z');
		hm.put('a','e');
		hm.put('e','a');
		hm.put('b','q');
		hm.put('q','b');
		hm.put('d','p');
		hm.put('p','d');
		hm.put('h','y');
		hm.put('y','h');
		hm.put('m','w');
		hm.put('w','m');
		hm.put('n','u');
		hm.put('u','n');
		hm.put(' ',' ');
		int asdf = file.nextInt();
		file.nextLine();
		while(asdf-->0) {
			String line = file.nextLine().toLowerCase().replaceAll("[^a-z ]","");
			System.out.print(line + " (");
			String after = "";
			boolean ok = true;
			for(char c : line.toCharArray()) {
				if(hm.containsKey(c)) after = hm.get(c) + after;
				else {
					ok = false;
					after = c + after;
				}
			}
			System.out.print(ok && line.replace(" ","").equals(after.replace(" ","")) ? "is) " : "not) ");
			System.out.println(after);
		}
	}
}
