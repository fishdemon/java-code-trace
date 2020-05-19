/**
 * 
 */
package priv.allen.designpattern.decorator;

/**
 * @author Ma anjin 
 *
 */
public class Shoe extends Decorator {
	
	/**
	 * @param human
	 */
	public Shoe(IHuman human) {
		super(human);
	}

	@Override
	public void wear() {
		super.wear();
		System.out.print(" shoe "); //$NON-NLS-1$
	}

}
