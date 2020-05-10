import java.util.*;
import java.io.*;

public class prob10 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("prob10-3-in.txt"));
		Queue<String> n = new LinkedList<>();
		Queue<String> v = new LinkedList<>();
		Queue<String> aj = new LinkedList<>();
		Queue<String> av = new LinkedList<>();
		String[] sentence = file.nextLine().split(" ");
		file.nextLine();
		while(file.hasNext()) {
			String x = file.nextLine();
			if (x.equals("ADVERBS")) break;
			n.add(x);
		}
		while (file.hasNext()) {
			String x = file.nextLine();
			if (x.equals("VERBS")) break;
			av.add(x);
		}
		while (file.hasNext()) {
			String x = file.nextLine();
			if (x.equals("ADJECTIVES")) break;
			v.add(x);
		}
		while (file.hasNext()) {
			String x = file.nextLine();
			if (x.equals("END")) break;
			aj.add(x);
		}
		/*int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		for (String x: sentence) {
			switch(x) {
			case "[AJ]":
				a++;
				break;
			case "[N]":
				b++;
				break;
			case "[AV]":
				c++;
				break;
			case "[V]":
				d++;
				break;
			}
		}*/
		//while (n.size() >= b && av.size() >= c && v.size() >= d && aj.size() >= a) {
		for (int i = 0; i < 2; i++) {
			String out = "";
			for (String x: sentence) {
				switch(x) {
				case "[AJ]":
					out += aj.poll() + " ";
					break;
				case "[N]":
					out += n.poll() + " ";
					break;
				case "[AV]":
					out += av.poll() + " ";
					break;
				case "[V]":
					out += v.poll() + " ";
					break;
				default:
					out += x + " ";
				}
			}
			System.out.println(out);
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob10().run();
	}
}