/**
 * 
 */
package priv.allen.designpattern.decorator;

/**
 * @author Ma anjin 
 *
 */
public class Hat extends Decorator {

	/**
	 * @param human
	 */
	public Hat(IHuman human) {
		super(human);
	}

	@Override
	public void wear() {
		super.wear();
		System.out.print(" hat "); //$NON-NLS-1$
	}

}
