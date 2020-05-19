package com.fishdemon.algorithm.sort;

/**
 *  直接插入排序法
 *  核心思想：
 *  将序列分为[有序表，无序表]，每次从无序表中取第一个元素插入到有序表中的合适位置，直到无序表中的所有元素都插完。
 *  如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。
 *  
 *  方案：
 *  1. 第一次将 第一个元素 作为有序表，其他 n-1 个元素为无序表
 *  2. 
 * @author Anjin.Ma
 *
 */
public class InsertSort {
	
	/**
	 * 从小到大排序
	 * @param nums
	 */
	public static void sort(int[] nums) {
		// i 为无序表的下标，temp为待插入元素nums[i]
		for (int i = 1; i < nums.length; i++) {
			int temp = nums[i];
			// j 为待插入的位置下标
			int j = i;
			for (; j > 0 && temp < nums[j-1]; j--) {
				// nums[j-1]  为有序表中的元素
				// 若待插入元素 < 有序表中的元素，则将有序表中的元素后移一位
				nums[j] = nums[j-1];
			}
			// 插入到正确的位置
			nums[j] = temp;
		}
	}

}
