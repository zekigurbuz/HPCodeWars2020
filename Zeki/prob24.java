import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class prob24 {
	public static String gen(int length) {
		String s = "";
		for (int i = 0; i < length; i++) s += '*';
		return s;
	}
	public static class Word implements Comparable<Word> {
		int ind, length, row, col;
		String w;
		boolean v;
		public Word(String[] l) {
			ind = Integer.parseInt(l[0]);
			length = Integer.parseInt(l[2]);
			row = Integer.parseInt(l[4]);
			col = Integer.parseInt(l[3]);
			w = "";
			v = l[1].equals("V");
		}
		public String toString() {
			return String.format("%02d is %s", ind, w);
		}
		public String data() {
			return ind + " " + length + " " + row + " " + col + " " + w + " " + v; 
		}
		public int compareTo(Word o) {
			return ind - o.ind;
		}
	}
	public static boolean done;
	public static HashMap<Integer, ArrayList<String>> pos;
	public static HashMap<Integer, ArrayList<Boolean>> vis;
	public static char[][] mat;
	public static int[][] shad;
	public static ArrayList<Word> words;
	public static void solve(int ind) {

		if (ind == words.size()) {
			done = true;
		}
		if (done) {
			return;
		}
		ArrayList<Boolean> b1 = vis.get(words.get(ind).length);
		ArrayList<String> a1 = pos.get(words.get(ind).length);
		for (int i = 0; i < a1.size(); i++) {
			if (b1.get(i)) continue;
			else {
				boolean works = true;
				for (int j = 0; j < words.get(ind).length && works; j++) {
					if (words.get(ind).v) {
						if (mat[words.get(ind).row + j][words.get(ind).col] != 0 && mat[words.get(ind).row + j][words.get(ind).col] != a1.get(i).charAt(j)) works = false;
					}
					else {
						if (mat[words.get(ind).row][words.get(ind).col + j] != 0 && mat[words.get(ind).row][words.get(ind).col + j] != a1.get(i).charAt(j)) works = false;
					}
				}
				if (!works) continue;
				b1.set(i, true);
				for (int j = 0; j < words.get(ind).length; j++) {
					if (words.get(ind).v) {
						if (mat[words.get(ind).row + j][words.get(ind).col] == 0) {
							mat[words.get(ind).row + j][words.get(ind).col] = a1.get(i).charAt(j);
							shad[words.get(ind).row + j][words.get(ind).col] = i;
						}
					}
					else {
						if (mat[words.get(ind).row][words.get(ind).col + j] == 0) {
							mat[words.get(ind).row][words.get(ind).col + j] = a1.get(i).charAt(j);
							shad[words.get(ind).row][words.get(ind).col + j] = i;
						}
					}
				}
				solve(ind + 1);
				if (done) {
					words.get(ind).w = a1.get(i);
					return;
				}
				for (int j = 0; j < words.get(ind).length; j++) {
					if (words.get(ind).v) {
						if (shad[words.get(ind).row + j][words.get(ind).col] == i) {
							mat[words.get(ind).row + j][words.get(ind).col] = 0;
							shad[words.get(ind).row + j][words.get(ind).col] = 0;
						}
					}
					else {
						if (shad[words.get(ind).row][words.get(ind).col + j] == i) {
							mat[words.get(ind).row][words.get(ind).col + j] = 0;
							shad[words.get(ind).row][words.get(ind).col + j] = 0;
						}
					}
				}
				b1.set(ind, false);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		words = new ArrayList<>();
		pos = new HashMap<Integer, ArrayList<String>>();
		vis = new HashMap<Integer, ArrayList<Boolean>>();
		int n = 1, m = 1;
		String s;
		while (!(s = file.nextLine()).matches("-+")) {
			Word cur = new Word(s.trim().split(" "));
			words.add(cur);
			if (cur.v) n = Math.max(n, 1 + cur.row + cur.length);
			else m = Math.max(m, 1 + cur.col + cur.length);
		}
		shad = new int[n][m];
		mat = new char[n][m];
		while (!(s = file.nextLine()).matches("-+")) {
			int[] l = Arrays.stream(s.trim().split(" ")).mapToInt(x -> "ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(x) ? x.charAt(0) - 'A' : Integer.parseInt(x)).toArray();
			mat[l[1]][l[0]] = (char) ('A' + l[2]);
		}
		while (file.hasNext()) {
			s = file.nextLine();
			if (!pos.containsKey(s.length())) {
				pos.put(s.length(), new ArrayList<>());
				vis.put(s.length(), new ArrayList<>());
			}
			pos.get(s.length()).add(s);
			vis.get(s.length()).add(false);
		}
		solve(0);
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i).toString());
		}
		file.close();
	}
}
