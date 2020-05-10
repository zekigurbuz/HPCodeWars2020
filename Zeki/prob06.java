import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class prob06 {
	public static TreeMap<Integer,String> value_map;
	public static String roman(int arabic) {
		if (arabic == 0) return "";
		int binary_search = value_map.floorKey(arabic);
		return value_map.get(binary_search) + roman(arabic - binary_search);
	}
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		value_map = new TreeMap<>(); value_map.put(1, "B"); value_map.put(4, "BW"); value_map.put(5, "W"); value_map.put(9, "BK");
		value_map.put(10, "Z"); value_map.put(40, "ZP"); value_map.put(50, "P"); value_map.put(90, "ZB");
		value_map.put(100, "B"); value_map.put(400, "BB"); value_map.put(500, "G"); value_map.put(900, "BR");
		value_map.put(1000, "R");
		while (file.hasNext()) {
			int arabic = file.nextInt();
			String answer = roman(arabic);
			System.out.println(answer);
		}
		file.close();
	}
}
