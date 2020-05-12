import java.util.*;
import java.io.*;
import java.math.*;

public class prob05 {
	public static void main(String[] args) throws Exception {
		new prob05().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		String s = file.next();
		System.out.print(s);
		System.out.println(new BigInteger(s).isProbablePrime(100) ? " is PRIME" : " is NOT Prime");
	}
}
