import java.io.File;
import java.util.Scanner;

public class prob01 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("prob01-1-in.txt"));
		String name = file.nextLine();
		System.out.printf("Welcome to CodeWars, %s!%n", name);
		file.close();
	}
}