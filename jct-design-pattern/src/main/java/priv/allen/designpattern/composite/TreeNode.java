package priv.allen.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式，部分-整体模式
 * 
 * @author Allen
 *
 */
public class TreeNode {
	private String name;
	private TreeNode parent;
	private List<TreeNode> children = new ArrayList<>();
	
	/**
	 * @param name
	 */
	public TreeNode(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the parent
	 */
	public TreeNode getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public List<TreeNode> getChildren() {
		return children;
	}

	/**
	 * @param child the children to set
	 */
	public void addChild(TreeNode child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	/**
	 * @param child the children to set
	 */
	public void removeChild(TreeNode child) {
		child.setParent(null);
		this.children.remove(child);
	}

}
