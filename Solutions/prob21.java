import java.util.*;
import java.io.*;

public class prob21 {
	public static void main(String[] args) throws Exception {
		new prob21().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(file.hasNext()) {
			file.next(); System.out.print(file.next() + " earned $");
			file.next();
			double d = file.nextDouble();
			file.next();
			double t = -proc(file.nextInt());
			file.next();
			t += proc(file.nextInt());
			file.next();
			t -= proc(file.nextInt());
			file.next();
			t += proc(file.nextInt());
			System.out.printf("%.2f%n", t*d);
		}
	}
	public double proc(int i) {
		return i/100+i%100/60.;
	}
}
