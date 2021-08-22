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

class PrintAllPathsToLeavesAndTheirDetailsOfaBinaryTree {
	static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
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

	static Node buildTree(int t[], int n) {
		Node node = null;
		node = insertLevelOrder(t, node, 0, n);
		return node;
	}

	/*
	 * class Node { int data; // data used as key value Node leftChild; Node
	 * rightChild; public Node() { data=0; } public Node(int d) { data=d; } } Above
	 * class is declared for use.
	 */
	static int length = 0;

	static void printAllPaths(Node root) {
		int path[] = new int[1000];
		printPathsRecur(root, path, 0);
		if (length != 0)
			System.out.print(length);
	}

	static void printPathsRecur(Node node, int path[], int pathLength) {
		if (node == null)
			return;
		path[pathLength] = node.data;
		pathLength++;
		if (node.leftChild == null && node.rightChild == null)
			printArray(path, pathLength);
		else {
			printPathsRecur(node.leftChild, path, pathLength);
			printPathsRecur(node.rightChild, path, pathLength);
		}
	}

	static void printArray(int path[], int pathLength) {
		length = Math.max(length, pathLength);
		for (int i = 0; i < pathLength; i++)
			System.out.print(path[i] + " ");
		System.out.print(pathLength - 1);
		System.out.println();
	}

	public static void main(String[] args) {
		int a[] = new int[10];
		int n, i;
		Scanner s = new Scanner(System.in);
		n = Integer.parseInt(s.nextLine().trim());
		for (i = 0; i < n; i++)
			a[i] = Integer.parseInt(s.nextLine().trim());
		Node root = null;
		if (n != 0)
			root = buildTree(a, n);
		printAllPaths(root);
		s.close();
	}
}