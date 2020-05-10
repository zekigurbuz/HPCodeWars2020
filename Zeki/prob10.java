import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class prob10 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		Queue<String> nouns = new LinkedList<>(), adverbs = new LinkedList<>(), verbs = new LinkedList<>(), adjectives = new LinkedList<>();
		String[] sentence = file.nextLine().split(" ");
		file.nextLine();
		String s;
		while (!(s = file.next()).equals("ADVERBS")) nouns.add(s);
		while (!(s = file.next()).equals("VERBS")) adverbs.add(s);
		while (!(s = file.next()).equals("ADJECTIVES")) verbs.add(s);
		while (!(s = file.next()).equals("END")) adjectives.add(s);
		for (int x = 0; x < 2; x++) {
			for (int i = 0; i < sentence.length; i++) {
				String cur = sentence[i];
				if (cur.equals("[N]")) cur = nouns.poll();
				if (cur.equals("[AV]")) cur = adverbs.poll();
				if (cur.equals("[V]")) cur = verbs.poll();
				if (cur.equals("[AJ]")) cur = adjectives.poll();
				if (i > 0) System.out.print(" ");
				System.out.print(cur);
			}
			System.out.println();
		}
		file.close();
	}
}
