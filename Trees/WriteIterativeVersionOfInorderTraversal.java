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

class WriteIterativeVersionOfInorderTraversal {
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
	static void printInorder(Node root) {
		if (root == null)
			return;
		Stack<Node> s = new Stack<Node>();
		Node current = root;
		while (current != null || s.size() > 0) {
			while (current != null) {
				s.push(current);
				current = current.leftChild;
			}
			current = s.pop();
			System.out.print(current.data + " ");
			current = current.rightChild;
		}
	}

	public static void main(String[] args) {
		int a[] = new int[10];
		int n, i;
		Scanner s = new Scanner(System.in);
		n = Integer.parseInt(s.nextLine());
		for (i = 0; i < n; i++)
			a[i] = Integer.parseInt(s.nextLine());
		Node root = null;
		if (n != 0)
			root = buildTree(a, n);
		printInorder(root);
		s.close();
	}
}