/**
 * 
 */
package priv.allen.designpattern.facade;

/**
 * 启动子系统 1,2,3
 * 关闭子系统3,2,1
 * 提供外观类来实现这一功能
 * @author Ma anjin 
 *
 */
public class SubsystemFacade {
	
	private SubSystem1 subSystem1;
	private SubSystem2 subSystem2;
	private SubSystem3 subSystem3;
	
	/**
	 * 
	 */
	public SubsystemFacade() {
		this.subSystem1 = new SubSystem1();
		this.subSystem2 = new SubSystem2();
		this.subSystem3 = new SubSystem3();
	}

	/**
	 * 
	 */
	public void start() {
		subSystem1.start();
		subSystem2.start();
		subSystem3.start();
	}
	
	/**
	 * 
	 */
	public void stop() {
		subSystem3.stop();
		subSystem2.stop();
		subSystem1.stop();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 对于用户来说, 我不需要关系各个子系统具体的启动和关闭方式, 由统一的外观类来提供方法
		// 同时降低了各个子系统之间的耦合
		SubsystemFacade subsystemFacade = new SubsystemFacade();
		subsystemFacade.start();
		subsystemFacade.stop();
	}

}
