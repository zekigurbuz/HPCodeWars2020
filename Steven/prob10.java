import java.util.*;
import java.io.*;

public class prob10 {
	public static void main(String[] args) throws Exception {
		new prob10().run();
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.txt"));
		String orig = file.nextLine();	
		file.next();
		LinkedList<String> n = new LinkedList<>();
		LinkedList<String> av = new LinkedList<>();
		LinkedList<String> v = new LinkedList<>();
		LinkedList<String> aj = new LinkedList<>();
		while(true) {
			String s = file.next();
			if(s.equals("ADVERBS")) break;
			n.add(s);
		}
		while(true) {
			String s = file.next();
			if(s.equals("VERBS")) break;
			av.add(s);
		}
		while(true) {
			String s = file.next();
			if(s.equals("ADJECTIVES")) break;
			v.add(s);
		}
		while(true) {
			String s = file.next();
			if(s.equals("END")) break;
			aj.add(s);
		}
		Scanner s = new Scanner(orig);
		{
			String ss = s.next();
			while(ss.contains("[N]")) ss = ss.replaceFirst("\\[N\\]",n.pollFirst());
			while(ss.contains("[AV]")) ss = ss.replaceFirst("\\[AV\\]",av.pollFirst());
			while(ss.contains("[V]")) ss = ss.replaceFirst("\\[V\\]",v.pollFirst());
			while(ss.contains("[AJ]")) ss = ss.replaceFirst("\\[AJ\\]",aj.pollFirst());
			System.out.println(ss);
		}
		while(s.hasNext()) {
			String ss = s.next();
			while(ss.contains("[N]")) ss = ss.replaceFirst("\\[N\\]",n.pollFirst());
			while(ss.contains("[AV]")) ss = ss.replaceFirst("\\[AV\\]",av.pollFirst());
			while(ss.contains("[V]")) ss = ss.replaceFirst("\\[V\\]",v.pollFirst());
			while(ss.contains("[AJ]")) ss = ss.replaceFirst("\\[AJ\\]",aj.pollFirst());
			System.out.println(" " + ss);
		}
		System.out.println();
		s = new Scanner(orig);
		{
			String ss = s.next();
			while(ss.contains("[N]")) ss = ss.replaceFirst("\\[N\\]",n.pollFirst());
			while(ss.contains("[AV]")) ss = ss.replaceFirst("\\[AV\\]",av.pollFirst());
			while(ss.contains("[V]")) ss = ss.replaceFirst("\\[V\\]",v.pollFirst());
			while(ss.contains("[AJ]")) ss = ss.replaceFirst("\\[AJ\\]",aj.pollFirst());
			System.out.println(ss);
		}
		while(s.hasNext()) {
			String ss = s.next();
			while(ss.contains("[N]")) ss = ss.replaceFirst("\\[N\\]",n.pollFirst());
			while(ss.contains("[AV]")) ss = ss.replaceFirst("\\[AV\\]",av.pollFirst());
			while(ss.contains("[V]")) ss = ss.replaceFirst("\\[V\\]",v.pollFirst());
			while(ss.contains("[AJ]")) ss = ss.replaceFirst("\\[AJ\\]",aj.pollFirst());
			System.out.println(" " + ss);
		}
		System.out.println();
	}
}
