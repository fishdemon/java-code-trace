package priv.allen.designpattern.singleton;

/**
 * using enum for singleton
 * 这种方式是 Effectice Java作者Josh Bloch提倡的
 * 不仅可以避免多线程同步问题，也可以防止反序列化重新创建新的对象。
 * support: jdk 1.5
 * @author Anjin.Ma
 *
 */
public enum SingletonForEnum {
	INSTANCE;
	
	public void doOperation() {
		
	}
	
	public static void main(String[] args) {
		INSTANCE.doOperation();
	}
}
