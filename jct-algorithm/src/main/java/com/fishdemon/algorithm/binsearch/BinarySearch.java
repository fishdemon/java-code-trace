package com.fishdemon.algorithm.binsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找（折半查找）
 * 前提：序列必须是有序序列
 * 原理：找到带查找序列的中间数，若查找数小于中间数，则在左边这一半进行查找；若查找数大于中间数，则在右边这一半进行查找；然后对剩余的一般继续重复上面操作，直到找出。
 * @author Ma anjin 
 *
 */
public class BinarySearch {
	
	/**
	 * source为有序序列
	 * 返回匹配的位置
	 * @param source
	 * @param dest
	 * @return Integer
	 */
	public static Integer search(int[] source, int dest) {
		int low = 0;
		int high = source.length - 1;
		
		while(low <= high && low <= source.length - 1 && high <= source.length - 1) {
			int middle = (low + high) >> 1;
			if (dest == source[middle]) {
				return middle;
			} else if (dest < source[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		
		return -1;
	}
	
	/**
	 * 递归写法
	 * @param source
	 * @param start
	 * @param end
	 * @param findVal
	 * @return int
	 */
	public static int searchByRecursive(int[] source, int start, int end, int findVal) {
		if (start > end) {
			return -1;
		}
		
		int mid = (start + end) >> 1;
		int midVal = source[mid];
		
		if (findVal < midVal) {
			return searchByRecursive(source, start, mid-1, findVal);
		} else if(findVal > midVal) {
			return searchByRecursive(source, mid+1, end, findVal);
		}else {
			return mid;
		}
	}
	
	/**
	 * 改进：若序列中有重复的数，需要都查出来
	 * @return
	 */
	public static Integer[] searchByMultiple(int[] source, int start, int end, int findVal) {
		if (start > end) {
			return new Integer[] {};
		}
		
		int mid = (start + end) >> 1;
		int midVal = source[mid];
		
		if (findVal < midVal) {
			return searchByMultiple(source, start, mid-1, findVal);
		} else if(findVal > midVal) {
			return searchByMultiple(source, mid+1, end, findVal);
		}else {
			// 查到后，不直接返回，而是向左向右分别查找
			List<Integer> indexes = new ArrayList<Integer>();
			indexes.add(mid);
			
			
			// 左边
			int index = mid - 1;
			while(true) {
				if (index < 0 || source[index] != findVal) {
					break;
				}
				indexes.add(index);
			}
			
			// 右边
			index = mid + 1;
			while(true) {
				if (index > source.length-1 || source[index] != findVal) {
					break;
				}
				indexes.add(index);
			}
			
			return indexes.toArray(new Integer[0]);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[]{1,5,7,9,21,45,66,67,89};
		System.out.println(search(data, 67));
		System.out.println(search(data, 2));
	}

}
