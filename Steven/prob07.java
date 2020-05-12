import java.util.*;
import java.io.*;

public class prob07 {
	public static void main(String[] args) throws Exception {
		new prob07().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(file.hasNext()) {
			String a = file.next(), b = file.next();
			if(a.equals(b)) System.out.println(a);
			else if(a.equals("WHITE")) System.out.println("LIGHT " + b);
			else if(b.equals("WHITE")) System.out.println("LIGHT " + a);
			else if(a.equals("BLACK")) System.out.println("DARK " + b);
			else if(b.equals("BLACK")) System.out.println("DARK " + a);
			else if(a.equals("RED") && b.equals("YELLOW")) System.out.println("ORANGE");
			else if(b.equals("RED") && a.equals("YELLOW")) System.out.println("ORANGE");
			else if(a.equals("RED") && b.equals("BLUE")) System.out.println("PURPLE");
			else if(b.equals("RED") && a.equals("BLUE")) System.out.println("PURPLE");
			else if(a.equals("BLUE") && b.equals("YELLOW")) System.out.println("GREEN");
			else if(b.equals("BLUE") && a.equals("YELLOW")) System.out.println("GREEN");
		}
	}
}
