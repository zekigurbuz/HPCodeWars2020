import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class prob13 {
	public static class Item implements Comparable<Item> {
		public String name;
		public long cost;
		public Item(String name, long cost) {
			this.name = name;
			this.cost = cost;
		}
		public int compareTo(Item o) {
			int x = Long.compare(cost, o.cost);
			if (x == 0) return name.compareTo(o.name);
			return x;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("input.txt"));
		long yenTotal = file.nextLong();
		int n = Integer.parseInt(file.nextLine().trim());
		Item[] items = new Item[n];
		for (int i = 0; i < n; i++) {
			items[i] = new Item(file.next(), Long.parseLong(file.nextLine().trim()));
		}
		Arrays.sort(items);
		boolean any = false;
		for (int i = 0; i < n; i++) {
			if (items[i].cost <= yenTotal) {
				yenTotal -= items[i].cost;
				System.out.printf("I can afford %s%n", items[i].name);
				any = true;
			}
			else {
				System.out.printf("I can't afford %s%n", items[i].name);
			}
		}
		System.out.println(yenTotal);
		if (!any) System.out.println("I need more Yen!");
		file.close();
	}
}
