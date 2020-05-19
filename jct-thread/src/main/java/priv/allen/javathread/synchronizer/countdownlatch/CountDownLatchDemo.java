package priv.allen.javathread.synchronizer.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * 倒计时锁
 * 线程中调用countDownLatch.await()使进程进入阻塞状态，当达成指定次数后（通过countDownLatch.countDown()）继续执行每个线程中剩余的内容。
 * 只能同步一次
 * @author Ma anjin 
 *
 */
public class CountDownLatchDemo {
	
	/**
	 * 生产电脑，需要先将CPU, 硬盘, 主板, 外壳, 显示屏生产完成后，才能进行组装。
	 */
	@Test
	public void testCountDownLatch() {
		// 设定完成5个计数时就触发每个线程 await 后面的内容
		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(new ComputerProduct("CPU", latch)); //$NON-NLS-1$
		pool.execute(new ComputerProduct("硬盘", latch)); //$NON-NLS-1$
		pool.execute(new ComputerProduct("主板", latch)); //$NON-NLS-1$
		pool.execute(new ComputerProduct("外壳", latch)); //$NON-NLS-1$
		pool.execute(new ComputerProduct("显示屏", latch)); //$NON-NLS-1$
		
		while(true) {
			
		}
	}
	
	class ComputerProduct implements Runnable {
		
		private String name;
		private CountDownLatch latch;
		
		public ComputerProduct(String name, CountDownLatch latch) {
			super();
			this.name = name;
			this.latch = latch;
		}

		@Override
		public void run() {
			System.out.println("start to product " + name); //$NON-NLS-1$
			try {
				Thread.sleep(new Random().nextInt(20) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("complete to product " + name); //$NON-NLS-1$
			
			try {
				// 计数值减1
				latch.countDown();
				// 阻塞当前线程，直到CountDownLatch的计数值为0
				latch.await();
				System.out.println("所有都生产完毕，组装 " + name); //$NON-NLS-1$
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
