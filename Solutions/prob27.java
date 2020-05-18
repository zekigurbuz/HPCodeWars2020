import java.util.*;
import java.io.*;

public class prob27 {
	public static void main(String[] args) throws Exception {
		new prob27().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		while(true) {
			int n = file.nextInt();
			if(n == 0) break;
			String[] arr = new String[n];
			for(int i = 0; i < n; i++) arr[i] = file.next();
			boolean allsame = true;
			for(String s : arr) {
				allsame &= s.equals(arr[0]);
				System.out.print(s + " ");
			}
			if(allsame) System.out.println("COPY");
			else { 
				String diff = "";
				boolean vowels = true;
				String o = "IAEOU";
				{
					int i = 0;
					boolean found = false;
					for(int j = 0; j < arr[1].length() && j < arr[i].length(); j++) {
						if(arr[1].charAt(j) != arr[i].charAt(j)) {
							if(found || !o.contains(""+arr[i].charAt(j))) vowels = false;
							found = true;
							diff += arr[i].charAt(j);
						}
					}
				}
				for(int i = 1; i < n; i++) {
					boolean found = false;
					for(int j = 0; j < arr[0].length() && j < arr[i].length(); j++) {
						if(arr[0].charAt(j) != arr[i].charAt(j)) {
							if(found || !o.contains(""+arr[i].charAt(j))) vowels = false;
							found = true;
							diff += arr[i].charAt(j);
						}
					}
					if(!found) vowels = false;
				}
				if(vowels) {
					int prev = -1;
					boolean ok = true;
					for(char c : diff.toCharArray()) {
						int nx = o.indexOf(c);
						ok &= nx > prev;
						prev = nx;
					}
					if(ok) System.out.println("PROGRESSIVE");
					else System.out.println("ABLAUT");
				} else if(n == 2 && (!arr[0].startsWith("SHM") && arr[1].startsWith("SHM"))) System.out.println("SHM");
				else System.out.println("RHYMING");
			}
		}
	}
}
