package com.wh.base;

import java.util.ArrayList;
import java.util.Iterator;

public class SetDemo {
	public static void main(String[] args) {
//		ArryListDemo();
//		method_02();
//		method_03();
		method_04();
		
	}
	
	public static void ArryListDemo() {
		//创建一个集合容器，使用collection接口的子类。ArrayList
		ArrayList al = new ArrayList();
		//添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		//获取个数集合的长度
		sop("size:"+al.size());
		//打印原集合
		sop(al);
		//删除元素
//		al.remove("java02");
//		al.clear();
		sop(al.contains("java02"));
		//打印删除后的集合
		sop(al);
		
	}
	
	public static void method_04() {
		ArrayList<Object> al = new ArrayList<>();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		sop("原集合是："+ al);
		//在指定位置添加元素
		al.add(1,"java09");
		sop("添加完之后的的集合是："+al);
		//删除指定位置的元素
		al.remove(3);
		al.set(2, "java08");
		sop(al);
	}
	
	public static void method_02() {
		ArrayList<Object> al = new ArrayList<>();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		ArrayList<Object> al2 = new ArrayList<>();
		al2.add("java08");
		al2.add("java07");
		al2.add("java06");
		al2.add("java01");
//		al.retainAll(al2);
		al.removeAll(al2);
		sop(al);
		sop(al2);
	}
	
	public static void method_03() {
		ArrayList<Object> al = new ArrayList<>();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		Iterator<Object> it = al.iterator();
		while(it.hasNext()){
			sop(it.next());
		}
	}
	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
