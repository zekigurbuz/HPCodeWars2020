import java.util.*;
import java.io.*;

public class prob18 {
	public static void main(String[] args) throws Exception {
		new prob18().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(file.hasNext()) {
			String[] s = file.next().split(":");
			double h = Double.parseDouble(s[0])%12;
			double m = Double.parseDouble(s[1]);
			h += m/60;
			double diff = Math.abs(h/12-m/60);
			if(1-diff < diff) diff = 1-diff;
			System.out.printf("The angle between the Hour hand and Minute hand is %.2f degrees.%n", diff*360);
		}
	}
}
