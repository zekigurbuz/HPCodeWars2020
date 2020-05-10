import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class prob17 {
	public static class DSU {
		int[] pset;
		int[] size;
		int numsets;

		public DSU(int size) {
			this.numsets = size;
			this.pset = new int[size];
			this.size = new int[size];
			for (int i = 0; i < size; i++)
				this.pset[i] = i;
			for (int i = 0; i < size; i++)
				this.size[i] = 1;
		}

		public int find_set(int i) {
			return pset[i] == i ? i : (pset[i] = find_set(pset[i]));
		}

		public void unify(int i, int j) {
			int a = find_set(i), b = find_set(j);
			if (a == b)
				return;
			numsets--;
			if (size[a] < size[b]) {
				pset[a] = b;
				size[b] += size[a];
			} else {
				pset[b] = a;
				size[a] += size[b];
			}
		}

		public boolean same_set(int i, int j) {
			return find_set(i) == find_set(j);
		}

		int size_set(int i) {
			return size[find_set(i)];
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int n = Integer.parseInt(file.nextLine().trim());
		String[] cities = new String[n];
		for (int i = 0; i < n; i++) cities[i] = file.nextLine();
		HashMap<String, Integer> rcities = new HashMap<>();
		for (int i = 0; i < n; i++) rcities.put(cities[i], i);
		DSU d = new DSU(n);
		while (file.hasNext()) {
			String[] line = file.nextLine().trim().split(" ");
			if (line[line.length - 1].equals("air")) continue;
			else {
				d.unify(rcities.get(line[1]), rcities.get(line[line.length - 3]));
			}
		}
		for (int i = 0; i < n; i++) {
			String pref = " is neighbour to Cities";
			String neighbors = "";
			for (int j = 0; j < n; j++) {
				if (d.same_set(i, j) && i != j) {
					if (!neighbors.isEmpty()) neighbors += ",";
					neighbors += cities[j];
				}
			}
			if (neighbors.isEmpty()) {
				neighbors = "is remote and has no neighbours!";
				pref = "";
			}
			System.out.printf("City %s%s %s%n", cities[i], pref, neighbors);
		}
		file.close();
	}
}
