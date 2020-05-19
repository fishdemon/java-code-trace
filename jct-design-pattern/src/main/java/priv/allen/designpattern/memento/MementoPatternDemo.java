/**
 * 
 */
package priv.allen.designpattern.memento;


/**
 * 备忘录模式（Memento Pattern）保存一个对象的某个状态，以便在适当的时候恢复对象。备忘录模式属于行为型模式。
 * 在不破坏封装的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样可以在以后将对象恢复到原先保存的状态。
 * 
 * 优点：
 * 	 1、给用户提供了一种可以恢复状态的机制，可以使用户能够比较方便地回到某个历史的状态。 2、实现了信息的封装，使得用户不需要关心状态的保存细节。
 * 缺点：
 * 		消耗资源。如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存。
 * 场景：
 * 1、后悔药。 2、打游戏时的存档。 3、Windows 里的 ctri + z。 4、IE 中的后退。 4、数据库的事务管理。
 * @author Ma anjin 
 *
 */
public class MementoPatternDemo {
	
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
		Originator originator = new Originator("Allen", 16); //$NON-NLS-1$
		CareTaker careTaker = new CareTaker();
		careTaker.add(originator.createMemento());
		
		sleep(2000);
		
		originator.setAge(22);
		careTaker.add(originator.createMemento());
		
		sleep(3000);
		
		originator.setName("June"); //$NON-NLS-1$
		originator.setAge(29);
//		careTaker.add(originator.createMemento());
		
		System.out.println("now : " + originator.toString()); //$NON-NLS-1$
		// 可以恢复到任何一个状态，耗费内存
		originator.restoreMemento(careTaker.get(careTaker.getTimes().toArray(new String[careTaker.getTimes().size()])[0]));
		System.out.println("restore:" + originator.toString()); //$NON-NLS-1$
	}

}
