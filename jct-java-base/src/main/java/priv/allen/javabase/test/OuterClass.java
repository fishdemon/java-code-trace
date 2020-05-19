/**
 * 
 */
package priv.allen.javabase.test;

/**
 * @author Ma anjin 
 *
 */
public class OuterClass {
	
	private StaticInnerClass inner = new StaticInnerClass();
	
	public static String staticPulic = "staticPulic";
	static String  staticDefault = "staticDefault";
	protected static String staticProtected = "staticProtected";
	private static String staticPrivate = "staticPrivate";
	
	public String nonStaticPulic = "nonStaticPulic";
	String nonStaticDefault = "nonStaticDefault";
	protected String nonStaticProtected = "nonStaticProtected";
	private String nonStaticPrivate = "nonStaticPrivate";
	
	public static void staticPulicMethod() {
		System.out.println("staticPulicMethod");
	}
	
	public void innerClass() {
		
	}
	
	/**
	 * 静态内部类可以是 public, default, protected, private
	 * 可以访问外部类中所有访问权限的静态成员（成员包括变量和方法）
	 * 也可以访问外部类实例中所有访问权限的费静态成员
	 * 
	 * 实例创建：
	 * 1. 在外部类中创建 new StaticInnerClass()
	 * 2. 在其他类中创建 new OuterClass.StaticInnerClass()
	 * 创建实例不依赖外部类的实例
	 * 
	 * 外部类也可以访问内部类中的一切成员
	 * @author Allen
	 *
	 */
	static class StaticInnerClass {
		
		public static String staticPulic = "staticPulic";
		static String  staticDefault = "staticDefault";
		protected static String staticProtected = "staticProtected";
		private static String staticPrivate = "staticPrivate";
		
		public String nonStaticPulic = "nonStaticPulic";
		String nonStaticDefault = "nonStaticDefault";
		protected String nonStaticProtected = "nonStaticProtected";
		private String nonStaticPrivate = "nonStaticPrivate";
		
		private OuterClass outerClass = new OuterClass();
		
		public void test() {
			System.out.println(OuterClass.staticPulic);
			System.out.println(OuterClass.staticDefault);
			System.out.println(OuterClass.staticProtected);
			System.out.println(OuterClass.staticPrivate);
			System.out.println(outerClass.nonStaticPulic);
			System.out.println(outerClass.nonStaticDefault);
			System.out.println(outerClass.nonStaticProtected);
			System.out.println(outerClass.nonStaticPrivate);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StaticInnerClass a = new StaticInnerClass();
		a.test();
	}
}
