package com.fishdemon.algorithm.sort;

/**
 * 基数排序法 （桶排序）
 * 核心思想：
 * 将待排序列进行基数分解（比如数字的十位，个位。。。比如26个字母），依次从低位到高位对序列进行排序。
 * 
 * 
 * @author Anjin.Ma
 *
 */
public class RadixSort {

	/**
	 * 提供给开发人员使用的基数排序
	 * 
	 * @param nums 待排序列
	 */
	public static void sort(int[] nums) {
		int maxBit = getMaxBit(nums);
		// temp临时二维数组，列是余数（0-9），行是0或者待排序列中元素的值
		int[][] temp = new int[10][nums.length];
		// order对应下标，即待排序列元素对应余数的个数
		int[] order = new int[10];
		int n = 1;
		int m = 1;
		int k = 0;
		while (m <= maxBit) {
			for (int num : nums) {
				int reminder = (num / n) % 10;
				// 将余数为reminder的元素归到二维数组temp的第reminder列，并记录此时第reminder列元素的个数order[reminder]
				temp[reminder][order[reminder]] = num;
				order[reminder]++;
			}
			// 重排待排序列
			for (int i = 0; i < order.length; i++) {
				if (order[i] != 0) {
					for (int j = 0; j < order[i]; j++) {
						nums[k] = temp[i][j];
						k++;
					}
				}
				order[i] = 0;
			}
			// 重置相关变量
			n *= 10;
			k = 0;
			m++;
		}
	}

	/**
	 * 找到数组中最大值的位数（如：{32,43,101,2}的最大值是101，位数是3）
	 * 
	 * @param nums 给定数组
	 * @return 数组中最大值位数
	 */
	private static int getMaxBit(int[] nums) {
		// 获取最大的数
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		// 获取最大数的位数
		int maxBit;
		for (maxBit = 1; max >= 10; maxBit++) {
			max = max / 10;
		}
		return maxBit;
	}

}
