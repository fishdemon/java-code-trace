package priv.allen.designpattern.singleton;

/**
 * 双重校验锁, 静态变量的升级版
 * thread-safe
 * lazy model
 * @author Anjin.Ma
 *
 */
public class SingletonForDoubleCheck {
	
	private volatile static SingletonForDoubleCheck instance;
	
	private SingletonForDoubleCheck() {
		
	}
	
	public static SingletonForDoubleCheck getInstance() {
		if (null == instance) {
			synchronized (SingletonForDoubleCheck.class) {
				if (null == instance) {
					instance = new SingletonForDoubleCheck();
				}
			}
		}
		
		return instance;
	}

}
