package com.fishdemon.algorithm.tree;

import java.util.ArrayDeque;

/**
 * 
 * @author Anjin.Ma
 *
 */
public class Traverse {
	
	public static void  levelTraverse(TreeNode root) {
		if (null == root) {
			return;
		}
		
		ArrayDeque<TreeNode> deque = new ArrayDeque<>();
		deque.add(root);
		
		while(!deque.isEmpty()) {
			TreeNode node = deque.remove();
			System.out.println(node.getVal() + " ");
			if (null != node.getLeft()) {
				deque.add(node.getLeft());
			}
			if (null != node.getRight()) {
				deque.add(node.getRight());
			}
		}
	}
	
	static class TreeNode {
		public Integer val;
		public TreeNode left;
		public TreeNode right;
		
		
		public TreeNode(Integer val) {
			this.val = val;
		}
		
		/**
		 * @return the val
		 */
		public Integer getVal() {
			return val;
		}
		/**
		 * @param val the val to set
		 */
		public void setVal(Integer val) {
			this.val = val;
		}
		/**
		 * @return the left
		 */
		public TreeNode getLeft() {
			return left;
		}
		/**
		 * @param left the left to set
		 */
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		/**
		 * @return the right
		 */
		public TreeNode getRight() {
			return right;
		}
		/**
		 * @param right the right to set
		 */
		public void setRight(TreeNode right) {
			this.right = right;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
		
	}

}
