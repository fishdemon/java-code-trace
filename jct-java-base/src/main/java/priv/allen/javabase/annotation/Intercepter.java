package priv.allen.javabase.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.annotation.Resource;

/**
 * (1)当注解存在数组属性时，使用{}来赋值，各个元素使用逗号分隔。
 * (2)注解的属性可以是另外一个注解。
 * (3)注解的属性可以是另外一个注解的数组。
 * (4)注解的默认属性名称为value，只有一个value属性时可以不写value=xxxx，直接写值即可。
 * (5)注解的属性的默认值使用default来定义。
 * (6)被@Inherited修饰的注解 ，修饰类后，这个类的所有子类将会被自动标记这个注解
 * @author Allen
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Resource
@Inherited
public @interface Intercepter {
	
	String value() default "";
	
	Resource name() default @Resource;
	
	Resource[] names() default {@Resource, @Resource};
	
}
