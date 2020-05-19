/**
 * 
 */
package priv.allen.designpattern.memento;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Ma anjin 
 *
 */
public class CareTaker {
	
	Map<String, Memento> mementos = new HashMap<>();
	
	/**
	 * @param memento
	 */
	public void add(Memento memento) {
		mementos.put(String.valueOf(System.currentTimeMillis()), memento);
	}
	
	
	/**
	 * @param time
	 * @return Memento
	 */
	public Memento get(String time) {
		return mementos.get(time);
	}
	
	/**
	 * @return Set<String>
	 */
	public Set<String> getTimes() {
		return mementos.keySet();
	}
}
