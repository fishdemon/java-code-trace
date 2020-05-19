/**
 * 
 */
package priv.allen.designpattern.strategy;

/**
 * @author Allen 
 *
 */
public class MultiplyStrategy implements Strategy {

	@Override
	public int execute(int num1, int num2) {
		return num1 * num2;
	}

}
