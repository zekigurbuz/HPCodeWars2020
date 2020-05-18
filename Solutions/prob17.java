import java.util.*;
import java.io.*;

public class prob17 {
	public static void main(String[] args) throws Exception {
		new prob17().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int n = file.nextInt();
		String[] name = new String[n];
		par = new int[n]; sz = new int[n];
		HashMap<String,Integer> hm = new HashMap<>();
		for(int i = 0; i < n; i++) {
			hm.put(name[i] = file.next(),i);
			par[i] = i;
			sz[i] = 1;
		}
		file.nextLine();
		while(file.hasNext()) {
			String[] s = file.nextLine().split(" ");
			int i = hm.get(s[1]);
			int j = hm.get(s[6]);
			if(!s[8].equals("air")) union(i,j);
		}
		for(int i = 0; i < n; i++) {
			ArrayList<String> al = new ArrayList<>();
			for(int j =0 ; j < n; j++)
				if(i != j && find(i) == find(j)) al.add(name[j]);
			if(al.isEmpty()) System.out.println("City " + name[i] + " is remote and has no neighbours!");
			else System.out.println("City " + name[i] + " is neighbour to Cities " + al.toString().replaceAll("[\\[\\] ]",""));
		}
	}
	int[] par, sz;
	public int find(int i) {
		if(par[i] == i) return i;
		return par[i] = find(par[i]);
	}
	public void union(int i, int j) {
		i = find(i); j = find(j);
		if(i == j) return;
		if(sz[i] < sz[j]) {
			par[i] = j;
			sz[j] += sz[i];
		} else {
			par[j] = i;
			sz[i] += sz[j];
		}
	}
}
