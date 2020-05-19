/**
 * 
 */
package priv.allen.designpattern.command;

/**
 * @author Ma anjin 
 *
 */
public class SellCommand implements ICommand {
	
	private Receiver receiver;
	
	/**
	 * @param stock
	 */
	public SellCommand(Receiver stock) {
		this.receiver = stock;
	}

	@Override
	public void execute() {
		receiver.sell();
	}

}
