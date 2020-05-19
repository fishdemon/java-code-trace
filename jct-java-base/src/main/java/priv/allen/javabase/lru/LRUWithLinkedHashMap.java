/**
 * 
 */
package priv.allen.javabase.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用   least recently used
 * @author Allen
 * @param <K>
 * @param <V>
 *
 */
public class LRUWithLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

	private int MAX_CACHE_SIZE = 0;

	/**
	 * @param cacheSize
	 * accessOrder   false 基于插入顺序  true  基于访问顺序（get一个元素后，这个元素被加到最后，使用了LRU  最近最少被使用的调度算法）
	 */
	public LRUWithLinkedHashMap(int cacheSize) {
	        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
	        MAX_CACHE_SIZE = cacheSize;
	    }

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > MAX_CACHE_SIZE;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<K, V> entry : entrySet()) {
			sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue())); //$NON-NLS-1$
		}
		return sb.toString();
	}
	
	/**
	 * 最近最少使用
	 * @param args
	 */
	public static void main(String[] args) {
		//指定缓存最大容量为4
		Map<Integer,Integer> map=new LRUWithLinkedHashMap<>(4);
		map.put(9,3);
		map.put(7,4);
		map.put(5,9);
		map.put(3,4);
		
		map.get(9);
		
		map.put(6,6);
		//总共put了5个元素，超过了指定的缓存最大容量
		//遍历结果
		for(Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();it.hasNext();){
				System.out.println(it.next().getKey());
		}
		

	}

}
