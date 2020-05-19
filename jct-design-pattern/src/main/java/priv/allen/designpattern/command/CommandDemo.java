/**
 * 
 */
package priv.allen.designpattern.command;

/**
 * 适用场景：
	1. 命令的发送者和命令执行者有不同的生命周期。命令发送了并不是立即执行。
	2. 命令需要进行各种管理逻辑。
	3. 需要支持撤消\重做操作（这种状况的代码大家可以上网搜索下，有很多，这里不进行详细解读）。
	结论：
	 通过对上面的分析我们可以知道如下几点：
	1. 命令模式是通过命令发送者和命令执行者的解耦来完成对命令的具体控制的。
	2. 命令模式是对功能方法的抽象，并不是对对象的抽象。
	3. 命令模式是将功能提升到对象来操作，以便对多个功能进行一系列的处理以及封装。
 * @author Ma anjin 
 *
 */
public class CommandDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Receiver stock = new Receiver();
		
		BuyCommand buyStock = new BuyCommand(stock);
		SellCommand sellStock = new SellCommand(stock);
		
		Invoker invoker1 = new Invoker(buyStock);
		invoker1.run();
		
		Invoker invoker2 = new Invoker(sellStock);
		invoker2.run();
	}

}
