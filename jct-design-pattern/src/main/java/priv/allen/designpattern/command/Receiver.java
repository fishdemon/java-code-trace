/**
 * 
 */
package priv.allen.designpattern.command;

/**
 * @author Ma anjin
 *
 */
public class Receiver {

	private String name = "ABC"; //$NON-NLS-1$
	private int quantity = 10;

	/**
	 * 
	 */
	public void buy() {
		System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * 
	 */
	public void sell() {
		System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

}
