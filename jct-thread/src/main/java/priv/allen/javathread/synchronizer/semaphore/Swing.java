package priv.allen.javathread.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 将同步器 semaphore 包装到业务类中
 * @author Allen 
 *
 */
public class Swing {
	
	private Seat[] seats = new Seat[]{new Seat(1), new Seat(2), new Seat(3)};
	private Semaphore semaphore = new Semaphore(3, true);
	
	/**
	 * 获取秋千上一个可用的seat
	 * @return Seat
	 * @throws InterruptedException
	 */
	public Seat getSeat() throws InterruptedException {
		semaphore.acquire();
		return getAvailableSeat();
	}
	
	/**
	 * 返回一个seat,供下一个人使用
	 * @param seat
	 */
	public void releaseSeat(Seat seat) {
		completedUsing(seat);
		semaphore.release();
	}
	
	/**
	 * 获取可用的seat
	 * @return Seat
	 */
	private Seat getAvailableSeat() {
		for (Seat seat : seats) {
			if (!seat.isUsed()) {
				seat.setUsed(true);
				return seat;
			}
		}
		return null;
	}
	
	/**
	 * 使用完一个seat
	 * @param seat
	 * @return boolean
	 */
	private boolean completedUsing(Seat seat) {
		for (Seat e : seats) {
			if (e == seat) {
				if (e.isUsed()) {
					e.setUsed(false);
					return true;
				}
				return false;
			}
		}
		
		return false;
	}
	
	static class Seat {
		private int id;
		private volatile boolean used;

		public Seat(int id) {
			super();
			this.id = id;
		}
		
		/**
		 * @return the used
		 */
		public boolean isUsed() {
			return used;
		}

		/**
		 * @param used the used to set
		 */
		public void setUsed(boolean used) {
			this.used = used;
		}
		
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "Seat {id=" + id + "}"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	
	

}
