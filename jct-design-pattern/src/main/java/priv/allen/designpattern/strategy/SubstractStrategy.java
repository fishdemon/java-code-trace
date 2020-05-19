/**
 * 
 */
package priv.allen.designpattern.strategy;

/**
 * @author Ma anjin 
 *
 */
public class SubstractStrategy implements Strategy {

	@Override
	public int execute(int num1, int num2) {
		return num1 - num2;
	}

}
