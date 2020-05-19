/**
 * 
 */
package priv.allen.designpattern.chainofresponsibility;

/**
 * @author Ma anjin 
 *
 */
public class ConsoleLogger extends AbstractLogger {
	
	/**
	 * @param level 
	 * 
	 */
	public ConsoleLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Standard Console::Logger: " + message); //$NON-NLS-1$
	}

}
