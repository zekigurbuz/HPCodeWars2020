import java.io.File;
import java.util.Scanner;
public class prob02 {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		System.out.println(new StringBuilder(file.nextLine().trim()).reverse().toString());
		file.close();
	}
}