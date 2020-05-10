import java.util.*;
import java.io.*;

public class prob07 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while (file.hasNext()) {
			String col1 = file.next();
			String col2 = file.next();
			if (col1.equals("RED")) {
				switch(col2) {
				case "RED":
					System.out.println("RED");
					break;
				case "BLUE":
					System.out.println("PURPLE");
					break;
				case "YELLOW":
					System.out.println("ORANGE");
					break;
				case "WHITE":
					System.out.println("LIGHT RED");
					break;
				case "BLACK":
					System.out.println("DARK RED");
					break;
				}
			}
			else if (col1.equals("BLUE")) {
				switch(col2) {
				case "RED":
					System.out.println("PURPLE");
					break;
				case "BLUE":
					System.out.println("BLUE");
					break;
				case "YELLOW":
					System.out.println("GREEN");
					break;
				case "WHITE":
					System.out.println("LIGHT BLUE");
					break;
				case "BLACK":
					System.out.println("DARK BLUE");
					break;
				}
			}
			else if (col1.equals("YELLOW")) {
				switch(col2) {
				case "RED":
					System.out.println("ORANGE");
					break;
				case "BLUE":
					System.out.println("GREEN");
					break;
				case "YELLOW":
					System.out.println("YELLOW");
					break;
				case "WHITE":
					System.out.println("LIGHT YELLOW");
					break;
				case "BLACK":
					System.out.println("DARK YELLOW");
					break;
				}
			}
			else if (col1.equals("ORANGE")) {
				switch(col2) {
				case "ORANGE":
					System.out.println("ORANGE");
					break;
				case "WHITE":
					System.out.println("LIGHT ORANGE");
					break;
				case "BLACK":
					System.out.println("DARK ORANGE");
					break;
				}
			}
			else if (col1.equals("PURPLE")) {
				switch(col2) {
				case "PURPLE":
					System.out.println("PURPLE");
					break;
				case "WHITE":
					System.out.println("LIGHT PURPLE");
					break;
				case "BLACK":
					System.out.println("DARK PURPLE");
					break;
				}
			}
			else if (col1.equals("GREEN")) {
				switch(col2) {
				case "GREEN":
					System.out.println("GREEN");
					break;
				case "WHITE":
					System.out.println("LIGHT GREEN");
					break;
				case "BLACK":
					System.out.println("DARK GREEN");
					break;
				}
			}
			else if (col1.equals("WHITE")) {
				switch(col2) {
				case "WHITE":
					System.out.println("WHITE");
					break;
				case "RED":
					System.out.println("LIGHT RED");
					break;
				case "BLUE":
					System.out.println("LIGHT BLUE");
					break;
				case "YELLOW":
					System.out.println("LIGHT YELLOW");
					break;
				case "GREEN":
					System.out.println("LIGHT GREEN");
					break;
				case "PURPLE":
					System.out.println("LIGHT PURPLE");
					break;
				case "ORANGE":
					System.out.println("LIGHT ORANGE");
					break;
				}
			}
			else if (col1.equals("BLACK")) {
				switch(col2) {
				case "BLACK":
					System.out.println("BLACK");
					break;
				case "RED":
					System.out.println("DARK RED");
					break;
				case "BLUE":
					System.out.println("DARK BLUE");
					break;
				case "YELLOW":
					System.out.println("DARK YELLOW");
					break;
				case "GREEN":
					System.out.println("DARK GREEN");
					break;
				case "PURPLE":
					System.out.println("DARK PURPLE");
					break;
				case "ORANGE":
					System.out.println("DARK ORANGE");
					break;
				}
			}
		}
		file.close();
	}

	public static void main(String[] args) throws Exception {
		new prob07().run();
	}
}