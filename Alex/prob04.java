import java.util.*;
import java.io.*;

public class prob04 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		long a = file.nextLong(); long b = file.nextLong();
		System.out.println(a * b / gcd(a, b));
		file.close();
	}
	
	public long gcd(long a, long b) {
	    while (b != 0) {
	        long t = a;
	        a = b;
	        b = t % b;
	    }
	    return a;
	}

	public static void main(String[] args) throws Exception {
		new prob04().run();
	}
}