/**
 * 
 */
package priv.allen.designpattern.template;

/**
 * @author Ma anjin 
 *
 */
public abstract class AbstractGame {
	
	/**
	 * 模板
	 */
	public final void play() {
		// 初始化游戏
		initial();
		// 开始游戏
		start();
		// 结束游戏
		end();
	}
	
	abstract void initial();
	abstract void start();
	abstract void end();
}
