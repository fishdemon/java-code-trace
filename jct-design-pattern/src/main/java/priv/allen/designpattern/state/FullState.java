/**
 * 
 */
package priv.allen.designpattern.state;

/**
 * @author Ma anjin 
 *
 */
public class FullState implements DispenserState {
	
	@Override
	public void press() {
		System.out.println("Water is pouring!"); //$NON-NLS-1$
	}

}
