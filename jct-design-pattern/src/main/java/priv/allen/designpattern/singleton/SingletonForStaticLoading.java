package priv.allen.designpattern.singleton;

/**
 * using static loading for singleton
 * thread-safe
 * non-lazy mode
 * 基于classloader机制来避免多线程的同步问题，但是在类装载时就进行实例化
 * @author Anjin.Ma
 *
 */
public class SingletonForStaticLoading {
	
	private static SingletonForStaticLoading instance = new SingletonForStaticLoading();
	
	private SingletonForStaticLoading() {
		
	}
	
	public SingletonForStaticLoading getInstance() {
		return instance;
	}

}

/**
 * 与上面的实现方式是一样的，只是利用了静态语句块
 * @author Anjin.Ma
 *
 */
class SingletonForStaticLoading1 {
	
	private static SingletonForStaticLoading1 instance;
	
	static {
		instance = new SingletonForStaticLoading1();
	}
	
	private SingletonForStaticLoading1() {
		
	}
	
	public SingletonForStaticLoading1 getInstance() {
		return instance;
	}

}
