package com.wh.base;

public class Person {
	
	private String name;
	
	private int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public int hashCode(){
		System.out.println("调用person的hashcode方法");
		return name.hashCode() + age;
	}
	
	public boolean equals(Object obj){
		if(!(obj instanceof Person))
			return false;
		Person p = (Person)obj;
		return this.name.equals(p.name) && this.age == p.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
