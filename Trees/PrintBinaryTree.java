import java.util.*;

class Node {
	int data; // data used as key value
	Node leftChild;
	Node rightChild;

	public Node() {
		data = 0;
	}

	public Node(int d) {
		data = d;
	}
}

class PrintBinaryTree {
	static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.leftChild);
			System.out.print(root.data + " ");
			inOrder(root.rightChild);
		}
	}

	/*
	 * class Node { int data; // data used as key value Node leftChild; Node
	 * rightChild; public Node() { data=0; } public Node(int d) { data=d; } } Above
	 * class is declared for use.
	 */
	static Node buildTree(int t[], int n) {
		Node node = null;
		// Complete the function body
		node = insertLevelOrder(t, node, 0, n);
		return node;
	}

	static Node insertLevelOrder(int arr[], Node root, int i, int n) {
		if (i < n) {
			Node temp = new Node(arr[i]);
			root = temp;
			root.leftChild = insertLevelOrder(arr, root.leftChild, 2 * i + 1, n);
			root.rightChild = insertLevelOrder(arr, root.rightChild, 2 * i + 2, n);
		}
		return root;
	}

	public static void main(String[] args) {
		int a[] = new int[10];
		int n, i;
		Scanner s = new Scanner(System.in);
		n = Integer.parseInt(s.nextLine().trim());
		for (i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s.nextLine().trim());
		}
		Node root = null;
		root = buildTree(a, n);
		inOrder(root);
		s.close();
	}
}