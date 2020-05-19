/**
 * 
 */
package priv.allen.javathread.synchronizer.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.junit.Test;

/**
 * Semaphore是信号计数量
 * 用于限制同时获取某种资源的线程数量
 * Semaphore 管理了固定数量的许可证，acquire()方法阻塞线程，直到获取并拿走一个许可证；release()方法会释放一个许可证，同时也可能会释放一个阻塞的acquire()方法。
 * 实际上，并没有许可证这个对象，Semaphore只维持了一个可获得许可证的数量。
 * @author Allen 
 *
 */
public class SemaphoreDemo {
	
	/**
	 * 一个秋千上有3个座位，那一次只能坐3个人，后面的人必须排序
	 * 
	 */
	@Test
	public void testSemaphore() {
		Swing swing = new Swing();
		Semaphore semaphore = new Semaphore(3, true);
		ExecutorService pool = Executors.newFixedThreadPool(20);
		
		pool.execute(new PlaySwing("A", semaphore, swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing("B", semaphore, swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing("C", semaphore, swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing("D", semaphore, swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing("E", semaphore, swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing("F", semaphore, swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing("G", semaphore, swing)); //$NON-NLS-1$
		
		while(true) {
			
		}
	}
	
	class PlaySwing implements Runnable {
		
		private String name;
		private Semaphore semaphore;
		private Swing swing;

		public PlaySwing(String name, Semaphore semaphore, Swing swing) {
			this.name = name;
			this.semaphore = semaphore;
			this.swing = swing;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println(swing.byPlay(name));
				Thread.sleep(new Random().nextInt(5) * 1000);
				System.out.println(swing.leave(name));
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	class Swing {

		public String byPlay(String name) {
			return name + " - is playing"; //$NON-NLS-1$
		}
		
		public String leave(String name) {
			return name + " - is leaving"; //$NON-NLS-1$
		}
		
	}
	

}
