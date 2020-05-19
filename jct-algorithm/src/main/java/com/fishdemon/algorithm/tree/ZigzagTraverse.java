package com.fishdemon.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的锯齿形遍历
 * 
 * @author Anjin.Ma
 *
 */
public class ZigzagTraverse {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(9);
		TreeNode node9 = new TreeNode(10);
		TreeNode node10 = new TreeNode(11);
		node3.left = node7;
		node3.right = node8;
		node4.left = node9;
		node5.right = node10;
		
		List<List<Integer>> res = zigzagTraverse(root);
		res.forEach(ele -> {
			StringBuilder sb = new StringBuilder();
			ele.forEach(item -> {
				sb.append(item).append(" ");
			});
			System.out.println(sb.toString());
		});
	}
	
	public static List<List<Integer>> zigzagTraverse(TreeNode node) {
		List<List<Integer>> res = new ArrayList<>();
		if (null == node) {
			return res;
		}
		
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(node);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			if (!stack1.isEmpty()) {
				List<Integer> subRes = new ArrayList<>();
				while(!stack1.isEmpty()) {
					TreeNode nodeTemp = stack1.pop();
					subRes.add(nodeTemp.getVal());
					if (null != nodeTemp.left) {
						stack2.push(nodeTemp.getLeft());
					}
					if (null != nodeTemp.right) {
						stack2.push(nodeTemp.getRight());
					}
				}
				res.add(subRes);
			}
			
			if (!stack2.isEmpty()) {
				List<Integer> subRes = new ArrayList<>();
				while(!stack2.isEmpty()) {
					TreeNode nodeTemp = stack2.pop();
					subRes.add(nodeTemp.getVal());
					if (null != nodeTemp.right) {
						stack1.push(nodeTemp.getRight());
					}
					if (null != nodeTemp.left) {
						stack1.push(nodeTemp.getLeft());
					}
				}
				res.add(subRes);
			}
		}
		return res;
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
