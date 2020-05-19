/**
 * 
 */
package priv.allen.designpattern.decorator;

/**
 * @author Ma anjin 
 *
 */
public abstract class Decorator implements IHuman {
	
	private IHuman human;
	
	/**
	 * @param human
	 */
	public Decorator(IHuman human) {
		super();
		this.human = human;
	}

	@Override
	public void wear() {
		human.wear();
	}

}
