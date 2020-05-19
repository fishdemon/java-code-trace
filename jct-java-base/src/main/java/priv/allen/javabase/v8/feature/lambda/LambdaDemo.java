package priv.allen.javabase.v8.feature.lambda;

import org.junit.Test;

/**
 * @author Allen
 *
 */
public class LambdaDemo {
	
	final static String HELLO = "Hello"; //$NON-NLS-1$
	
	/**
	 * 类型声明，只能声明仅含有一个方法的接口(函数式接口)
	 * 1.Lambda 表达式主要用来定义行内执行的方法类型接口
	 * 2.Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力
	 */
	@Test
	public void testLambda() {
		/**
		 * 类型声明，显示声明参数类型
		 */
		CalculateOperation addOpetation = (int a, int b) -> a + b;
		
		/**
		 * 类型声明，不声明类型参数
		 */
		CalculateOperation substractOpetation = (a , b) -> a - b;
		
		/**
		 * 类型声明，带大括号的，有返回结果
		 */
		CalculateOperation multiplyOpetation = (a , b) -> {return a * b;};
		
		/**
		 * 没有大括号和返回语句
		 */
		CalculateOperation divideOperation = (int a , int b) -> a / b;
		
		System.out.println(addOpetation.exe(2, 3));
		System.out.println(substractOpetation.exe(2, 3));
		System.out.println(multiplyOpetation.exe(2, 3));
		System.out.println(divideOperation.exe(2, 3));
		
		/**
		 * 一个参数可以不用加小括号，加上也不错
		 */
		SayHello sayHello = msg -> System.out.println(msg);
		sayHello.hello("Hello,Allen!"); //$NON-NLS-1$
	}
	
	/**
	 * lambda表示式只能引用标记了final的外层局部变量（也就是说在lambda内部不可以修改域外的局部变量）
	 * 当然也可以不用声明final，但是必须不被后面的代码修改（隐形的fianl语义）
	 * 在lambda表达式中，不允许声明一个与局部变量同名的参数或局部变量。
	 */
	@Test
	public void testLambda1() {
		SayHello sayHello = msg -> System.out.println(HELLO + msg);
		sayHello.hello(", Allen!"); //$NON-NLS-1$
		
		// 也可以不用final
		String hi = "Hi"; //$NON-NLS-1$
		sayHello = msg -> System.out.println(hi + msg);
		sayHello.hello(", Allen!"); //$NON-NLS-1$
		
		// 下面是错误的，lambda表达式中不允许声明与局部变量同名的参数
		//sayHello = hi -> System.out.println(hi);
	}
	
	interface CalculateOperation {
		int exe(int a, int b);
	}
	
	interface SayHello {
		void hello(String msg);
	}

}
