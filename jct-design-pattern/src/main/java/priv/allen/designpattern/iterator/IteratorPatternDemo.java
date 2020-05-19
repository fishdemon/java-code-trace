/**
 * 
 */
package priv.allen.designpattern.iterator;

import java.util.Iterator;

/**
 * @author Ma anjin 
 *
 */
public class IteratorPatternDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Iterator<String> ite = new NameContainer().getIterator();
		for (;ite.hasNext();) {
			System.out.println(ite.next());
		}
		
	}

}
