/**
 * 
 */
package priv.allen.javathread.synchronizer.exchanger;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * 用于数据交换
 * @author Ma anjin 
 *
 */
public class ExchangerDemo {
	
	/**
	 * 
	 */
	@Test
	public void testExchanger() {
		Exchanger<HashMap<String, User>> users = new Exchanger<>();
		ExecutorService pool = Executors.newFixedThreadPool(20);
		pool.execute(new UserAction("xiaozhang", users)); //$NON-NLS-1$
		pool.execute(new UserAction("allen", users)); //$NON-NLS-1$
		
		while(true) {
			
		}
		
	}
	
	class UserAction implements Runnable {
		private String name;
		private Exchanger<HashMap<String, User>> users;
		
		public UserAction(String name, Exchanger<HashMap<String, User>> users) {
			this.name = name;
			this.users = users;
		}

		@Override
		public void run() {
			HashMap<String, User> userMap = new HashMap<>();
			
			Random random = new Random();
			int sum = random.nextInt(5);
			for (int i = 0; i< sum; i++) {
				User user = new User("A" + i, new Random().nextInt(100), i % 2 == 1, name); //$NON-NLS-1$
				userMap.put("第" + i + "个数据", user); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
			try {
				Thread.sleep(new Random().nextInt(5) * 1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				//等待exchange是会进入阻塞状态，可以在一个线程中与另一线程多次交互，此处就不写多次了
				HashMap<String, User> getMap = users.exchange(userMap);
				Thread.sleep(new Random().nextInt(10) * 1000);
				
				getMap.forEach((x,y) -> {
					System.out.println(x + "----" + y.toString()); //$NON-NLS-1$
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	class User {
		private String name;
		private int age;
		private boolean married;
		private String created;
		
		public User(String name, int age, boolean married, String created) {
			this.name = name;
			this.age = age;
			this.married = married;
			this.created = created;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", married=" + married + ", created=" + created + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}

		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}

		/**
		 * @return the married
		 */
		public boolean isMarried() {
			return married;
		}

		/**
		 * @param married the married to set
		 */
		public void setMarried(boolean married) {
			this.married = married;
		}

		/**
		 * @return the created
		 */
		public String getCreated() {
			return created;
		}

		/**
		 * @param created the created to set
		 */
		public void setCreated(String created) {
			this.created = created;
		}
		
	}

}
