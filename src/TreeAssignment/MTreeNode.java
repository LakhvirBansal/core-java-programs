package TreeAssignment;

import java.util.ArrayList;

public class MTreeNode {

	MTreeNode root = null;
	MTreeNode parent = null;
	String element;
	int m;
	ArrayList<MTreeNode> children;

	public MTreeNode(String element, int m, ArrayList<MTreeNode> children) {
		this.element = element;
		this.m = m;
		this.children = children;
	}

	public MTreeNode(String el, int m) {
		this.element = el;
		this.m = m;
		this.children = new ArrayList<MTreeNode>(m);
	}

	public boolean addChild(MTreeNode child) {

		boolean success = addNewChild(root, child);
		return success;

	}

	private boolean addNewChild(MTreeNode root, MTreeNode child) {

		boolean success = false;
		if (root.children.size() == m) {
			for (int i = 0; i < m; i++) {
				root = root.children.get(i);
				if (root.children.size() == m) {
					addNewChild(root, child);
					break;
				} else {
					success = true;
					root.children.add(child);
					break;
				}
			}
		} else {
			success = true;
			root.children.add(child);
			return success;
		}

			return success;
	}

	public static void main(String[] args) {
		MTreeNode tree = new MTreeNode("A", 3);
		tree.root = tree;
		tree.addChild(new MTreeNode("B", 3));
		tree.addChild(new MTreeNode("C", 3));

		tree.addChild(new MTreeNode("D", 3));
		tree.addChild(new MTreeNode("E", 3));
		tree.addChild(new MTreeNode("F", 3));
		tree.addChild(new MTreeNode("G", 3));
		tree.addChild(new MTreeNode("H", 3));

		// print inorder traversal of the BST
		tree.inorder();
		// tree.preOrder();

		// tree.search(10);
	}

	/*
	 * MTreeNode() { root = null; }
	 * 
	 * void insert(int key) { root = insertRec(root, key); }
	 * 
	 * private Node insertRec(Node root, int key) {
	 * 
	 * if (root == null) { root = new Node(key); return root; }
	 * 
	 * if (root.key > key) { root.left = insertRec(root.left, key); } else { root.right = insertRec(root.right, key); }
	 * 
	 * return root; }
	 */
	// This method mainly calls InorderRec()

	void inorder() {
		inorderRec(root);
	}

	/*
	 * private void preOrder() { preOrderRec(root);
	 * 
	 * }
	 */

	/*
	 * private void preOrderRec(Node root) { if (root != null) { System.out.println(root.key); preOrderRec(root.left);
	 * 
	 * preOrderRec(root.right); } }
	 */
	// A utility function to do inorder traversal of BST

	void inorderRec(MTreeNode root) {
		if (root != null) {
			System.out.println(root.element);
			int i = 0;
			for (; i < m; i++) {
				if (!root.children.isEmpty()) {
					inorderRec(root.children.get(i));
				}
			}
			
			i = 0;
		}
	}

	/*
	 * private void search(int searchVal) { search(root, searchVal);
	 * 
	 * }
	 * 
	 * private void search(Node root, int searchVal) {
	 * 
	 * if (root == null) { System.out.println("element not found"); } else if (root.key == searchVal) {
	 * System.out.println("element found"); } else { if (searchVal > root.key) { search(root.right, searchVal); } else {
	 * search(root.left, searchVal); } }
	 * 
	 * }
	 * 
	 * public static void main(String[] args) { MTreeNode tree = new MTreeNode();
	 * 
	 * 
	 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
	 * 
	 * tree.insert(50); tree.insert(30); tree.insert(20); tree.insert(40); tree.insert(70); tree.insert(60);
	 * tree.insert(80);
	 * 
	 * // print inorder traversal of the BST // tree.inorder(); // tree.preOrder();
	 * 
	 * tree.search(10); }
	 */
}
