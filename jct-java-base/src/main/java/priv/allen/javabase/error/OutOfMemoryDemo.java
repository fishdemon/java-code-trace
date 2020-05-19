/**
 * 
 */
package priv.allen.javabase.error;

import java.util.ArrayList;
import java.util.List;

/**
 * OOM 一般是申請了打的內存，而沒有釋放
 * @author Ma anjin 
 *
 */
public class OutOfMemoryDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		for (;;) {
			int[] ints = new int[100000];
			list.add(ints);
		}
		
	}

}
