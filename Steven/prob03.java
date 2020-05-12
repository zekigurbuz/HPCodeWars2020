import java.util.*;
import java.io.*;

public class prob03 {
	public static void main(String[] args) throws Exception {
		new prob03().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		System.out.println(gcd(file.nextLong(), file.nextLong()));
	}
	public long gcd(long a, long b) {
		if(a == 0 || b == 0) return a+b;
		return gcd(b%a, a);
	}
}
