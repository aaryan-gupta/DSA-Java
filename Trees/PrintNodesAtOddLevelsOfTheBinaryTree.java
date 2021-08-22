import java.util.*;

/*
 * class Node { int data; // data used as key value Node leftChild; Node
 * rightChild; public Node() { data=0; } public Node(int d) { data=d; } } Above
 * class is declared for use.
 */
class Result {
	static void printOdd(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		boolean isOdd = true;
		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;
			while (nodeCount > 0) {
				Node node = q.peek();
				if (isOdd == true)
					System.out.print(node.data + " ");
				q.remove();
				if (node.leftChild != null)
					q.add(node.leftChild);
				if (node.rightChild != null)
					q.add(node.rightChild);
				nodeCount--;
			}
			isOdd = !isOdd;
		}
	}
}

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

class PrintNodesAtOddLevelsOfTheBinaryTree {
	static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.leftChild);
			System.out.print(root.data + " ");
			inOrder(root.rightChild);
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

	public static void main(String[] args) {
		int a[] = new int[50];
		int n, i;
		Scanner s = new Scanner(System.in);
		n = Integer.parseInt(s.nextLine().trim());
		for (i = 0; i < n; i++)
			a[i] = s.nextInt();
		Node root = null;
		if (n != 0)
			root = buildTree(a, n);
		Result.printOdd(root);
		s.close();
	}
}