package priv.allen.javathread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.unlock()；释放锁使用地方不规范，导致死锁不能正常释放！
 * lock.unlock() 建议在 finally 中释放
 * @author Allen
 *
 */
public class LockDeadLockDemo {
	
	public static void main(String[] args) {
		final  DeadLockBean deadLockBean  = new DeadLockBean();
		
		Thread a = new Thread(() -> {
			try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                deadLockBean.productDeadLock();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
		}, "thread A");
		
		Thread b = new Thread(() -> {
			try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                deadLockBean.productDeadLock();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
		}, "thread B");
		
		a.start();
		b.start();
	}
	
	public static class DeadLockBean{
		
        private Lock lock = new ReentrantLock();
        
        public void productDeadLock() throws Throwable {
            System.out.println(Thread.currentThread().getName() + "   进入了方法！");
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "   已经执行了！");
                throw new Throwable("人为抛出异常Throwable"); //关键代码行1，
                //throw new Exception("人为抛出异常Exception");//关键代码行2，不会死锁，会在catch(Exception e中被捕获)，嵌套lock.unlock()并释放
            }catch(Exception e){
            	// 这里只能catch 到 exception, catch不到throwable
                System.out.println(Thread.currentThread().getName()+"   发生异常catch！");
                //lock.unlock();//关键代码行3，不建议在这里释放，假如发生【关键代码行1】会产生死锁
            }finally{
                System.out.println(Thread.currentThread().getName()+"   发生异常finally！");
                lock.unlock();//关键代码行4，无论发生何种异常，均会释放锁。
            }
            
            //lock.unlock();//关键代码行5，假如发生不能捕获异常，将跳出方法体，不执行此处
            System.out.println(Thread.currentThread().getName() + "   tryCatch外释放锁！");
        }
    }

}
