package com.fishdemon.algorithm.sort;

/**
 * 冒泡排序法（简单交换） 
 * 核心思想： 
 * 从左到右比较相邻的两个元素，如果左边的元素比右边的大，交换左右元素。 这样每轮比较完，最大值总能到最右边。
 * 当所有的轮次比较完后，就是从小到大的排序
 * 
 * @author Anjin.Ma
 *
 */
public class BubbleSort {

	/**
	 * 从小到大排序
	 * 
	 * @param nums
	 */
	public static void sort(int[] nums) {
		// i 为轮次
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					exchangeValue(nums, j, j + 1);
				}
			}
		}
	}

	private static void exchangeValue(int[] nums, int index1, int index2) {
		if (index1 != index2) {
			int temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;
		}
	}

}
