/**
 * 
 */
package priv.allen.designpattern.state;

/**
 * 
 * @author Allen
 *
 */
public class WaterDispenser {
	private static int capacity = 20;
	private static DispenserState dispenserState;

	/**
	 * @param state
	 */
	public WaterDispenser(DispenserState state) {
		dispenserState = state;
	}

	private static void setState(DispenserState state) {
		dispenserState = state;
	}

	/**
	 * @return DispenserState
	 */
	public DispenserState getState() {
		return dispenserState;
	}

	/**
	 * 
	 */
	public void press() {
		capacity--;
		if (capacity <= 0) {
			setState(new EmptyState());
		}
		dispenserState.press();
	}
}
