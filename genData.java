import java.io.*;
import java.util.*;
public class genData {
	public static void main(String[] args) throws Exception {
		Random r = new Random();
		String[] arr = "abcdefghijklmnopqrstuvwxyz".split("");
		for(int asdf = 1; asdf <= 10; asdf++) {
			PrintWriter out = new PrintWriter(new FileWriter("stress/prob19-"+asdf+"-in.txt"));
			int n = r.nextInt(20)*4+r.nextInt(1)*3;
			int m = r.nextInt(20)+1;
			out.print(arr[r.nextInt(26)]);
			for(int i = 1; i < n; i++)
				out.print(arr[r.nextInt(26)]);
			out.println();
			out.print(arr[r.nextInt(26)]);
			for(int i = 1; i < m; i++)
				out.print(arr[r.nextInt(26)]);
			out.println();
			out.close();
		}
	}
}
