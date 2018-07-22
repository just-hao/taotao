
public class Student implements Comparable<Student>{
	

	private String name;
	
	private int age;
	
	Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public int hashCode(){
		return name.hashCode()+age*34;
	}
	
	public boolean equals(Object obj){
		if(!(obj instanceof Student)){
			throw new ClassCastException("类型不匹配");
		}
		Student s = (Student)obj;
		return this.name.equals(s.name) && this.age == s.age;
	}

	public String getName() {
		return name;
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

	@Override
	public int compareTo(Student s) {
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if(num == 0)
			return this.name.compareTo(s.name);
		return num;
	}
	
}
