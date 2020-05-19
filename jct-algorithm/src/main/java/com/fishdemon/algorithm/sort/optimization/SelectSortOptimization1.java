package com.fishdemon.algorithm.sort.optimization;

/**
 * 直接选择排序的优化算法
 * 核心思想：
 * 直接选择排序是每次选取最小的数放在最左边，那么可以考虑每次选择两个数（最大值和最小值），分别放到左边和右边
 * 这样可以节省一半的时间
 * 
 * @author Anjin.Ma
 *
 */
public class SelectSortOptimization1 {
	/**
	 * 从小到大排序
	 * @param nums
	 */
	public static void sort(int[] nums) {
		if(nums.length <= 1) {
			return;
		}
		if (nums.length == 2) {
			if (nums[0] > nums[1]) {
				exchangeValue(nums, 0, 1);
			}
			return;
		}
		// l,h 为最小和最大元素所在的位置， low 和 high 为最小值
		int l, h, low, high;
		// i 为循环次数
		for (int i=0; i < (nums.length-1)/2; i++) {
			l = i;
			h = nums.length - 1 -i;
			low = nums[i];
			high = nums[i];
			// 找出当前轮次最小和最大的元素及其位置
			for (int j=i+1; j< nums.length-i; j++) {
				if (nums[j] < low) {
					low = nums[j];
					l = j;
				}
				if (nums[j] > high) {
					high = nums[j];
					h = j;
				}
			}
			// 如果最小的元素不在当前位置（循环次数）上，则将最小元素与当前位置交换
			if (i != l) {
				nums[l] = nums[i];
				nums[i] = low;
			}
			if (h != nums.length - 1 -i && h != l) {
				nums[h] = nums[nums.length - 1 -i];
				nums[nums.length - 1 -i] = high;
				
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
