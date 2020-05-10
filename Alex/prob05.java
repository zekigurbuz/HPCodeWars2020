import java.util.*;
import java.io.*;
import java.math.*;

public class prob05 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		String x = file.nextLine();
		System.out.println(new BigInteger(x).isProbablePrime(32) ? x + " is PRIME" : x + " is NOT prime");
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob05().run();
	}
}