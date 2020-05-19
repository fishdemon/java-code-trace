package priv.allen.javathread.deadlock;

/**
 * dead lock demo
 * 程A获得了锁1，线程B获得了锁2，这时线程A又需要获得锁2，线程B需要获得锁1。 
 * 这种情况下就会出现死锁，因为如果没有外力破坏的话，线程A永远获得不了锁2，线程B也永远获得不了锁1，就会永远的相互等待。
 * @author Allen
 *
 */
public class SynchronizedDeadLockDemo {
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		deadLock();
	}
	
	
	private static void deadLock() {
		Thread tA = new Thread(() -> {
			synchronized(lock1) {
				try {
					System.out.println(Thread.currentThread().getName() + " has got lock1"); //$NON-NLS-1$
					Thread.sleep(500);
					System.out.println(Thread.currentThread().getName() + " already sleeped 500ms"); //$NON-NLS-1$
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + " is going to get lock2"); //$NON-NLS-1$
				synchronized (lock2) {
					System.out.println(Thread.currentThread().getName() + " has got lock2"); //$NON-NLS-1$
				}
			}
		}, "thread A"); //$NON-NLS-1$
		
		Thread tB = new Thread(() -> {
			synchronized(lock2) {
				try {
					System.out.println(Thread.currentThread().getName() + " has got lock2"); //$NON-NLS-1$
					Thread.sleep(500);
					System.out.println(Thread.currentThread().getName() + " already sleeped 500ms"); //$NON-NLS-1$
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + " is going to get lock1"); //$NON-NLS-1$
				synchronized (lock1) {
					System.out.println(Thread.currentThread().getName() + " has got lock1"); //$NON-NLS-1$
				}
			}
		}, "thread B"); //$NON-NLS-1$
		
		tA.start();
		tB.start();
	}
	
}
