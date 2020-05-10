import java.util.*;
import java.io.*;

public class prob01 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt".toLowerCase()));
		System.out.println("Welcome to CodeWars, " + file.nextLine() + "!");
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob01().run();
	}
}
