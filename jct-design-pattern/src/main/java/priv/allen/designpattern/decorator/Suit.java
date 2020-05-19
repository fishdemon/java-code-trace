/**
 * 
 */
package priv.allen.designpattern.decorator;

/**
 * @author Allen
 *
 */
public class Suit extends Decorator {

	/**
	 * @param human
	 */
	public Suit(IHuman human) {
		super(human);
	}

	@Override
	public void wear() {
		super.wear();
		System.out.print(" suit "); //$NON-NLS-1$
	}
	
}
