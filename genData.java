import java.io.*;
import java.util.*;
public class genData {
	public static void main(String[] args) throws Exception {
		Random r = new Random();
		for(int asdf = 1; asdf <= 1; asdf++) {
			PrintWriter out = new PrintWriter(new FileWriter("stress/prob22-"+asdf+"-in.txt"));
			for(int i = 0; i <= 12; i++)
				for(char c : "AE".toCharArray())
					out.println(i + " " + c);
			for(char c : "ABCDEFG".toCharArray())
				out.println(c);
			out.close();
		}
	}
}
