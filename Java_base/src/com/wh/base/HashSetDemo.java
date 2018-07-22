package com.wh.base;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	
	public static void main(String[] args) {
		HashSet<Person> hs = new HashSet<Person>();
		hs.add(new Person("a1", 11));
		hs.add(new Person("a2", 12));
		hs.add(new Person("a2", 12));
		hs.add(new Person("a2", 12));
		hs.add(new Person("a3", 13));
		hs.add(new Person("a4", 14));
		hs.add(new Person("a5", 15));
		Iterator<Person> it = hs.iterator();
		while(it.hasNext()){
			Person p = it.next();
			sop("姓名："+p.getName()+",年龄："+ p.getAge());
		}
	}
	 public static void sop(Object obj) {
		 System.out.println(obj);
	}
}
