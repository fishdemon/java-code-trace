/**
 * 
 */
package priv.allen.designpattern.decorator;

/**
 * 
 * 
 * @author Ma anjin 
 *
 */
public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person allen = new Person();
		new Hat(new Shoe(new Shirt(new Pants(allen)))).wear();
	}

}
