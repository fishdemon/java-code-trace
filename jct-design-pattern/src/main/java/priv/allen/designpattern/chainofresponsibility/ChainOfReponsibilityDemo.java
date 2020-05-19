/**
 * 
 */
package priv.allen.designpattern.chainofresponsibility;

/**
 * @author Ma anjin 
 *
 */
public class ChainOfReponsibilityDemo {
	
	private static AbstractLogger getLogger() {
		// 创建接收链
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		
		return errorLogger;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractLogger log = getLogger();
		
		log.logMessage(AbstractLogger.INFO, "This is a info"); //$NON-NLS-1$
		
		log.logMessage(AbstractLogger.DEBUG, "This is a debug"); //$NON-NLS-1$
		
		log.logMessage(AbstractLogger.ERROR, "This is a error"); //$NON-NLS-1$
	}

}
