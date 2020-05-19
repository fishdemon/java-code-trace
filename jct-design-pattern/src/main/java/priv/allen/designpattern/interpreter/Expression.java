/**
 * 
 */
package priv.allen.designpattern.interpreter;

/**
 * @author Ma anjin 
 *
 */
public interface Expression {
	
	/**
	 * @param data
	 * @return boolean
	 */
	boolean interpret(String data);

}
