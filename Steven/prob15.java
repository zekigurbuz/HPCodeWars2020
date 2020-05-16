import java.util.*;
import java.io.*;

public class prob15 {
	public static void main(String[] args) throws Exception {
		new prob15().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(true) {
			int a = file.nextInt(), b = file.nextInt();
			if(a + b == 0) break;
			HashSet<String> h = new HashSet<>();
			while(a-->0) {
				String s = file.next();
				if(a == 0) System.out.println(s);
				else System.out.print(s + " ");
				h.add(s.toLowerCase());
			}
			HashSet<String> g = new HashSet<>();
			while(b-->0) {
				String s = file.next();
				if(b == 0) System.out.println(s);
				else System.out.print(s + " ");
				if(h.contains(s.toLowerCase())) g.add(s.toLowerCase());
			}
			System.out.print(g.size());
			for(String s : g) System.out.print(" " + s);
			System.out.println();
		}
	}
}
