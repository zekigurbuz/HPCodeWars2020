import java.io.*;
import java.util.*;
public class genData {
	public static void main(String[] args) throws Exception {
		Random r = new Random();
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int asdf = 1; asdf <= 5; asdf++) {
			PrintWriter out = new PrintWriter(new FileWriter("stress/prob25-"+asdf+"-in.txt"));
			out.println(26 + " " + 26*26);
			for(char c : alpha.toCharArray())
				out.printf("%02d%02d %s%n", r.nextInt(99)+1, r.nextInt(99)+1, ""+c);
			for(char c : alpha.toCharArray())
				for(char d : alpha.toCharArray())
					out.println(c + " " + d);
			out.close();
		}
	}
}
