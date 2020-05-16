import java.util.*;
import java.io.*;

public class prob14 {
	public static void main(String[] args) throws Exception {
		new prob14().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int a = (file.nextInt()+10)/11*11;
		int b = file.nextInt();
		boolean exist = false;
		for(int i = a; i < b; i+=11)
			if(check(i)) {
				if(!exist) {
					exist = true;
					System.out.print(i);
				} else System.out.print(" " + i);
			}
		if(!exist) System.out.print("No Numbers found with Equal Sum in the given range!!");
		System.out.println();
	}
	public boolean check(int i) {
		int sum = 0;
		int a = 1;
		while(i != 0) {
			sum += i%10*a;
			a *= -1;
			i /= 10;
		}
		return sum == 0;
	}
}
