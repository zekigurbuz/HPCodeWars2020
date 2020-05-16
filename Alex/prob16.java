import java.util.*;
import javax.script.*;
import java.io.*;

public class prob16 {
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		ScriptEngine s = new ScriptEngineManager().getEngineByName("javascript");
		while (file.hasNext()) {
			String[] x = file.nextLine().split(" ");
			Double res = 0.0;
			if (x[2].equals("POWER")) {
				// fucking javascript
				x[2] = c(x[2]);
				res = (Double)s.eval("Math.pow(" + x[0] + ", " + x[1] + ")");
			}
			else {
				x[2] = c(x[2]);
				res = (Double)s.eval(Double.parseDouble(x[0])+x[2]+x[1]);
			}
			Double r = Double.parseDouble(x[3]);
			if (String.format("%.1f", r).equals(String.format("%.1f", res))) {
				System.out.printf("%.1f is correct for %.1f %s %.1f%n", r, Double.parseDouble(x[0]), x[2], Double.parseDouble(x[1]));
			}
			else {
				System.out.printf("%.1f %s %.1f = %.1f, not %.1f%n", Double.parseDouble(x[0]), x[2], Double.parseDouble(x[1]), res, r);
			}
		}
		file.close();
	}
	public String c(String x) {
		switch(x) {
		case "ADD":
			return "+";
		case "SUBTRACT":
			return "-";
		case "MULTIPLY":
			return "*";
		case "DIVIDE":
			return "/";
		default:
			return "^";
		}
	}

	public static void main(String[] args) throws Exception {
		new prob16().run();
	}
}