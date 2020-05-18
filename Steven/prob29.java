import java.util.*;
import java.io.*;

public class prob29 {
	public static void main(String[] args) throws Exception {
		new prob29().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		String prev = "";
		boolean shouldIndent = false;
		int line = 1;
		HashSet<Integer> _1 = new HashSet<>();
		HashSet<Integer> _2 = new HashSet<>();
		HashSet<Integer> _3 = new HashSet<>();
		HashSet<Integer> _4 = new HashSet<>();
		Map<String,Integer> m = new HashMap<>();
		while(file.hasNext()) {
			String orig = file.nextLine();
			String s = orig;
			if(s.endsWith(" ") || s.endsWith("\t")) _3.add(line);
			if(s.trim().equals("NEXT") || s.trim().equals("ENDFUNC") || s.trim().equals("ENDIF")) shouldIndent = false;
			if(!(s.startsWith("    ") && !s.startsWith("     ")) && shouldIndent) _2.add(line);
			if(!shouldIndent && (s.startsWith(" ") || s.startsWith("\t"))) _2.add(line);
			if(s.contains("#")) s = s.substring(0,s.indexOf("#"));
			s = s.trim();
			if(s.startsWith("VAR")) {
				m.put("$"+s.substring(s.indexOf(' ')+1), line);
				_1.add(line);
			}
			LinkedList<String> rem = new LinkedList<>();
			for(String ss : m.keySet())
				if(s.contains(ss)) rem.add(ss);
			for(String ss : rem) _1.remove(m.remove(ss));
			if(s.startsWith("IF") || s.startsWith("FOR")) shouldIndent = true;
			if(s.startsWith("FUNC")) {
				shouldIndent = true;
				String name = s.substring(s.indexOf(' ')+1, s.indexOf('('));
				if(!prev.contains("# " + name)) _4.add(line);
			}
			prev = orig.trim();
			line++;
		}
		for(int i = 1; i <= line; i++) {
			if(_1.contains(i)) System.out.println(i+":10 Variable declared but not used");
			if(_2.contains(i)) System.out.println(i+":20 Unexpected indentation");
			if(_3.contains(i)) System.out.println(i+":30 Trailing whitespace");
			if(_4.contains(i)) System.out.println(i+":40 Func declaration without documentation");
		}
	}
}
