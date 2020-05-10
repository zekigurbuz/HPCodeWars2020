import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class prob20 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("prob20-1-in.txt"));
		LinkedHashMap<String, int[]> rtop = new LinkedHashMap<>();
		rtop.put("Pepperoni", new int[] {0});
		rtop.put("Red Peppers", new int[] {1});
		rtop.put("Pineapple", new int[] {2});
		rtop.put("Olives", new int[] {3});
		rtop.put("Sardines", new int[] {4});
		rtop.put("Onion", new int[] {5});
		rtop.put("Sausage", new int[] {6});
		rtop.put("Ham", new int[] {7});
		rtop.put("Hawaiian", new int[] {2,7});
		rtop.put("Combo", new int[] {1, 3, 5, 6});
		rtop.put("Fishaster", new int[] {4, 5});
		rtop.put("Meat-Lovers", new int[] {0, 6, 7});
		rtop.put("Cheese", new int[] {});
		int[] perPizza = {32, 16, 84, 20, 12, 28, 40, 36};
		int[] totTop = {0, 0, 0, 0, 0, 0, 0, 0};
		String[] names = {"Pepperoni", "Red Peppers", "Pineapple", "Olives", "Sardines", "Onion", "Sausage", "Ham"};
		while (file.hasNext()) {
			String line = file.nextLine();
			int number = Integer.parseInt(line.substring(0, line.indexOf(" ")));
			line = line.substring(line.indexOf(" ") + 1);
			String[] tops = line.split(" & ");
			for (int i = 0; i < tops.length; i++) {
				String[] ord = tops[i].split(" ");
				String name = "";
				int d = 1;
				if (ord.length == 1) name = ord[0];
				else if (ord.length == 2) {
					if (ord[1].equals("Peppers")) name = "Red Peppers";
					else {
						name = ord[1];
						d = Integer.parseInt(ord[0].substring(2));
					}
				}
				else {
					d = Integer.parseInt(ord[0].substring(2));
					name = "Red Peppers";
				}
				if (name.equals("Olive")) name += "s";
				for (int j : rtop.getOrDefault(name, new int[] {})) totTop[j] += perPizza[j] * number / d;
			}
		}
		for (int i = 0; i < 8; i++) {
			System.out.printf("%s: %d%n", names[i], totTop[i]);
		}
		file.close();
	}
}