/**
 * 
 */
package priv.allen.designpattern.strategy;

/**
 * @author Allen
 *
 */
public class StrategyPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context context = new Context(new AddStrategy());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5)); //$NON-NLS-1$

		context = new Context(new SubstractStrategy());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5)); //$NON-NLS-1$

		context = new Context(new MultiplyStrategy());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5)); //$NON-NLS-1$
	}

}
