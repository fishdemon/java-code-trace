package priv.allen.javabase.annotation;

import java.lang.annotation.Annotation;

@Intercepter(value = "IntercepterAnnotationTest")
public class IntercepterAnnotationTest {
	
	public static void main(String[] args) {
		Annotation[] annotations = IntercepterAnnotationTest.class.getAnnotations();
		for (Annotation e:annotations) {
			System.out.println(e.annotationType().getName());
		}
		// priv.allen.javabase.annotation.Intercepter
	}

}
