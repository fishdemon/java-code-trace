package com.fishdemon.algorithm.sort;

/**
 * Shell 排序（插入排序的进阶版）
 * 核心思想：
 * 先将整个待排序列（按相隔某个“增量”的下标）分割成若干个子序列，并对这些子序列进行直接插入排序。
 * 然后依次缩减这个“增量”，分割成子序列并再次进行直接插入排序。重复上述过程到“增量”为1，即对整个待排序列进行了一次直接插入排序。
 * 
 * 方案：
 * 1. 初始增量 increment 设置为 length/2, 以 increment/2 的速率递减 
 * 2. 直到 increment = 1 并再次执行 插入排序法，即完成排序
 * 
 * @author Anjin.Ma
 *
 */
public class ShellSort {
	
	public static void sort(int[] nums) {
		for (int increment = nums.length/2; increment >=1 ; increment /= 2) {
			// i 为无序表的下标，temp为待插入元素 nums[i]
			for (int i = increment; i < nums.length; i++) {
				int temp = nums[i];
				// j 为待插入的位置下标
				int j = i;
				for (; j > increment-1 && temp < nums[j-increment]; j-=increment) {
					// nums[j-increment]  为有序表中的元素
					// 若待插入元素 < 有序表中的元素，则将有序表中的元素后移一位
					nums[j] = nums[j-increment];
				}
				// 插入到正确的位置
				nums[j] = temp;
			}
		}
	}

}
