package priv.allen.javabase.annotation;

import java.lang.annotation.Annotation;

/**
 * 
 * @author Allen
 *
 */
public class IntercepterAnnotationTest1 extends IntercepterAnnotationTest {
	
	public static void main(String[] args) {
		Annotation[] annotations = IntercepterAnnotationTest1.class.getAnnotations();
		for (Annotation e:annotations) {
			System.out.println(e.annotationType().getName());
		}
		// 子类继承父类，注解一般并不会被继承过来；若注解被 @Inherited 修饰，那么被该注解修饰的类的所有子类将会自动被该注解标记
	}
}
