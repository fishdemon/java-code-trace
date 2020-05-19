/**
 * 
 */
package priv.allen.designpattern.chainofresponsibility;

/**
 * @author Allen
 *
 */
public class FileLogger extends AbstractLogger {

	/**
	 * @param level
	 */
	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("File::Logger: " + message); //$NON-NLS-1$
	}

}
