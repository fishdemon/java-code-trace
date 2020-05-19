/**
 * 
 */
package priv.allen.designpattern.decorator;

/**
 * @author Ma anjin 
 *
 */
public class Pants extends Decorator {

	/**
	 * @param human
	 */
	public Pants(IHuman human) {
		super(human);
	}

	@Override
	public void wear() {
		super.wear();
		System.out.print(" pants "); //$NON-NLS-1$
	}

}
