import java.util.*;
import java.io.*;

public class prob02 {
	public static void main(String[] args) throws Exception {
		new prob02().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		System.out.println(new StringBuffer(file.next()).reverse());
	}
}
