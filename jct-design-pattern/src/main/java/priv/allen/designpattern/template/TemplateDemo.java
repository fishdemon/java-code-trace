/**
 * 
 */
package priv.allen.designpattern.template;

/**
 * @author Ma anjin 
 *
 */
public class TemplateDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractGame game = new Cricket();
		game.play();
		
		game = new FootBall();
		game.play();
	}

}
