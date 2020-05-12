import java.util.*;
import java.io.*;

public class prob01 {
	public static void main(String[] args) throws Exception {
		new prob01().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		System.out.println("Welcome to CodeWars, " + file.next() + "!");
	}
}
