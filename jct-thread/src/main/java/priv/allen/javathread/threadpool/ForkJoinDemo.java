/**
 * 
 */
package priv.allen.javathread.threadpool;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author Ma anjin
 *
 */
public class ForkJoinDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// JAVA8新类 可以使用System.currentTimeMillis() 替代
		Instant time1 = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoin task = new ForkJoin(0L, 50000000000L);
		long sum = pool.invoke(task);
		Instant time2 = Instant.now();
		System.out.println("分割后耗费时间:" + Duration.between(time1, time2).toMillis() + "毫秒"); //$NON-NLS-1$ //$NON-NLS-2$
		sum = 0L;
		Instant time3 = Instant.now();
		for (long i = 0L; i <= 50000000000L; i++) {
			sum += i;
		}
		Instant time4 = Instant.now();
		System.out.println("未分割耗费时间:" + Duration.between(time3, time4).toMillis() + "毫秒"); //$NON-NLS-1$ //$NON-NLS-2$
		// 分割后耗费时间:8284毫秒
		// 未分割耗费时间:15552毫秒
		// 若数据较少 则分割会额外耗费时间

	}

	static class ForkJoin extends RecursiveTask<Long> {
		private static final long serialVersionUID = 7633953255462137626L;
		private static final long THURSHOLD = Math.abs(new Random().nextInt());// 临界值
		private long start;// 开始值
		private long end;// 结束值
		

		public ForkJoin(long start, long end) {
			this.start = start;
			this.end = end;
		}

		/**
		 * 结束值与开始至之差小于临界值时 程序继续把大任务划分为小任务
		 */

		@Override
		protected Long compute() {
			long temp = end - start;
			if (temp <= THURSHOLD) {
				long sum = 0L;
				for (long i = start; i <= end; i++) {
					sum += i;
				}
				return sum;
			}

			long middle = (start + end) / 2;
			// 递归调用
			ForkJoin left = new ForkJoin(start, middle);
			ForkJoin right = new ForkJoin(++middle, end);
			left.fork(); // 进行拆分 继续执行判断
			right.fork();
			return left.join() + right.join();// 合并结果集
		}

	}

}
