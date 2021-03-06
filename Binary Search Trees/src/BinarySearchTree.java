public class BinarySearchTree {
	public Node root;
	
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	
	public Node find(int value, Node root) {
		if (root == null) {
			return root;
		}
		if (value==root.value) {
			return root;
		}else if(value < root.value) {
			return find(value,root.left);
		}else {
			return find(value,root.right);
		}
	}
	/**
	 * Adds an element into the tree.
	 * 
	 * @param value The element to be inserted in the tree.
	 * 
	 * @return True if the element was inserted; false if the value was already present.
	 */
	public boolean add(int value) {
		if (root == null) {
			root = new Node(value);
		}
		Node temp = find(value,root);
		if (temp==null) {
			temp=new Node(value);
			return true;
		}else {
			return false;
		}

	}
	

	/**
	 * Returns true if the value is contained in the tree.
	 * 
	 * @param value Value to be searched in the tree.
	 * 
	 * @return True if the value is contained in the tree.
	 */
	public boolean contains(int value) {
		Node temp = find(value,root);
		if (temp==null){
			return false;
		}else {
			return true;
		}
	}

	/**
	 * Returns the minimum value of the tree.
	 * 
	 * @return The minimum value of the tree, or -1 if the tree is empty.
	 */
	public int minimumValue(Node root) {
		if (root.left==null) {
			return root.value;
		}else {
			return minimumValue(root.left);
		}
	}
	public int minimumValue() {
		if(root == null) {
			return -1;
		}
		return minimumValue(root);
	}

	/**
	 * Returns the maximum value of the tree.
	 * 
	 * @return The maximum value of the tree, or -1 if the tree is empty.
	 */
	public int maximumValue(Node root) {
		if (root.right==null) {
			return root.value;
		}else {
			return maximumValue(root.right);
		}
	}
	public int maximumValue() {
		if(root == null) {
			return -1;
		}
		return maximumValue(root);
	}

	/**
	 * Removes an element from the tree.
	 * 
	 * @param value Value to be removed from the tree.
	 * 
	 * @return True if the value was removed; false if the value was not found.
	 */
	public boolean remove(int value) {
		if (find(value,root)==null) {
			return false;
		}
		return false;
	}

	public static void main(String args[]) {
		
		BinarySearchTree tree = new BinarySearchTree();
		
		System.out.println("Minimum: " + tree.minimumValue());
		System.out.println("Maximum: " + tree.maximumValue());
		
		System.out.println("Contains 5: " + tree.contains(5));
		
		System.out.println("Adding 5: " + tree.add(5));
		
		System.out.println("Contains 5:" + tree.contains(5));

		System.out.println("Adding 3: " + tree.add(3));
		System.out.println("Adding 7: " + tree.add(7));
		
		System.out.println("Minimum: " + tree.minimumValue());
		System.out.println("Maximum: " + tree.maximumValue());
		
		System.out.println("Adding 1: " + tree.add(1));
		System.out.println("Adding 4: " + tree.add(4));

		System.out.println("Removing 9:" + tree.remove(9));

		System.out.println("Removing 3:" + tree.remove(3));
		System.out.println("Removing 4:" + tree.remove(4));
		System.out.println("Removing 1:" + tree.remove(1));
		
		
	}
}
