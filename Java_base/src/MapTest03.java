import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest03 {
	
	public static void main(String[] args) {
		charCount("abcdefgaaabbccccddgadgadg");
	}
	
	public static String charCount(String str) {
		char[] chs = str.toCharArray();
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
		int count =0;
		for(int x=0; x<chs.length;x++){
			Integer value = tm.get(chs[x]);
			if(null != value)
				count = value;
			count++;
			tm.put(chs[x], count);
			count = 0;
		}
//		sop(tm);
		StringBuilder sb = new StringBuilder();
		Set<Entry<Character, Integer>> entrySet = tm.entrySet();
		Iterator<Entry<Character, Integer>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<Character, Integer> entry = it.next();
			Character key = entry.getKey();
			Integer value = entry.getValue();
			sop("char:"+key +",count:"+value);
		}
		return "";
	}
	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
