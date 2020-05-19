package priv.allen.designpattern.state;

/**
 * 假设现在我们有一个饮水机，它有以下两个状态： 满桶，空桶。初始状态是满桶，容量是20。饮水机只有一个动作：press，每次press后都会使容量减1，一旦为0，则将状态设置为空桶，这时press没有水流出。
 * 要使用状态模式，我们必须明确两个东西：状态和每个状态下执行的动作。就像是饮水机，最基本的状态就是满桶和空桶，而这两个状态下，都可能要执行倒水这个动作，也就是press。如果饮水机的容量为0，则会进入空桶的状态。
 * 在状态模式中，因为所有的状态都要执行相应的动作，所以我们可以考虑将状态抽象出来。 
 * 状态的抽象一般有两种形式：接口和抽象类。如果所有的状态都有共同的数据域，可以使用抽象类，但如果只是单纯的执行动作，就可以使用接口。
 * 
 * 
 * @author Ma anjin 
 *
 */
public class StatePatternDemo {
	
	private static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WaterDispenser waterDispenser = new WaterDispenser(new FullState());
		
		for (int i = 0; i<100; i++) {
			waterDispenser.press();
			sleep(1000);
		}
	}

}
