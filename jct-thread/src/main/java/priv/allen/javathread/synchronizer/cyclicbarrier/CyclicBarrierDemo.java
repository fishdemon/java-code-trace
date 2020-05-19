/**
 * 
 */
package priv.allen.javathread.synchronizer.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * 循环的barrier屏障
 * 循环的等待阻塞的线程个数到达指定数量后, 使参与计数的线程继续执行并可执行特定线程（使用不同构造函数可以不设定到达后执行）, 其他线程仍处于阻塞等待再一次达成指定个数
 * 
 * CountDownLatch与CyclicBarrier区别：
 * CountDownLatch是一个或多个线程等待计数达成后继续执行，await()调用并没有参与计数。
 * CyclicBarrier则是N个线程等待彼此执行到零界点之后再继续执行，await()调用的同时参与了计数，并且CyclicBarrier支持条件达成后执行某个动作，而且这个过程是循环性的。
 * 
 * 注： 先执行特定线程，再执行参与计数的线程后面的程序。
 * 例子：不正规的长途汽车站会等待座位坐满之后才发车，到达目的地之后继续等待然后循环进行。
 * 	        每个人都是一个Thread，上车后触发cyclicBarrier.await();，当坐满时就是达到指定达成数的时候，车辆发车就是达成后统一执行的内容，发车后车上的人们就可以聊天之类的操作了【我们暂且理解为上车后人们就都不能动了O(∩_∩)O~】。
 * @author Ma anjin 
 *
 */
public class CyclicBarrierDemo {
	
	/**
	 * 公园里排队乘游艇，每当人数达到5个人时，才开放一次游艇，达不到就继续等待
	 */
	@Test
	public void testCyclicBarrier() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
			System.out.println("够5个人了，一起去happy了！"); //$NON-NLS-1$
		});
		ExecutorService pool = Executors.newFixedThreadPool(20);
		
		for (int i = 0; i < 25; i++) {
			pool.execute(new TakeShip("A" + i, cyclicBarrier)); //$NON-NLS-1$
		}
		
		
		
		while(true) {
			
		}
	}
	
	class TakeShip implements Runnable {
		private String name;
		private CyclicBarrier cyclicBarrier;

		public TakeShip(String name, CyclicBarrier cyclicBarrier) {
			super();
			this.name = name;
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(new Random().nextInt(50) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " 来排队了"); //$NON-NLS-1$
			int num = cyclicBarrier.getNumberWaiting() + 1;
			System.out.println("有" + num + "个人正在排队"); //$NON-NLS-1$ //$NON-NLS-2$
			
			try {
				cyclicBarrier.await();
				System.out.println("大家一起划船，奔向远方, 哈哈"); //$NON-NLS-1$
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
	}

}
