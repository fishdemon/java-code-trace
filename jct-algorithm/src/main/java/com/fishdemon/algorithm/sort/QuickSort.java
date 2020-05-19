package com.fishdemon.algorithm.sort;

/**
 * 快速排序法（冒泡排序法的进阶版） 
 * 核心思想: 
 * 首先在待排序列选择一个基准数（默认第一个元素），然后把待排序列中比这个基准数小的都放在左边，大的放右边。
 * 然后把该基准数的左右两边看成是两个待排序列重复以上操作。
 * 
 * 当n较大，则应采用时间复杂度为O(nlog2n)的排序方法：快速排序、堆排序或归并排序。
 * 快速排序：是目前基于比较的内部排序中被认为是最好的方法，当待排序的关键字是随机分布时，快速排序的平均时间最短；
 * @author Anjin.Ma
 *
 */
public class QuickSort {

	public static void sort(int[] nums) {
		quickSort(nums, 0, nums.length-1);
	}

	/**
	 * 对下标从start到end的正整数数组 int Array 进行快速排序
	 * 
	 * @param intArrays 将要排序的数组intArrays
	 * @param start     数组起始下标位置
	 * @param end       数组截止下标位置
	 */
	private static void quickSort(int[] intArrays, int start, int end) {
		if (start > end) {
			return;
		}
		// 将数组起始下标位置的元素，作为基准数
		int base = intArrays[start];
		// 将i看作从左往右搜索的哨兵，j看作从右往左搜索的哨兵
		int left = start;
		int right = end;
		while (left != right) { // 左右相遇，找到了基准数的目标位置
			// ！！！因为选取的基准数是左哨兵的起始位置，这里一定要右边的哨兵先走。
			/*
			 * 这里循环结束的条件有一个是左右哨兵相遇。 如果左哨兵先行，出现由于左哨兵找到了右哨兵（相遇）导致循环结束的情况时，
			 * 左右哨兵的当前元素是基于右哨兵上次循环结束的位置。 即此时左右哨兵相遇位置的当前元素是比基准数大的！！！将该元素与基准数交换是不对的。
			 */
			// 找到右边比基准数小的第一个元素下标（或哨兵相遇）
			while (left < right && intArrays[right] >= base) {
				right--;
			}
			// 找到左边比基准数大的第一个元素下标（或哨兵相遇）
			while (left < right && intArrays[left] <= base) {
				left++;
			}
			// 交换左边第一个大于基准数的数与右边第一个小于基准数的数
			if (left < right) {
				// 交换，保证哨兵i左边的元素都比基准数小，哨兵j右边的元素都比基准数大
				exchangeValue(intArrays, left, right);
			}
		}
		// 将基准数交换到在目标位置上
		exchangeValue(intArrays, start, right);
		// 下一次，迭代（两个子序列分别进行快速排序）
		quickSort(intArrays, start, right - 1);
		quickSort(intArrays, right + 1, end);
	}

	private static void exchangeValue(int[] nums, int index1, int index2) {
		if (index1 != index2) {
			int temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;
		}
	}

}
