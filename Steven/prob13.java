import java.util.*;
import java.io.*;

public class prob13 {
	public static void main(String[] args) throws Exception {
		new prob13().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		long tot = file.nextLong();
		int n = file.nextInt();
		Pair[] p = new Pair[n];
		for(int i = 0; i < n; i++)
			p[i] = new Pair(file.next(), file.nextInt());
		Arrays.sort(p);
		boolean b = tot < p[0].a;
		for(Pair pp : p)
			if(pp.a <= tot) {
				System.out.println("I can afford " + pp.s);
				tot -= pp.a;
			} else
				System.out.println("I can't afford " + pp.s);
		if(b) System.out.println("I need more Yen!");
		System.out.println(tot);
	}
	class Pair implements Comparable<Pair> {
		String s;
		int a;
		public Pair(String t, int b) {
			s = t;
			a = b;
		}
		public int compareTo(Pair p) {
			return Integer.compare(a,p.a);
		}
	}
}
