/**
 * 
 */
package priv.allen.javathread.synchronizer.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * @author Allen 
 *
 */
public class SemaphoreDemoForSwing {
	
	/**
	 * 
	 */
	@Test
	public void testSwing() {
		Swing swing  = new Swing();
		ExecutorService pool = Executors.newFixedThreadPool(20);
		
		pool.execute(new PlaySwing(new Child("A"), swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing(new Child("B"), swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing(new Child("C"), swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing(new Child("D"), swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing(new Child("E"), swing)); //$NON-NLS-1$
		pool.execute(new PlaySwing(new Child("F"), swing)); //$NON-NLS-1$
		
		while(true) {
			
		}
	}
	
	class PlaySwing implements Runnable {
		
		private Child child;
		private Swing swing;
		
		public PlaySwing(Child child, Swing swing) {
			super();
			this.child = child;
			this.swing = swing;
		}

		@Override
		public void run() {
			try {
				// 获取座位
				Swing.Seat seat = swing.getSeat();
				if (null != seat) {
					System.out.println("child " + child.getName() + " is playing in seat " + seat.getId()); //$NON-NLS-1$ //$NON-NLS-2$
					Thread.sleep(new Random().nextInt(10) * 1000);
					System.out.println("child " + child.getName() + " is leaving from seat " + seat.getId());  //$NON-NLS-1$//$NON-NLS-2$
					// 释放座位
					swing.releaseSeat(seat);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
