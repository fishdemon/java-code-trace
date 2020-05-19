/**
 * 
 */
package priv.allen.designpattern.iterator;

import java.util.Iterator;

/**
 * @author Ma anjin 
 *
 */
public class NameContainer{
	
	/**
	 * 
	 */
	public String names[] = {"Robert" , "John" ,"Julie" , "Lora"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	
	/**
	 * @return Iterator
	 */
	public Iterator<String> getIterator() {
		return new NameIterator();
	}
	
	private class NameIterator implements Iterator<String> {
		
		int index = 0;
		
		@Override
		public boolean hasNext() {
			if (index < names.length) {
				return true;
			}
			return false;
		}

		@Override
		public String next() {
			if (hasNext()) {
				return names[index ++];
			}
			return null;
		}
		
	}

}
