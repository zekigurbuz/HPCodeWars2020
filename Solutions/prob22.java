import java.util.*;
import java.io.*;

public class prob22 {
	public static void main(String[] args) throws Exception {
		new prob22().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		TreeMap<Integer,Character> a = new TreeMap<>();
		TreeMap<Integer,Character> e = new TreeMap<>();
		TreeMap<Character,String> A = new TreeMap<>();
		TreeMap<Character,String> E = new TreeMap<>();
		a.put(2,'B'); A.put('B',"2");
		a.put(3,'C'); A.put('C',"3");
		a.put(5,'D'); A.put('D',"5");
		a.put(7,'E'); A.put('E',"7");
		a.put(8,'F'); A.put('F',"8");
		a.put(10,'G'); A.put('G',"10");
		a.put(12,'A'); A.put('A',"0 A 12");
		a.put(13,'A');
		
		e.put(1,'F'); E.put('F',"1");
		e.put(3,'G'); E.put('G',"3");
		e.put(5,'A'); E.put('A',"5");
		e.put(7,'B'); E.put('B',"7");
		e.put(8,'C'); E.put('C',"8");
		e.put(10,'D'); E.put('D',"10");
		e.put(12,'E'); E.put('E',"0 E 12");
		e.put(13,'E');

		while(file.hasNext()) {
			String s = file.next();
			if(Character.isDigit(s.charAt(0))) {
				if(file.next().equals("E")) System.out.println(e.higherEntry(Integer.parseInt(s)).getValue());
				else System.out.println(a.higherEntry(Integer.parseInt(s)).getValue());
			} else
				System.out.println(E.get(s.charAt(0)) + " E " + A.get(s.charAt(0)) + " A ");
		}
	}
}
