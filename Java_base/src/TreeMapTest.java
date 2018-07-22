import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	
	public static void main(String[] args) {
		
		TreeMap<Student, String> tm = new TreeMap<Student, String>(new StuNameComparator()
				);
		tm.put(new Student("lishi1",32), "beijing");
//	sm.put(new Student("lishi1",32), "forigen");
		tm.put(new Student("lishi4",37), "nanjing");
		tm.put(new Student("blishi3",33), "shanghai");
		tm.put(new Student("lishi6",36), "sichuang");
		tm.put(new Student("lishi5",35), "changsha");
		tm.put(new Student("alishi7",38), "henan");
		Set<Entry<Student, String>> entrySet = tm.entrySet();
		Iterator<Entry<Student, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<Student, String> me = it.next();
			String addr = me.getValue();
			Student student = me.getKey();
			sop(student.getName() + "...." + addr);
		}
	}
	
	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
