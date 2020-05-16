import java.util.*;
import java.io.*;

public class prob16 {
	public static void main(String[] args) throws Exception {
		new prob16().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(file.hasNext()) {
			double a = file.nextDouble();
			double b = file.nextDouble();
			String op = file.next();
			double c = file.nextDouble();
			double d = 0;
			if(op.equals("ADD")) {
				op = a + " + " + b;
				d = a+b;
			}
			if(op.equals("SUBTRACT")) {
				op = a + " - " + b;
				d = a-b;
			}
			if(op.equals("MULTIPLY")) {
				op = a + " * " + b;
				d = a*b;
			}
			if(op.equals("DIVIDE")) {
				op = a + " / " + b;
				d = a/b;
			}
			if(op.equals("POWER")) {
				op = a + " ^ " + b;
				d = Math.pow(a,b);
			}
			d = Math.round(d*10)/10.0;
			if(c == d)
				System.out.println(c + " is correct for " + op);
			else System.out.println(op + " = " + d + ", not " + c);
		}
	}
}
