import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
	/*
	 * 将map中的所有的键放入到set中，因为set是具备迭代器。
	所以可以迭代方式取出所有的键，再根据get方法，获取每一个键对应的值
	
	map集合的取出原理，map集合转成set集合，再通过迭代器取出value
	
	2：entrySet
	返回映射关系的set视图
	*/
	public static void main(String[] args) {
		Map<Student, String> sm = new HashMap<Student, String>();
		sm.put(new Student("lishi1",32), "beijing");
//		sm.put(new Student("lishi1",32), "forigen");
		sm.put(new Student("lishi3",33), "shanghai");
		sm.put(new Student("lishi4",34), "nanjing");
		sm.put(new Student("lishi5",35), "changsha");
		sm.put(new Student("lishi6",36), "sichuang");
		sm.put(new Student("lishi7",37), "henan");
/*		//第一种是取出keyset
		Set<Student> keySet = sm.keySet();
		Iterator<Student> it = keySet.iterator();
		while(it.hasNext()){
			Student stu = it.next();
			String addr = sm.get(stu);
			sop(stu + "..." + addr);
		}*/
		
		//第二种取出方式
		Set<Entry<Student, String>> entrySet = sm.entrySet();
		Iterator<Entry<Student, String>> it2 = entrySet.iterator();
		while(it2.hasNext()){
			Entry<Student, String> me = it2.next();
			Student student = me.getKey();
			String addr = me.getValue();
			sop(student.toString() + "...." + addr);
		}
		/*		map.put("01","zhangsha01");
		map.put("02","zhangsha02");
		map.put("03","zhangsha03");
		map.put("04","zhangsha04");
		map.put("05","zhangsha05");
		map.put("06","zhangsha06");
		//获取map集合的所有的键的set集合，keyset()
		Set<String> set = map.keySet();
		//有了set集合，就可以获取其迭代器。
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			//有了键就可以通过map集合的get方法获取其对应的值
			String value = map.get(key);
			sop("key:"+key+",value:"+value);
		}
		//将map集合中的映射关系取出，存入到set集合中
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			sop("key:"+key + "value:"+value);
		}*/
	}
	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
