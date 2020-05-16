import java.util.*;
import java.io.*;

public class prob20 {
	public static void main(String[] args) throws Exception {
		new prob20().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		int[] ans = new int[8];
		while(file.hasNext()) {
			int n = file.nextInt();
			String[] arr = file.nextLine().substring(1).split(" & ");
			if(arr.length == 1) {
				String type = arr[0];
				if(type.equals("Meat-Lovers") || type.equals("Pepperoni")) ans[0] += n*32;
				if(type.equals("Combo") || type.equals("Red Peppers")) ans[1] += n*16;
				if(type.equals("Hawaiian") || type.equals("Pineapple")) ans[2] += n*84;
				if(type.equals("Combo") || type.equals("Olives")) ans[3] += n*20;
				if(type.equals("Fishaster") || type.equals("Sardines")) ans[4] += n*12;
				if(type.equals("Fishaster") || type.equals("Combo") || type.equals("Onion")) ans[5] += n*28;
				if(type.equals("Meat-Lovers") || type.equals("Combo") || type.equals("Sausage")) ans[6] += n*40;
				if(type.equals("Meat-Lovers") || type.equals("Hawaiian") || type.equals("Ham")) ans[7] += n*36;
			} else {
				for(int i = 0; i < arr.length; i++) {
					int d = arr[i].charAt(2)-'0';
					String type = arr[i].substring(arr[i].indexOf(' ')+1);
					if(type.equals("Meat-Lovers") || type.equals("Pepperoni")) ans[0] += n*32/d;
					if(type.equals("Combo") || type.equals("Red Peppers")) ans[1] += n*16/d;
					if(type.equals("Hawaiian") || type.equals("Pineapple")) ans[2] += n*84/d;
					if(type.equals("Combo") || type.equals("Olives")) ans[3] += n*20/d;
					if(type.equals("Fishaster") || type.equals("Sardines")) ans[4] += n*12/d;
					if(type.equals("Fishaster") || type.equals("Combo") || type.equals("Onion")) ans[5] += n*28/d;
					if(type.equals("Meat-Lovers") || type.equals("Combo") || type.equals("Sausage")) ans[6] += n*40/d;
					if(type.equals("Meat-Lovers") || type.equals("Hawaiian") || type.equals("Ham")) ans[7] += n*36/d;
				}
			}
		}
		System.out.println("Pepperoni: "+ans[0]);
		System.out.println("Red Peppers: "+ans[1]);
		System.out.println("Pineapple: "+ans[2]);
		System.out.println("Olives: "+ans[3]);
		System.out.println("Sardines: "+ans[4]);
		System.out.println("Onion: "+ans[5]);
		System.out.println("Sausage: "+ans[6]);
		System.out.println("Ham: "+ans[7]);
	}
}
