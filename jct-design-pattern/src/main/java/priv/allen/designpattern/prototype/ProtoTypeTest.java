/**
 * 
 */
package priv.allen.designpattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模式虽然是创建型的模式，但是与工程模式没有关系
 * 一个原型类，只需要实现Cloneable接口，覆写clone方法，此处clone方法可以改成任意的名称，因为Cloneable接口是个空接口，你可以任意定义实现类的方法名，如cloneA或者cloneB，因为此处的重点是super.clone()这句话，super.clone()调用的是Object的clone()方法，而在Object类中，clone()是native的，具体怎么实现，我会在另一篇文章中，关于解读Java中本地方法的调用，此处不再深究。在这儿，我将结合对象的浅复制和深复制来说一下，首先需要了解对象深、浅复制的概念：
 *
 *	浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 *
 *	深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 * @author Ma anjin 
 *
 */
public class ProtoTypeTest implements Cloneable, Serializable{
	private String name;
	private int age;
	
	/**
	 * @param name
	 */
	public ProtoTypeTest(String name) {
		super();
		this.name = name;
	}


	// 浅复制
	@Override
	public ProtoTypeTest clone() throws CloneNotSupportedException {
		ProtoTypeTest proto = (ProtoTypeTest) super.clone();
		return proto;
	}
	

	/**
	 * 深复制
	 * @return ProtoTypeTest
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ProtoTypeTest deepClone() throws IOException, ClassNotFoundException {
		/* 写入当前对象的二进制流 */  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ObjectOutputStream oos = new ObjectOutputStream(bos);  
        oos.writeObject(this);  
  
        /* 读出二进制流产生的新对象 */  
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
        ObjectInputStream ois = new ObjectInputStream(bis);  
        return (ProtoTypeTest) ois.readObject();  
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
	 * @param args
	 */
	public static void main(String[] args) {
		ProtoTypeTest test = new ProtoTypeTest("Allen"); //$NON-NLS-1$
		try {
			ProtoTypeTest test1 = test.clone();
			System.out.println(test == test1);
			// true String为引用对象，仍使用之前的对象
			System.out.println(test1.getName() == test.getName());
			
			test1 = test.deepClone();
			System.out.println(test == test1);
			// false String为引用对象，重新复制了一份
			System.out.println(test1.getName() == test.getName());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
