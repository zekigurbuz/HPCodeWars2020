import java.util.*;
import java.io.*;

public class prob04 {
	public static void main(String[] args) throws Exception {
		new prob04().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		long a = file.nextLong(), b = file.nextLong();
		System.out.println(a*b/gcd(a,b));
	}
	public long gcd(long a, long b) {
		if(a == 0 || b == 0) return a+b;
		return gcd(b%a, a);
	}
}
