import java.util.*;
import java.io.*;

public class prob09 {
	public static void main(String[] args) throws Exception {
		new prob09().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int tot = 50*60-file.nextInt()*60-file.nextInt();
		System.out.printf("Time remaining %d minutes and %d seconds", tot/60, tot%60);
		if(tot < 0) System.out.println(" (we're gonna need a bigger record)");
		else if(tot < 25*60) System.out.println(" (we'll need both sides)");
		else System.out.println();
	}
}
