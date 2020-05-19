package priv.allen.javabase.reflection;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * type 分为 ： raw types, parameterized types, array types, type variables,
 * primitive types
 * 
 * @author Allen
 *
 */
public class TypeDemo {

	private static Class getClass(Type type, int i) {
		if (type instanceof ParameterizedType) { // 处理泛型类型
			return getGenericClass((ParameterizedType) type, i);
		} else if (type instanceof TypeVariable) {
			return (Class) getClass(((TypeVariable) type).getBounds()[0], 0); // 处理泛型擦拭对象
		} else {// class本身也是type，强制转型
			return (Class) type;
		}
	}

	private static Class getGenericClass(ParameterizedType parameterizedType, int i) {
		Object genericClass = parameterizedType.getActualTypeArguments()[i];
		if (genericClass instanceof ParameterizedType) { // 处理多级泛型
			return (Class) ((ParameterizedType) genericClass).getRawType();
		} else if (genericClass instanceof GenericArrayType) { // 处理数组泛型
			return (Class) ((GenericArrayType) genericClass).getGenericComponentType();
		} else if (genericClass instanceof TypeVariable) { // 处理泛型擦拭对象
			return (Class) getClass(((TypeVariable) genericClass).getBounds()[0], 0);
		} else {
			return (Class) genericClass;
		}
	}
	
	
	
	
	interface GeneircInteface<T> {     
	    
	    T method1(T obj);

	}     
	    
	interface CommonInteface {     
	    
	    Integer method2(Integer obj);     
	}     

}
