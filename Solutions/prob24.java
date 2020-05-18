import java.util.*;
import java.io.*;

public class prob24 {
	public static void main(String[] args) throws Exception {
		new prob24().run();
	}
	char[][] mat;
	int[][] set;
	HashMap<Integer,ArrayList<String>> all;
	HashMap<Integer,ArrayList<Boolean>> used;
	ArrayList<Rule> rules;
	boolean found;
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		rules = new ArrayList<>();
		int maxr = 0, maxc = 0;
		while(true) {
			String[] arr = file.nextLine().split(" ");
			if(arr.length == 1) break;
			Rule r;
			rules.add(r = new Rule(arr));
			if(r.h) maxc = Math.max(maxc, r.c+r.l);
			else maxr = Math.max(maxr, r.r+r.l);
		}
		mat = new char[maxr+1][maxc+1];
		set = new int[maxr+1][maxc+1];
		while(true) {
			String[] arr = file.nextLine().split(" ");
			if(arr.length == 1) break;
			mat[Integer.parseInt(arr[1])][Integer.parseInt(arr[0])] = arr[2].charAt(0);
		}
		all = new HashMap<>();
		used = new HashMap<>();
		while(file.hasNext()) {
			String s = file.next();
			if(!all.containsKey(s.length())) {
				all.put(s.length(), new ArrayList<>());
				used.put(s.length(), new ArrayList<>());
			}
			all.get(s.length()).add(s);
			used.get(s.length()).add(false);
		}
		recur(0);
		for(Rule r : rules) System.out.println(r);
	}
	public void recur(int a) {
		if(a == rules.size()) found = true;
		if(found) return;
		Rule r = rules.get(a);
		ArrayList<String> w = all.get(r.l);
		ArrayList<Boolean> b = used.get(r.l);
		for(int i = 0; i < w.size(); i++) {
			if(b.get(i)) continue;
			boolean ok = true;
			String s = w.get(i);
			for(int j = 0; ok && j < r.l; j++)
				if(r.h) ok &= mat[r.r][r.c+j] == 0 || mat[r.r][r.c+j] == s.charAt(j);
				else ok &= mat[r.r+j][r.c] == 0 || mat[r.r+j][r.c] == s.charAt(j);
			if(ok) {
				b.set(i,true);
				for(int j = 0; j < r.l; j++)
					if(r.h) {
						if(mat[r.r][r.c+j] == 0) {
							mat[r.r][r.c+j] = s.charAt(j);
							set[r.r][r.c+j] = i;
						}
					}
					else {
						if(mat[r.r+j][r.c] == 0) {
							mat[r.r+j][r.c] = s.charAt(j);
							set[r.r+j][r.c] = i;
						}
					}
				recur(a+1);
				if(found) {
					r.s = s;
					return;
				}
				for(int j = 0; j < r.l; j++)
					if(r.h) {
						if(set[r.r][r.c+j] == i) {
							mat[r.r][r.c+j] = 0;
							set[r.r][r.c+j] = 0;
						}
					}
					else {
						if(set[r.r+j][r.c] == i) {
							mat[r.r+j][r.c] = 0;
							set[r.r+j][r.c] = 0;
						}
					}
				b.set(i,false);
			}
		}
	}
	class Rule implements Comparable<Rule> {
		int i, r, c, l;
		boolean h;
		String s;
		public Rule(String[] s) {
			i = Integer.parseInt(s[0]);
			h = s[1].equals("H");
			l = Integer.parseInt(s[2]);
			c = Integer.parseInt(s[3]);
			r = Integer.parseInt(s[4]);
		}
		public int compareTo(Rule r) {
			return Integer.compare(i, r.i);
		}
		public String toString() {
			return String.format("%02d is %s", i, s);
		}
	}
}
