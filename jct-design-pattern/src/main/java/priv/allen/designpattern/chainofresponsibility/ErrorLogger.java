/**
 * 
 */
package priv.allen.designpattern.chainofresponsibility;

/**
 * @author Ma anjin
 *
 */
public class ErrorLogger extends AbstractLogger {

	/**
	 * @param level
	 */
	public ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger: " + message); //$NON-NLS-1$
	}

}
