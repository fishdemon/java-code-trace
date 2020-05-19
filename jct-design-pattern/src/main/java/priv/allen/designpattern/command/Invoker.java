/**
 * 
 */
package priv.allen.designpattern.command;

/**
 * @author Allen
 *
 */
public class Invoker {

	private ICommand command;


	/**
	 * @param command
	 */
	public Invoker(ICommand command) {
		this.command = command;
	}

	/**
	 * 
	 */
	public void run() {
		command.execute();
	}
}
