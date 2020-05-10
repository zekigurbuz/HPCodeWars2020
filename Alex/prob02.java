import java.util.*;
import java.io.*;

public class prob02 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt".toLowerCase()));
		StringBuilder x = new StringBuilder(file.nextLine());
		System.out.println(x.reverse());
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob02().run();
	}
}