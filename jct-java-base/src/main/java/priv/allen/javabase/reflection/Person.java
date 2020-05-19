package priv.allen.javabase.reflection;

import java.util.ArrayList;
import java.util.List;

public class Person {
	public final static String SEX_MAN = "man";
	
	private String name;
	private int age;
	private List<Person> sons;
	public String sex;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		sons = new ArrayList<>();
	}
	
	public Person addSon(Person son) {
		sons.add(son);
		return son;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sons
	 */
	public List<Person> getSons() {
		return sons;
	}
	/**
	 * @param sons the sons to set
	 */
	public void setSons(List<Person> sons) {
		this.sons = sons;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
