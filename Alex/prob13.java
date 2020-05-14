import java.util.*;
import java.io.*;

public class prob13 {
	class Item implements Comparable<Item> {
		int cost;
		String name;
		public Item(String n, int c) {
			cost = c;
			name = n;
		}
		public int compareTo(Item m) {
			return cost-m.cost;
		}
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int p = file.nextInt(); int n = file.nextInt(); file.nextLine();
		List<Item> l = new ArrayList<>();		
		for (int i = 0; i < n; i++) {
			l.add(new Item(file.next(), Integer.parseInt(file.next())));
		}
		Collections.sort(l);
		int i = 0;
		while (i < l.size() && p - l.get(i).cost >= 0) {
			System.out.println("I can afford " + l.get(i).name);
			p -= l.get(i++).cost;
		}
		boolean a = false;
		while (i < l.size()) {
			a = true;
			System.out.println("I can't afford " + l.get(i++).name);
		}
		if (a) System.out.println("I need more Yen!");
		System.out.println(p);
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob13().run();
	}
}