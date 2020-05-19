package priv.allen.javathread.synchronizer.countdownlatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Allen
 *
 */
public class Racing {
	
	private List<String> horses = new ArrayList<>();
	private ExecutorService pool = Executors.newCachedThreadPool();
	// CountDownLatch(1) 多处await, 作为一种开关锁, 一个线程达到要求后，所有线程同时运行.
	// 实现比赛准备起跑，只要号令枪响，所有马开始跑
	private CountDownLatch start;
	// CountDownLatch(n) 一处await, 使1个线程在n个线程都完成某项操作或者达到统一目的前一直等待, 也就是说 n个线程都完成后，才继续执行await后面的方法.
	// 实现等所有马都到达终点后，宣布比赛结果
	private CountDownLatch finish;
	
	/**
	 * @param horses
	 */
	public Racing(String... horses) {
		this.horses = Arrays.asList(horses);
	}
	
	/**
	 * 
	 */
	public void run() {
		System.out.println("And the horses are stepping up to the gate..."); //$NON-NLS-1$
		start = new CountDownLatch(1);
		finish = new CountDownLatch(horses.size());
		List<String> places = Collections.synchronizedList(new ArrayList<String>()); 
		
		for (String horse : horses) {
			pool.execute(() -> {
				try {
					System.out.println(" stepping up to the gate..."); //$NON-NLS-1$
					start.await();
					
					Thread.sleep(new Random().nextInt(5) * 1000);
					
					Thread.sleep(new Random().nextInt(15) * 1000);
					
					finish.countDown();
					places.add(horse);
					System.out.println(horse + "has completed!"); //$NON-NLS-1$
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}); 
		}
		
		start.countDown();
		System.out.println("And... they're off!"); //$NON-NLS-1$
		
		try {
			finish.await();
			System.out.println("And we have our winners!"); //$NON-NLS-1$
	        System.out.println(places.get(0) + " took the gold..."); //$NON-NLS-1$
	        System.out.println(places.get(1) + " got the silver..."); //$NON-NLS-1$
	        System.out.println("and " + places.get(2) + " took home the bronze."); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Racing r = new Racing(
		            "Beverly Takes a Bath", //$NON-NLS-1$
		            "RockerHorse", //$NON-NLS-1$
		            "Phineas", //$NON-NLS-1$
		            "Ferb", //$NON-NLS-1$
		            "Tin Cup", //$NON-NLS-1$
		            "I'm Faster Than a Monkey", //$NON-NLS-1$
		            "Glue Factory Reject" //$NON-NLS-1$
		            );
		        
//		        System.out.println("It's a race of " + r.getDistance() + " lengths");
		        
//		        System.out.println("Press Enter to run the race....");
//		        System.in.read();
		        
		        r.run();
	}
	
}
