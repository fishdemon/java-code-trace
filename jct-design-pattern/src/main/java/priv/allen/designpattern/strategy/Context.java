/**
 * 
 */
package priv.allen.designpattern.strategy;

/**
 * @author Ma anjin 
 *
 */
public class Context {
	
	private Strategy strategy;

	/**
	 * @param strategy
	 */
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * @param num1
	 * @param num2
	 * @return int
	 */
	public int executeStrategy(int num1, int num2) {
		return strategy.execute(num1, num2);
	}

}
