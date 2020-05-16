import java.util.*;
import java.io.*;

public class prob26 {
	public static void main(String[] args) throws Exception {
		new prob26().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int[] psum = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int i = 1; i <= 12; i++)
			psum[i] += psum[i-1];
		while(file.hasNext()) {
			String d1 = file.next(), t1 = file.next(), d2 = file.next(), t2 = file.next();
			int y1 = Integer.parseInt(d1.substring(0,4));
			int m1 = Integer.parseInt(d1.substring(5,7));
			int D1 = Integer.parseInt(d1.substring(8));
			int H1 = Integer.parseInt(t1.substring(0,2));
			int M1 = Integer.parseInt(t1.substring(3,5));
			int S1 = Integer.parseInt(t1.substring(6));
			int y2 = Integer.parseInt(d2.substring(0,4));
			int m2 = Integer.parseInt(d2.substring(5,7));
			int D2 = Integer.parseInt(d2.substring(8));
			int H2 = Integer.parseInt(t2.substring(0,2));
			int M2 = Integer.parseInt(t2.substring(3,5));
			int S2 = Integer.parseInt(t2.substring(6));
			long l = (y1*psum[12]+y1/4-y1/100+y1/400)*24*60*60 + psum[m1-1]*24*60*60+D1*24*60*60+H1*60*60+M1*60+S1;
			if(m1 <= 2 && (y1%4 == 0 && (y1%100 != 0 || y1%400 == 0))) l -= 24*60*60;
			l = (y2*psum[12]+y2/4-y2/100+y2/400)*24*60*60 + psum[m2-1]*24*60*60+D2*24*60*60+H2*60*60+M2*60+S2-l;
			if(m2 <= 2 && (y2%4 == 0 && (y2%100 != 0 || y2%400 == 0))) l -= 24*60*60;
			String flags = file.next();
			System.out.print("there are ");
			if(flags.contains("D")) {
				System.out.print(l/86400 + " days ");
				l %= 86400;
			}
			if(flags.contains("H")) {
				System.out.print(l/3600 + " hours ");
				l %= 3600;
			}
			if(flags.contains("M")) {
				System.out.print(l/60 + " minutes ");
				l %= 60;
			}
			if(flags.contains("S"))
				System.out.print(l + " seconds ");
			System.out.println("remaining until " + d2 + " " + t2);
		}
	}
}
