package priv.allen.designpattern.singleton;

/**
 * static instance using synchronized
 * thread-safe
 * lazy model
 * 效率太低，因为在大部分情况下是不需要同步的
 * @author Allen
 *
 */
public class SingletonForStatic {
	
	private static SingletonForStatic instance;
	
	private SingletonForStatic() {
		
	}
	
	public static synchronized SingletonForStatic getInstance() {
		if (null == instance) {
			instance = new SingletonForStatic();
		}
		return instance;
	}
}

/**
 * if remove synchronized, this singleton can't be safe in multiple threads.
 * Don't use this way for singleton generally.
 * lazy mode
 * @author Anjin.Ma
 *
 */
class SingletonForStaticWithoutThreadSafe {
	
	private static SingletonForStaticWithoutThreadSafe instance;
	
	private SingletonForStaticWithoutThreadSafe() {
		
	}
	
	public static SingletonForStaticWithoutThreadSafe getInstance() {
		if (null == instance) {
			instance = new SingletonForStaticWithoutThreadSafe();
		}
		return instance;
	}
}

