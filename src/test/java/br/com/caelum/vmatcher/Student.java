package br.com.caelum.vmatcher;


class Student implements PartiallyComparable{
	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean compareTo(Object[] o) {
		if(o.length==1 && name.equals(o[0])) return true;
		return false;
	}
	
	public boolean compareTo(String s) {
		return name.equals(s);
	}
}
