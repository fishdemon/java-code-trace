/**
 * 
 */
package priv.allen.designpattern.template;

/**
 * @author Ma anjin 
 *
 */
public class Cricket extends AbstractGame {

	@Override
	void initial() {
		System.out.println("Cricket Game Initialized! Start playing."); //$NON-NLS-1$
	}

	@Override
	void start() {
		System.out.println("Cricket Game Started. Enjoy the game!"); //$NON-NLS-1$
	}

	@Override
	void end() {
		 System.out.println("Cricket Game Finished!"); //$NON-NLS-1$
	}

}
