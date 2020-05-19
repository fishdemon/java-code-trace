/**
 * 
 */
package priv.allen.designpattern.decorator;

/**
 * @author Ma anjin 
 *
 */
public class Shirt extends Decorator {

	/**
	 * @param human
	 */
	public Shirt(IHuman human) {
		super(human);
	}

	@Override
	public void wear() {
		super.wear();
		System.out.print(" shirt "); //$NON-NLS-1$
	}

}
