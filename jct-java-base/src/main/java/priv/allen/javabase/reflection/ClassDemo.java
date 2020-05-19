package priv.allen.javabase.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

import org.junit.Test;

/**
 * 接口: type, GenericDeclaration, member, AnnotatedElement, TypeVariable
 * 抽象类： AccessibleObject, Executable
 * 
 * 
 * @author Allen
 *
 */
public class ClassDemo {
	
	@Test
	public void viewClass() throws ClassNotFoundException {
		// forName 初始化类
		Class<?> clazz = Class.forName("priv.allen.javabase.reflection.Person");
		String name = clazz.getName();
		String canonicalName = clazz.getCanonicalName();
		String typeName = clazz.getTypeName();
		
		// 用Class来判断类型
		boolean isArray = clazz.isArray();
		boolean isEnum = clazz.isEnum();
		boolean isAnnotation = clazz.isAnnotation();
		boolean isAnonymousClass = clazz.isAnonymousClass();	
		boolean isInterface = clazz.isInterface();
		boolean isLocalClass = clazz.isLocalClass();
		boolean isMemberClass = clazz.isMemberClass();
		boolean isPrimitive = clazz.isPrimitive();
		boolean isSynthetic = clazz.isSynthetic();
		boolean isInstance = clazz.isInstance(new Person());
		boolean isAssignable = clazz.isAssignableFrom(Person.class);
		
		// 实例化对象
		try {
			// 如果这个类没有默认的无参构造函数，则会报错
			Person person = (Person) clazz.newInstance();
			System.out.println(person.toString());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void viewContructor() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName("priv.allen.javabase.reflection.Person");
		// 获取类构造器
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		
		int len = constructors.length;
		for (Constructor constructor : constructors) {
			String name = constructor.getName();
			int paramLen = constructor.getParameterCount();
			Parameter[] parameters = constructor.getParameters();
			for (Parameter parameter : parameters) {
				String paramName = parameter.getName();
				Type type = parameter.getParameterizedType();
				Class<?> typeClass = parameter.getType();
				System.out.println();
			}
		}
		
		// 利用类的构造器进行实例化
		for (Constructor<?> constructor : constructors) {
			if (constructor.getParameterCount() == 0) {
				try {
					Object instance = constructor.newInstance(new Object[] {});
					System.out.println(instance.toString());
					if (instance instanceof Person) {
						Person person = (Person) instance;
						person.setName("june");
						person.setAge(20);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			} 
		}
		
		Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
		Object instance = constructor.newInstance(new Object[]{"allen", 35});
		System.out.println(instance.toString());
	}
	
	/**
	 * static final的常量，不可以通过 Field来改变值
	 * 否则会报错：java.lang.IllegalAccessException: Can not set static final java.lang.String field priv.allen.javabase.reflection.Person.SEX_MAN to java.lang.String
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@Test
	public void viewField() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		try {
			// forName 初始化类
			Class<?> clazz = Class.forName("priv.allen.javabase.reflection.Person");
			// 获取本类中声明的所有field
			Field[] fields = clazz.getDeclaredFields();
			int filedLen = fields.length;
			// 根据属性名 获取对应的field
			Field nameFiled = clazz.getDeclaredField("name");
			Field sexField = clazz.getDeclaredField("sex");
			Field sexManField = clazz.getDeclaredField("SEX_MAN");
			
			// 利用field给对象赋值,只可以给有访问权限的属性赋值; 如果没有访问权限，可以用setAccessible(true)设置允许访问
			Person person = new Person();
			// name 属性为private, 必须将Accessible设置为true
			int modifiers = sexManField.getModifiers();
			if (!(Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers))) {
				nameFiled.setAccessible(true);
				nameFiled.set(person, "alen");
				sexField.set(person, Person.SEX_MAN);
			}
			
			System.out.println(person.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void viewMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		try {
			// forName 初始化类
			Class<?> clazz = Class.forName("priv.allen.javabase.reflection.Person");
			Person person = (Person) clazz.newInstance();
			
			Method[] allMethods = clazz.getMethods();
			Method[] methods = clazz.getDeclaredMethods();
			
			Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
			setNameMethod.invoke(person, "allen");
			
			Method getNameMethod = clazz.getDeclaredMethod("getName");
			String name = getNameMethod.getName();
			Class<?> returnType = getNameMethod.getReturnType();
			
			// 反射调用实例方法
			Object result = getNameMethod.invoke(person);
			System.out.println(result.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
