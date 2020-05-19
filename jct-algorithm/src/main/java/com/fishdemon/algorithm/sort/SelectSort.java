package com.fishdemon.algorithm.sort;

/**
 * 简单选择排序
 * 核心思想：
 * 第x次从未排序的序列中选择一个最小（最大）的元素放在第x个位置，直至最后一个元素
 * 
 * @author Ma anjin 
 *
 */
public class SelectSort {
	
	/**
	 * 从小到大排序
	 * @param nums
	 */
	public static void sort(int[] nums) {
		// k 为最小元素所在的位置， temp 为最小值
		int k, temp;
		// i 为循环次数
		for (int i=0; i < nums.length-1; i++) {
			k = i;
			temp = nums[i];
			// 找出当前轮次最小的元素及其位置
			for (int j=i+1; j< nums.length; j++) {
				if (nums[j] < temp) {
					temp = nums[j];
					k = j;
				}
			}
			// 如果最小的元素不在当前位置（循环次数）上，则将最小元素与当前位置交换
			if (i != k) {
				nums[k] = nums[i];
				nums[i] = temp;
			}
		}
	}
	
}
