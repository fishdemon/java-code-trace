/**
 * 
 */
package priv.allen.javathread.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * Executor框架是一个根据一组执行策略调用，调度，执行和控制的异步任务的框架。
 * Executor存在的目的是提供一种将“任务提交”与”任务如何运行”分离开来的机制。
 * Java创建一个新线程的成本是比较高的。因此在面临大量的多线程任务时，采用线程池几乎成了惯用的做法，线程池其实也是设计模式中享元模式思想的一种应用。
 * 一般线程池刚启动时会新建大量的（跟传入参数有关）空闲线程，程序将一个Runnable或者Callable对象传给线程池时，线程池会调用空闲线程执行他们的run()方法或者call()方法。
 * 执行完成后并不回收该线程，而是再次返回线程池中称谓空闲线程，等待下一次任务。
 * 
 * ctl 32位atomicInteger  高3为用来表示线程池状态，低29位表示线程池workerCount
 * 线程池5种状态：running, shutdown, stop, tidying, terminated 
 * 
 * 
 * 默认拒绝策略：AbortPolicy   抛出RejectedExecutionException
 * 一共有4种拒绝策略：
 * @author Allen 
 *
 */
public class ThreadPoolDemo {
	
	/**
	 * 创建一个固定数目的、可重用的线程池。
	 */
	@Test
	public void testFixedThreadPool() {
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-1 << 29));
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			pool.execute(() -> {
				Date now = new Date();
				System.out.println("线程" + Thread.currentThread() + "start 报时：" + now);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				now = new Date();
				System.out.println("线程" + Thread.currentThread() + "end 报时：" + now); //$NON-NLS-1$ //$NON-NLS-2$
			}); 
		}
		
		while(true) {
			
		}
	}
	
	/**
	 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
	 */
	@Test
	public void testCachedThreadPool() {
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			pool.execute(() -> {
				Date now = new Date();
				System.out.println("线程" + Thread.currentThread() + "start 报时：" + now);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				now = new Date();
				System.out.println("线程" + Thread.currentThread() + "end 报时：" + now); //$NON-NLS-1$ //$NON-NLS-2$
			}); 
		}
		
		while(true) {
			
		}
	}
	
	/**
	 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
	 */
	@Test
	public void testSingleThreadPool() {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 10; i++) {
			pool.execute(() -> {
				Date now = new Date();
				System.out.println("线程" + Thread.currentThread() + "start 报时：" + now);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				now = new Date();
				System.out.println("线程" + Thread.currentThread() + "end 报时：" + now); //$NON-NLS-1$ //$NON-NLS-2$
			}); 
		}
		
		while(true) {
			
		}
	}
	
	/**
	 * 创建一个定长线程池，支持定时及周期性任务执行。
	 */
	@Test
	public void testScheduledThreadPool() {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
//		pool.scheduleAtFixedRate(() -> {
//			System.out.println("FixedRate 每隔3秒执行一次, 从上一次执行完到下一次开始执行的间隔时间！"); //$NON-NLS-1$
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("FixedRate 执行完成了"); //$NON-NLS-1$
//		}, 2, 3, TimeUnit.SECONDS);
		
		pool.scheduleWithFixedDelay(() -> {
			System.out.println("FixedDelay 每隔3秒执行一次, 从上一次执行完到下一次开始执行的间隔时间！"); //$NON-NLS-1$
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("FixedDelay 执行完成了"); //$NON-NLS-1$
		}, 2, 3, TimeUnit.SECONDS);
			
		while(true) {
			
		}
	}
	
	/**
	 * 创建一个只有一个线程的线程池，定期或延时执行任务。
	 */
	@Test
	public void testSingleScheduledThreadPool() {
		ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
		pool.scheduleWithFixedDelay(() -> {
			System.out.println("FixedDelay 每隔3秒执行一次, 从上一次执行完到下一次开始执行的间隔时间！"); //$NON-NLS-1$
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("FixedDelay 执行完成了"); //$NON-NLS-1$
		}, 2, 3, TimeUnit.SECONDS);
			
		while(true) {
			
		}
	}
	
	/**
	 * 创建持有足够线程的线程池来支持给定的并行级别，并通过使用多个队列，减少竞争，它需要传一个并行级别的参数，如果不传，则被设定为默认的CPU数量。
	 */
	@Test
	public void testWorkStealingPool() {
		ExecutorService pool = Executors.newWorkStealingPool();
		
		for (int i = 1; i <= 10; i++) {
			final int count=i;
			pool.submit(new Runnable() {
				@Override
				public void run() {
					Date now=new Date();
					System.out.println("线程" + Thread.currentThread() + "完成任务："
							+ count+"   时间为："+	now.getSeconds());
					try {
						Thread.sleep(1000);//此任务耗时1s
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
 
			});
           
		}
		while(true){
			//主线程陷入死循环，来观察结果，否则是看不到结果的
		}
	}
}
