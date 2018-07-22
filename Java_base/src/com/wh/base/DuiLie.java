package com.wh.base;

import java.util.LinkedList;

public class DuiLie {
	
	private LinkedList<String> ld;
	
	public DuiLie(){
		ld = new LinkedList<>();
	}
	
	public void myAdd(String xiaoXi){
		ld.addFirst(xiaoXi);
	}
	
	public Object myGet(){
		return ld.removeLast();
	}
	
	public boolean isNull(){
		return ld.isEmpty();
	}
}
