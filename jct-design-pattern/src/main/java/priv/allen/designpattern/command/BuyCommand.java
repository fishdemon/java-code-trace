/**
 * 
 */
package priv.allen.designpattern.command;

/**
 * @author Ma anjin 
 *
 */
public class BuyCommand implements ICommand {
	
	private Receiver stock;
	
	/**
	 * @param stock
	 */
	public BuyCommand(Receiver stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.buy();
	}

}
