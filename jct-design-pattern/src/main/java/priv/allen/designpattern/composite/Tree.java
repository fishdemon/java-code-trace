/**
 * 
 */
package priv.allen.designpattern.composite;

/**
 * @author Allen
 *
 */
public class Tree {
	
	private TreeNode root;
	
	/**
	 * @param root
	 */
	public Tree(TreeNode root) {
		this.root = root;
	}

	/**
	 * @return the root
	 */
	public TreeNode getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode("root"); //$NON-NLS-1$
		root.setParent(null);
		TreeNode node1 = new TreeNode("child1"); //$NON-NLS-1$
		root.addChild(node1);
		TreeNode node2 = new TreeNode("child2"); //$NON-NLS-1$
		root.addChild(node2);
		Tree tree = new Tree(root);
		
		
	}
	
}
