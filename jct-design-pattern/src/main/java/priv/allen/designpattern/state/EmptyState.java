/**
 * 
 */
package priv.allen.designpattern.state;

/**
 * @author Ma anjin 
 *
 */
public class EmptyState implements DispenserState {

	@Override
	public void press() {
		System.out.println("There is not water poured!"); //$NON-NLS-1$
	}

}
