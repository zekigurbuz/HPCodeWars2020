import java.util.*;
import java.io.*;

public class prob20 {
	int pep;
	int rpe;
	int pin;
	int oli;
	int sar;
	int oni;
	int sau;
	int ham;
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		pep = 0;
		rpe = 0;
		pin = 0;
		oli = 0;
		sar = 0;
		oni = 0;
		sau = 0;
		ham = 0;
		while (file.hasNext()) {
			String z = file.nextLine();
			String[] a = z.split(" ");
			if (a[1].equals("1/4")) {
				int times = Integer.parseInt(a[0]);
				a = z.substring(z.indexOf(' ')+1).split(" & ");
				if (a[1].matches("1/4.*")) {
					if (a[2].matches("1/4.*")) {
						// 1/4, 1/4, 1/4, 1/4
						for (int i = 0; i < times; i++) {
							add(a[0].substring(a[0].indexOf(' ')+1), 1);
							add(a[1].substring(a[1].indexOf(' ')+1), 1);
							add(a[2].substring(a[2].indexOf(' ')+1), 1);
							add(a[3].substring(a[3].indexOf(' ')+1), 1);
						}
					}
					else {
						// 1/4, 1/4, 1/2
						for (int i = 0; i < times; i++) {
							add(a[0].substring(a[0].indexOf(' ')+1), 1);
							add(a[1].substring(a[1].indexOf(' ')+1), 1);
							add(a[2].substring(a[2].indexOf(' ')+1), 2);
						}
					}
				}
				else {
					// 1/4, 1/2, 1/4
					for (int i = 0; i < times; i++) {
						add(a[0].substring(a[0].indexOf(' ')+1), 1);
						add(a[1].substring(a[1].indexOf(' ')+1), 2);
						add(a[2].substring(a[2].indexOf(' ')+1), 1);
					}
				}
			}
			else if (a[1].equals("1/2")) {
				int times = Integer.parseInt(a[0]);
				a = z.substring(z.indexOf(' ')+1).split(" & ");
				if (a[1].matches("1/4.*")) {
					// 1/2, 1/4, 1/4
					for (int i = 0; i < times; i++) {
						add(a[0].substring(a[0].indexOf(' ')+1), 2);
						add(a[1].substring(a[1].indexOf(' ')+1), 1);
						add(a[2].substring(a[2].indexOf(' ')+1), 1);
					}
				}
				else {
					// 1/2, 1/2
					for (int i = 0; i < times; i++) {
						add(a[0].substring(a[0].indexOf(' ')+1), 2);
						add(a[1].substring(a[1].indexOf(' ')+1), 2);
					}
				}
			}
			else {
				// 1
				for (int i = 0; i < Integer.parseInt(a[0]); i++) {
					add(a[1], 4);
				}
			}
		}
		System.out.println("Pepperoni: " + pep);
		System.out.println("Red Peppers: " + rpe);
		System.out.println("Pineapple: " + pin);
		System.out.println("Olives: " + oli);
		System.out.println("Sardines: " + sar);
		System.out.println("Onion: " + oni);
		System.out.println("Sausage: " + sau);
		System.out.println("Ham: " + ham);
		file.close();
	}
	
	public void add(String x, int times) {
		x = x.trim();
		switch(x) {
		case "Pepperoni":
			pep += times * 8;
			return;
		case "Red Peppers":
			rpe += times * 4;
			return;
		case "Pineapple":
			pin += times * 21;
			return;
		case "Olives":
			oli += times * 5;
			return;
		case "Sardines":
			sar += times * 3;
			return;
		case "Onion":
			oni += times * 7;
			return;
		case "Sausage":
			sau += times * 10;
			return;
		case "Ham":
			ham += times * 9;
			return;
		case "Hawaiian":
			ham += times * 9;
			pin += times * 21;
			return;
		case "Combo":
			rpe += times * 4;
			oli += times * 5;
			oni += times * 7;
			sau += times * 10;
			return;
		case "Fishaster":
			sar += times * 3;
			oni += times * 7;
			return;
		case "Meat-Lovers":
			pep += times * 8;
			sau += times * 10;
			ham += times * 9;
			return;
		case "Cheese":
			return;
		default:
			return;
		}
	}

	public static void main(String[] args) throws Exception {
		new prob20().run();
	}
}