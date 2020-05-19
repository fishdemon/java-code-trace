package priv.allen.javathread.thread;

//import org.junit.Test;

/**
 * join 的作用是 为了将指定的线程加入到当前线程中，直到这个线程执行完后，当前线程才会继续运行。
 * join() == join(0)  原因： join是通过 wait 实现的， 而 wait() == wait(0), wait 是 Object 的方法， wait(time) 是native方法。
 * 
 * @author Allen
 *
 */
public class ThreadJoinDemo {
	
	/**
	 * 使用join()前，必须先调用start()方法启动线程。
	 * 直到join的 t 线程执行完后，当前线程才会继续执行。
	 */
//	@Test
	public void testJoin() {
		long start = System.currentTimeMillis();
		
		try {
			Thread t = new Thread(new PrintTime(), "t"); //$NON-NLS-1$
			t.start();
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis() - start);
	}
	
	/**
	 * join(time) 方法中的时间是指最大等待时间，如果超过这个时间，即使join的 t 线程没有执行完，当前线程仍会继续执行。
	 * join() 调用的是 join(0) ,
	 * 主线程退出后，所有的子线程也会退出。
	 */
//	@Test
	public void testJoinTime() {
		long start = System.currentTimeMillis();
		
		try {
			Thread t = new Thread(new PrintTime(), "t"); //$NON-NLS-1$
			t.start();
			t.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis() - start);
	}
	
	/**
	 * join多个线程，多个线程会按顺序执行，不会同时运行。
	 * 即第2个线程会等待第1个线程执行完后才调用start()方法，第3个会等待第2个执行完。
	 * join的线程都执行完后，当前线程才继续执行。
	 */
//	@Test
	public void testMultipleJoin() {
		long start = System.currentTimeMillis();
		
		
		try {
			Thread t1 = new Thread(new PrintTime(), "t1"); //$NON-NLS-1$
			Thread t2 = new Thread(new PrintTime(), "t2"); //$NON-NLS-1$
			Thread t3 = new Thread(new PrintTime(), "t3"); //$NON-NLS-1$
			t1.start();
			t1.join();		// 直到t1运行完成，才会向下执行
			t2.start();
			t2.join();		// 直到t2运行完成，才会向下执行
			t3.start();		
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis() - start);
	}
	
	/**
	 * 
	 * 
	 */
//	@Test
	public void testMultipleJoinTime() {
		long start = System.currentTimeMillis();
		
		try {
			Thread t1 = new Thread(new PrintTime(), "t1"); //$NON-NLS-1$
			Thread t2 = new Thread(new PrintTime(), "t2"); //$NON-NLS-1$
			Thread t3 = new Thread(new PrintTime(), "t3"); //$NON-NLS-1$
			t1.start();
			t1.join(1000);		// t1执行完，或者等到1s后，执行下一行语句
			t2.start();
			t2.join(2000);		// t2执行完，或者等到2s后，执行下一行语句
			t3.start();
			t3.join(3000);		// t3执行完，或者等到3s后，执行下一行语句
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis() - start);
	}
	
	static class PrintTime implements Runnable{

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "-start"); //$NON-NLS-1$
			for (int i = 0; i<5;i++) {
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + "-sleep-" + i); //$NON-NLS-1$
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "-end"); //$NON-NLS-1$
		}
		
	}

}
