import java.util.*;
import java.io.*;

public class prob12 {
	public static void main(String[] args) throws Exception {
		new prob12().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(file.hasNext()) {
			Scanner line = new Scanner(file.nextLine());
			double tot = line.nextDouble()*36;
			if(line.hasNext()) tot += line.nextDouble()*12;
			if(line.hasNext()) tot += line.nextDouble();
			System.out.printf("%.2f%n",tot*2.54);
		}		
	}
}
