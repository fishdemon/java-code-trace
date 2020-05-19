package com.fishdemon.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author Anjin.Ma
 *
 */
public class ObjectSerializeDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		User user = new User("fish", 10);
		
		// 序列化成字节流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(user);
		oos.flush();
		oos.close();
		byte[] bytes = baos.toByteArray();
		
		FileOutputStream fos = new FileOutputStream(new File("D://object.out"));
		oos = new ObjectOutputStream(fos);
		oos.writeObject(user);
		oos.flush();
		oos.close();
		
		// 反序列化成对象
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		User userFromBytes = (User) ois.readObject();
		System.out.println(userFromBytes.toString());
	}
	
	static class User implements Serializable {
		static String type = "man";
		transient String sex = "male";
		private String name;
		private int age;
		
		public User() {
			
		}

		public User(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}
		
	}

}
