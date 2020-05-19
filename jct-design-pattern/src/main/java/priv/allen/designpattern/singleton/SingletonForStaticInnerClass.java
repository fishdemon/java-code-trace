package priv.allen.designpattern.singleton;

/**
 * using static inner class for singleton
 * 这种方式利用了classloader的机制来保证初始化instance时只有一个线程, 但是在类装载的时候不一定实例化。
 * 因为SingletonHolder没有被主动使用，只有在调用getInstance时，才会装载SingletonHolder类，从而实例化instance.
 * thread-safe
 * lazy model
 * @author Anjin.Ma
 *
 */
public class SingletonForStaticInnerClass {
	
	private static class SingletonHolder {
		private static SingletonForStaticInnerClass instance = new SingletonForStaticInnerClass();
	}
	
	private SingletonForStaticInnerClass() {
		
	}
	
	public static SingletonForStaticInnerClass getInstance() {
		return SingletonHolder.instance;
	}
}
