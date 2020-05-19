package priv.allen.javabase.collection;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Allen 
 *
 */
public class CopyOnWriteArrayListDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> data = Arrays.asList("str1", "str2", "str3", "str4"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(data);
		
		
	}

}
