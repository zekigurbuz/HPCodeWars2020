import java.util.*;
import java.io.*;

public class prob28 {
	public static void main(String[] args) throws Exception {
		new prob28().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(file.hasNext()) {
			String orig = file.nextLine();
			double[] arr = Arrays.stream(orig.split(" ")).mapToDouble(x -> Double.parseDouble(x)).toArray();
			boolean fib = true;
			for(int i = 2; i < arr.length; i++)
				fib &= arr[i] == arr[i-1]+arr[i-2];
			if(fib) System.out.println("Fibonacci");
			else {
				boolean _2 = true;
				boolean _3 = true;
				for(int i = 1; i < arr.length; i++) {
					_2 &= arr[i-1]*arr[i-1] == arr[i];
					_3 &= arr[i-1]*arr[i-1]*arr[i-1] == arr[i];
				}
				if(_2) System.out.println("X^2");
				else if(_3) System.out.println("X^3");
				else {
					boolean ok = false;
					boolean gaps = true;
					for(int asdf = 1; asdf < arr.length; asdf++) {
						double d = arr[asdf]/arr[asdf-1];
						double cur = arr[0];
						boolean bok = true;
						boolean bgaps = false;
						for(int i = 1; i < arr.length; i++) {
							for(int j = 0; j < 500; j++) {
								cur *= d;
								if(arr[i] == cur) {
									if(j != 0) bgaps = true;
									break;
								}
							}
							bok &= arr[i] == cur;
						}
						if(bok && !ok) {
							ok = bok;
							gaps = bgaps;
						} else if(bok) gaps &= bgaps;
					}
					if(ok) System.out.println("Geometric" + (gaps ? " (With Gaps)": ""));
					else System.out.println(orig + " is an Unknown series");
				}
			}
		}
	}
}
