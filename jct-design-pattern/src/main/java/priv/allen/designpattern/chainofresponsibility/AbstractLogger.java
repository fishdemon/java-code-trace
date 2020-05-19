/**
 * 
 */
package priv.allen.designpattern.chainofresponsibility;

/**
 * 责任链模式
 * 为请求创建了一个接受对象的链，解耦请求者与接受者。
 * 通常每个接收者都包含对下一个接受者的引用。如果一个对象不能处理该请求，那么会把请求传递给下一个接受者。
 * 当然可以设置成只要有一个接收者处理消息即返回，也可以设置成所有可以处理的接受者都处理。
 * @author Ma anjin
 *
 */
public abstract class AbstractLogger {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;

	protected int level;

	// 责任链中的下一个元素
	protected AbstractLogger nextLogger;

	/**
	 * @param level
	 * @param message
	 */
	public void logMessage(int level, String message) {
		if (this.level <= level) {
			write(message);
		}

		if (nextLogger != null) {
			nextLogger.logMessage(level, message);
		}
	}

	abstract protected void write(String message);

	/**
	 * @param nextLogger the nextLogger to set
	 */
	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

}
