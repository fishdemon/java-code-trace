/**
 * 
 */
package priv.allen.designpattern.memento;

/**
 * @author Ma anjin 
 *
 */
public class Originator {
	
	private String name;
	private int age;
	
	/**
	 * 
	 */
	public Originator() {
		super();
	}

	/**
	 * @param name
	 * @param age
	 */
	public Originator(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	 * @return Memento
	 */
	public Memento createMemento() {
		return new Memento(name, age);
	}
	
	/**
	 * @param memento
	 */
	public void restoreMemento(Memento memento) {
		setName(memento.getName());
		setAge(memento.getAge());
	}

	@Override
	public String toString() {
		return "Originator {\"name\":\"" + name + "\", \"age\":" + age + "}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
}
