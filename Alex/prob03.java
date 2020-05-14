import java.util.*;
import java.io.*;

public class prob03 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		System.out.println(gcd(file.nextLong(), file.nextLong()));
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
		new prob03().run();
	}
}