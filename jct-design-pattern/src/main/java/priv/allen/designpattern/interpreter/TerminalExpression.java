/**
 * 
 */
package priv.allen.designpattern.interpreter;

/**
 * @author Ma anjin 
 *
 */
public class TerminalExpression implements Expression {
	
	private String data;
	
	/**
	 * @param data
	 */
	public TerminalExpression(String data) {
		super();
		this.data = data;
	}

	@Override
	public boolean interpret(String context) {
		if(context.contains(data)){
	         return true;
	      }
	      return false;
	}

}
