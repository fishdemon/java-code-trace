package com.fishdemon.algorithm.sort;

/**
 * 堆排序
 * 核心思想：
 * 堆是一种顺序存储的完全二叉树。将序列变为堆的过程就是排序的过程。
 * 
 * 方案：
 * 1. 预先初始化为大根堆
 * 2. 交换堆顶与最后一个元素，然后重新调整为大根堆
 * 3. 交换对顶与倒数第二个元素，然后重新调整为大根堆
 * 4. 重复步骤2，至只剩下一个堆顶元素
 * @author Anjin.Ma
 *
 */
public class HeapSort {
	
	/**
	 * 从小到大排序
	 * @param nums
	 */
	public static void sort(int[] nums) {
		// 预先初始化为大根堆
	    initBigHeap(nums);
	    for(int i = nums.length; i >= 1; i--) {
	      // 堆顶元素为最大值，交换到其应该在的位置
	      exchangeValue(nums, 0, i - 1);
	      // 重新调整，保证数组的前i-1个元素符合大根堆
	      adjustBigHeap(nums, 0, i - 1);
	    }
	}
	
	
	/**
	    * 将数组初始化为大根堆
	    * @param nums 待排数组
	    */
	  private static void initBigHeap(int[] nums) {
	    // 从最后一个有子节点的节点往前遍历，遍历过程中保证当前节点的左右子节点的值均不大于该节点的值
	    // 则遍历到根节点（堆顶元素）时也保证其左右子节点的值均不大于该节点的值，则初始化成功。
	    // 即从第i个元素的父节点(第i个元素的下标为i - 1,其父节点的下标为i/2 - 1)开始往前遍历：
	    for(int i = nums.length / 2 - 1;i >= 0; i--) {
	      adjustBigHeap(nums,i,nums.length);
	    }
	  }

	  /**
	    * 保证数组nums的前count个元素中，下标为parent的节点及其子孙节点符合大根堆要求
	    * @param nums 待排数组
	    * @param parentIndex 目标节点
	    * @param count 待排元素个数（nums数组的前count个元素）
	    */
	  private static void adjustBigHeap(int[] nums, int parentIndex, int count) {
	    int leftChildIndex = 2 * parentIndex + 1;
	    int rightChildIndex = 2 * parentIndex + 2;
	    while(leftChildIndex < count) {
	      int toBeComparedIndex;
	      // 如果j节点有右子节点，且右子节点比左子节点的值大，则j节点跟右子节点比较，否则跟左子节点比较
	      if (rightChildIndex < count && nums[rightChildIndex] > nums[leftChildIndex]) {
	        toBeComparedIndex = rightChildIndex;
	      } else {
	        toBeComparedIndex = leftChildIndex;
	      }
	      if (nums[toBeComparedIndex] > nums[parentIndex]) {
	        exchangeValue(nums, parentIndex, toBeComparedIndex);
	        // 交换后，然后还要保证交换后的节点也符合大根堆要求
	        adjustBigHeap(nums, toBeComparedIndex, count);
	      } else {
	        // 当父节点是最大时，停止递归
	        break;
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
