import java.util.*;
import java.io.*;

public class prob06 {
	TreeMap<Integer, String> map;
	public void run() throws Exception {
		Scanner file = new Scanner(new File("prob06-3-in.txt"));
		map = new TreeMap<>();
		map.put(1000, "R");
        map.put(900, "BR");
        map.put(500, "G");
        map.put(400, "BG");
        map.put(100, "B");
        map.put(90, "ZB");
        map.put(50, "P");
        map.put(40, "ZP");
        map.put(10, "Z");
        map.put(9, "BK"); // Is 10 Z or K?
        map.put(5, "W");
        map.put(4, "BW");
        map.put(1, "B");
        while (file.hasNext()) {
        	int x = file.nextInt();
        	System.out.println(conv(x));
        }
		file.close();
	}
	public String conv(int x) {
		if (x == map.floorKey(x)) return map.get(map.floorKey(x));
		else return map.get(map.floorKey(x)) + conv(x - map.floorKey(x));
	}

	public static void main(String[] args) throws Exception {
		new prob06().run();
	}
}