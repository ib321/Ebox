package lord.toni;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class Main {
	public static int count(String str, ArrayList<String> wordset) {
		int count = 0;
		for (String stri : wordset) {
			if (stri.equalsIgnoreCase(str))
				count++; }
		return count;
	}
	public static HashMap<String, Integer> sortByValue(Map<String, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
		// Sort the list using lambda expression
		Collections.sort(list, (i1, i2) -> i2.getValue().compareTo(i1.getValue()));
		// put data from sorted list to Hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
	public static void main(String[] args) throws IOException {
		//String path = "C:\\Users\\india\\OneDrive\\Desktop\\";
		String fileName = "MyMiscProjects\\LordToni\\lyrics.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		ArrayList<String> words = new ArrayList<String>();
		String Line = br.readLine();
		while (Line != null) {
			String[] word = Line.split(" ");
			for (String string : word) {
				words.add(string);
			}
			Line = br.readLine();
		}
		Map<String, Integer> wordmap = new LinkedHashMap<String, Integer>();
		LinkedHashSet<String> wordset = new LinkedHashSet<String>(words);
		for (String string : wordset) {
			wordmap.put(string, count(string, words));
			// System.out.println(string+"---"+count(string,words));
		}
		// System.out.println(sortByValue(wordmap));
		for (Map.Entry<String, Integer> aa : sortByValue(wordmap).entrySet()) {
			System.out.println(aa.getKey() + "    --    " + aa.getValue());
		}	br.close();
	}
}
