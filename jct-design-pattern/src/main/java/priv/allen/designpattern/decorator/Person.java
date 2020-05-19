/**
 * 
 */
package priv.allen.designpattern.decorator;

/**
 * @author Ma anjin 
 *
 */
public class Person implements IHuman {
	
	private String name = "Allen"; //$NON-NLS-1$

	@Override
	public void wear() {
		System.out.print(name + " is wearing "); //$NON-NLS-1$
	}

}
