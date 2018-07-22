package com.wh.base;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
	
	public static void main(String[] args) {
//		Method_01();
		ArrayList<String> al = new ArrayList<String>();
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java03");
		sop("原集合是："+al);
		ArrayList<String> newAl = method_02(al);
		sop("去重之后的集合是："+ newAl);
	}
	
	public static void sop(Object obj) {
		System.out.println(obj);
	}
	public static void Method_01() {
		Vector<Object> v = new Vector<>();
		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");
		v.add("java05");
		Enumeration<Object> en = v.elements();
		while(en.hasMoreElements()){
			sop(en.nextElement());
		}
	}
	
	public static ArrayList<String> method_02(ArrayList<String> al) {
		ArrayList<String> newAl = new ArrayList<String>();
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
			String obj = it.next();
			if(!newAl.contains(obj)){
				newAl.add(obj);
			}
		}
		return newAl;
	}
}
